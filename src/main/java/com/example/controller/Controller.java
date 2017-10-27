package com.example.controller;

import com.example.entity.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.repository.WatchRepository;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	WatchRepository watchRepository;
	
	@RequestMapping("/")	
	public String showAll(Model model){
		model.addAttribute("watches", watchRepository.findAll());
		return "index";
	}
	
	@RequestMapping("/edit/{id}")	
	public String updateWatch(@PathVariable("id")int id, Model model){
		model.addAttribute("watch", watchRepository.findWatchById(id));
		return "edit";
	}
	@RequestMapping("/view/{id}")
	public String showOne(@PathVariable("id")int id, Model model){
		model.addAttribute("watch", watchRepository.findWatchById(id));
		return "view";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String saveUpdate(@PathVariable long id, @ModelAttribute("watch") Watch watch, Model model){
		watchRepository.save(watch);
		model.addAttribute("watches", watchRepository.findAll());
		return "redirect:/";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")int id, Model model){
		watchRepository.delete(id);
		model.addAttribute("watches", watchRepository.findAll());
		return "redirect:/";
	}

	@RequestMapping("/watch")
	public String watch(Model model){
		model.addAttribute("watches", watchRepository.findAll());
		return "watch";
	}
}


