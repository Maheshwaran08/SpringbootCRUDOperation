package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.HomeRepo;

import com.example.demo.model.Home;



@Controller
public class AddController {
	
	@Autowired
	HomeRepo homeRepo;

	


	@RequestMapping("/addUser")
	public String addAlien(Home home) {
		homeRepo.save(home);
		return "index.jsp";
	}
	@RequestMapping("/getUser")
	public ModelAndView getAlien(@RequestParam int id) {
		ModelAndView mv=new ModelAndView("Show.jsp");
		Home home=homeRepo.findById(id).orElse(new Home());
		mv.addObject(home);
		return mv;
	}
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mv=new ModelAndView("delete.jsp");
		Home home=homeRepo.findById(id).orElse(new Home());
		homeRepo.delete(home);	
		mv.addObject(home);
		return mv;
	}
	@RequestMapping("/updateValues")
	public ModelAndView UpdateUser(Home home) {
		
		ModelAndView mv=new ModelAndView("update.jsp");
		home=homeRepo.findById(home.getId()).orElse(new Home());
		homeRepo.deleteById(home.getId());	
		mv.addObject(home);
		return mv;
	}
	
	
	
}
