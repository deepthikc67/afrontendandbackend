package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.niit.DAO.UserDAO;
import com.niit.Model.User;


@Controller
public class UserController  {

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model  user) {

		 user.addAttribute(" user", new User());

		return "user";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView user(@ModelAttribute User u) {
		ModelAndView u1 = new ModelAndView();
		userDAO.addUser(u);
		
		u1.setViewName("redirect:/userlist");
		return u1;

	}

	@RequestMapping("/list")
	public ModelAndView contactList() {
		ModelAndView cat = new ModelAndView();

		List<User> clist = userDAO.getUsers();

		for (User user : clist) {
			// System.out.println(user.getUserName()+"--------------------------------------------------------------------------");

		}

		cat.setViewName("userList");
		cat.addObject("userList", clist);
		return cat;
	}

	@RequestMapping("/deleteUser/{user}")
	public String deleteUser(@PathVariable("userID") int user) {
		userDAO.deleteUser(user);
		return "redirect:/userlist?del";
	}

	@RequestMapping("/updateUser/{userID}")
	public ModelAndView editView(@PathVariable("userID") int userID) {
		ModelAndView mav = new ModelAndView();

		User u1 = userDAO.getUser(userID);

		//cat.addObject("userlist", userDAO.getUsers());

		mav.addObject("ucat", u1);
		mav.setViewName("updateuser");
		return mav;
	}

	@RequestMapping(value = "/updateSUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("uu") User uu) {
		
		System.out.println(uu.getId()+"--------------"+uu.getName());
		
		System.out.println("called");
		ModelAndView mav = new ModelAndView();
		userDAO.updateUser(uu);

		mav.setViewName("redirect:/userlist?update");
	
		return mav;

	}
}
