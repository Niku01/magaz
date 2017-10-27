package com.example.repository;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.Watch;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;

@Repository
public class WatchRepository {

	List<Watch> watches;
	public static final String PATHNAME = "data.json";

	public WatchRepository(){
		ObjectMapper mapper = new ObjectMapper();
        try {
			watches = mapper.readValue(new File(PATHNAME), new TypeReference<List<Watch>>(){});
        } catch (IOException e) {
            e.printStackTrace();
			watches = new ArrayList<>();
        }
    }

	public List<Watch> findAll(){
		return watches;
	}

	// delete by id
	public void delete(int id){
		for (int i = 0; i < watches.size(); i++) {
			if(id == watches.get(i).getId()){
				watches.remove(i);
				break;
			}
		}
        updateJsonFile();
	}

	public void save(Watch watch){
		if(watch.getId() != 0) {
			for (int i = 0; i < watches.size(); i++) {
				if(watch.getId() == watches.get(i).getId()){
					watches.set(i, watch);
					break;
				}
			}
		}else{
		    watch.setId(watches.size() + 1);
			watches.add(watch);
		}
        updateJsonFile();
	}

	public Watch findWatchById(int id){
		for(Watch watch:findAll()){
			if(watch.getId() == id){
				return watch;
			}
		}
		return new Watch();
	}

    private void updateJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(PATHNAME), watches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
