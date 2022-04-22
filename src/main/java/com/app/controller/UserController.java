package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.UserDto;
import com.app.model.UserDetailsRequestModel;
import com.app.service.UserService;
import com.app.ui.model.response.OperationStatusModel;
import com.app.ui.model.response.RequestOperationName;
import com.app.ui.model.response.RequestOperationStatus;
import com.app.ui.model.response.UserRest;

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
		BeanUtils.copyProperties(createUser, returnedValue);
		 return returnedValue;
	}
    @PutMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            consumes= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String id,@RequestBody UserDetailsRequestModel userDetais) {
	
        UserRest returnedValue=new UserRest();
		
		//if(userDetais.getFirstName().isEmpty()) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		if(userDetais.getFirstName().isEmpty()) throw new NullPointerException("Object is null");
		
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetais, userDto);
		UserDto updateUser=userService.updateUser(id,userDto);
		BeanUtils.copyProperties(updateUser, returnedValue);
    	
	return returnedValue;
   }
   @DeleteMapping(path="/{id}",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
   public OperationStatusModel deleteUser(@PathVariable String id) {
	
	   OperationStatusModel returnValue=new OperationStatusModel();
	   
	   returnValue.setOperationName(RequestOperationName.DELETE.name());
	   
	   userService.deleteUser(id);
	   returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
	   
	return null;
   }
   
   @GetMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
   public List<UserRest> getUsers(@RequestParam(value="page",defaultValue="1")int page,@RequestParam(value="limit",defaultValue="25")int limit){
	   
	   List<UserRest> returnValue=new ArrayList();
	   List<UserDto> users=userService.getUsers(page,limit);
	   for(UserDto userDto:users) {
		   UserRest userModel=new UserRest();
		   BeanUtils.copyProperties(userDto, userModel);
	   }
	   
	   return returnValue;
	   
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
