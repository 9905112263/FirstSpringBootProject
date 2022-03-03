package com.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController	
@RequestMapping("users")
public class UserController {
	
	public String getUser() {
		
		return "get user was called";
	}
	
    public String createUser() {
		
		return "create user was called";
	}

    public String updateUser() {
	
	return "update user was called";
   }

   public String deleteUser() {
	
	return "delete user was called";
   }
   @RequestMapping("/test")
   public String test() {
	   System.out.println("methos called....");
	   return "index";
   }
   @RequestMapping("/test1")
   public ModelAndView test1() {
	   System.out.println("jkfhgdj");
	   ModelAndView mav=new ModelAndView("home");
	   return mav;
   }


}
