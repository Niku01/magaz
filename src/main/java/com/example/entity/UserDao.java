package com.example.entity;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niku on 01.04.2017.
 */
@Repository
public class UserDao {
    private static String PATHNAME = "jsons/users.json";
    private List<User> users;

    public UserDao() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        users = mapper.readValue(new File(PATHNAME), new TypeReference<List<User>>(){});
    }

    /**
     * find all users
     * @return
     */
    public List<User> findAll(){
        return users;
    }

    /**
     * find user by username
     * @param username
     * @return user by username or new user
     */
    public User findUserByUsername(String username){
        for(User user:findAll()){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return new User();
    }

    /**
     * find user by id
     * @param id
     * @return user by id or new user
     */
    public User findUserById(long id){
        for(User user:findAll()){
            if(user.getId() == id){
                return user;
            }
        }
        return new User();
    }

    /**
     * if id of the user != null update user
     * if id of the user is null add user
     * @param user
     */
    public void save(User user){
        if(user.getId() != 0) {
            for (int i = 0; i < users.size(); i++) {
                if(user.getId() == users.get(i).getId()){
                    users.set(i, user);
                    break;
                }
            }
        }else{
            user.setId(users.size() + 1);
            users.add(user);
        }
        updateJsonFile();
    }

    /**
     * update json file (users.json) with current array (List<User>)
     */
    private void updateJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATHNAME), users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete by id
     */
    public void delete(int id){
        for (int i = 0; i < users.size(); i++) {
            if(id == users.get(i).getId()){
                users.remove(i);
                break;
            }
        }
        updateJsonFile();
    }
}