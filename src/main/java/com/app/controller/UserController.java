package com.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.UserDto;
import com.app.model.UserDetailsRequestModel;
import com.app.service.UserService;
import com.app.ui.model.response.ErrorMessages;
import com.app.ui.model.response.UserRest;
import com.app.ws.exception.UserServiceException;

@RestController	
@RequestMapping("users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@PathVariable String id) {
		
		UserRest returnValue=new UserRest();
		
		UserDto userDto=userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);
		System.out.println("hellosjfjsdkl");
		
		return returnValue;
	}
	@PostMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
	             consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetais) throws Exception
	{
		UserRest returnedValue=new UserRest();
		
		//if(userDetais.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if(userDetais.getFirstName().isEmpty()) throw new NullPointerException("Object is null");
		
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
