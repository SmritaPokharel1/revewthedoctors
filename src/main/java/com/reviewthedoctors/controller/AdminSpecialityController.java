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

import com.reviewthedoctors.api.ISpecialityApi;
import com.reviewthedoctors.model.dto.SpecialityDto;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="/admin")
public class AdminSpecialityController {
	
	@Autowired
	private ISpecialityApi specialityApi;
	
	@RequestMapping(value="specialities",method=RequestMethod.POST)
	public String addCity(@ModelAttribute("speciality")SpecialityDto specialityDto,RedirectAttributes redirectAttributes){
		try{
			specialityApi.create(specialityDto);
			redirectAttributes.addFlashAttribute(StringConstants.MSG_SUCCESS,specialityDto.getSpecialityName()+" "+StringConstants.MSG_SUCCESS_CONTENT);
		}catch(Exception expection){
			expection.printStackTrace();
			redirectAttributes.addFlashAttribute(StringConstants.MSG_ERROR,specialityDto.getSpecialityName()+" "+StringConstants.MSG_ERROR_CONTENT);
		}
		return "redirect:speciality";
	}

	@ResponseBody
	@RequestMapping(value="specialities",method=RequestMethod.GET)
	public Map<String,List<SpecialityDto>> getCityList(@RequestHeader("List_Type") String listType){
		Map<String,List<SpecialityDto>> specialityListMap = new HashMap<String,List<SpecialityDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			specialityListMap.put("specialityList",specialityApi.getAllSpecialities());
		}
		return specialityListMap;
	}


}
