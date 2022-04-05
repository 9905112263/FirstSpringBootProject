package com.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.UserDto;
import com.app.model.UserDetailsRequestModel;
import com.app.service.UserService;
import com.app.ui.model.response.UserRest;

@RestController	
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;
	public String getUser() {
		
		System.out.println("hellosjfjsdkl");
		
		return "get user was called";
	}
	
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetais) {
		UserRest returnedValue=new UserRest();
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetais, userDto);
		UserDto createUser=userService.createUser(userDto);
		
		 return returnedValue;
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
