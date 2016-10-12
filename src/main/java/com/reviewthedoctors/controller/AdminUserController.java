package com.reviewthedoctors.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reviewthedoctors.api.IUserApi;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="/admin")
public class AdminUserController {
	
	@Autowired
	private IUserApi userApi;
	
	@RequestMapping(value="users",method=RequestMethod.POST)
	public String addCity(@ModelAttribute("user")UserDto user,RedirectAttributes redirectAttributes ){
		try{
			userApi.create(user);
			redirectAttributes.addFlashAttribute(StringConstants.MSG_SUCCESS,user.getFirstName()+" "+user.getLastName()+" "+StringConstants.MSG_SUCCESS_CONTENT);
		}catch(Exception expection){
			expection.printStackTrace();
			redirectAttributes.addFlashAttribute(StringConstants.MSG_ERROR,user.getFirstName()+" "+user.getLastName()+" "+StringConstants.MSG_ERROR_CONTENT);
		}
		return "redirect:user";
	}

	@ResponseBody
	@RequestMapping(value="users",method=RequestMethod.GET)
	public Map<String,List<UserDto>> getCityList(@RequestHeader("List_Type") String listType){
		Map<String,List<UserDto>> userListMap = new HashMap<String,List<UserDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			userListMap.put("userList",userApi.getAllUser());
		}
		return userListMap;
	}

}
