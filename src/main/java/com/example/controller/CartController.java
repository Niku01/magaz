package com.example.controller;

import com.example.repository.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    CartFacade cartFacade;

    @Autowired
    WatchRepository WatchRepository;

    @RequestMapping ("/addToCart/{id}")
    public String addToCart (@PathVariable("id") int id, Model model) {
        cartFacade.getCart().add(WatchRepository.findWatchById(id));
        model.addAttribute("watches", WatchRepository.findAll());
        return "redirect:/";
    }

    @RequestMapping ("/cart")
    public String cart (Model model) {
        model.addAttribute("cart", cartFacade.getCart());
        return "cart";
    }

    @RequestMapping ("/removeToCart")
    public String removeToCart (@RequestParam int id) {
        cartFacade.getCart().remove(WatchRepository.findWatchById(id));
        return "redirect:cart";
    }


}
