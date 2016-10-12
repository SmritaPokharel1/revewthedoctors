package com.reviewthedoctors.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reviewthedoctors.api.IDoctorApi;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="/admin")
public class AdminDoctorController {
	
	@Autowired
	private IDoctorApi doctorApi;
	
	@RequestMapping(value="doctors",method=RequestMethod.POST)
	public String addDoctor(@ModelAttribute("doctor")DoctorDto doctor,RedirectAttributes redirectAttributes ){
		try{
			doctorApi.create(doctor);
			redirectAttributes.addFlashAttribute(StringConstants.MSG_SUCCESS,doctor.getFirstName()+" "+doctor.getLastName()+" has been successfully saved.");
		}catch(Exception expection){
			expection.printStackTrace();
			redirectAttributes.addFlashAttribute(StringConstants.MSG_ERROR,doctor.getFirstName()+" "+doctor.getLastName()+" couldnot be saved.");
		}
		return "redirect:doctor";
	}

	@ResponseBody
	@RequestMapping(value="doctors",method=RequestMethod.GET)
	public Map<String,List<DoctorDto>> getCityList(@RequestHeader("List_Type") String listType,HttpServletRequest request){
		Map<String,List<DoctorDto>> doctorListMap = new HashMap<String,List<DoctorDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			doctorListMap.put("doctorList",doctorApi.getAllDoctors());
		}
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_SINGLE)){
			String doctorId = request.getParameter("doctorId");
			DoctorDto doctorDto = doctorApi.getDoctor(Long.parseLong(doctorId));
			List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();	
			doctorDtoList.add(doctorDto);
			doctorListMap.put("doctorList",doctorDtoList);
		}
		return doctorListMap;
	}
	
	@RequestMapping(value="individualdoctor",method=RequestMethod.GET)
	public ModelAndView getIndividualDoctorPage(HttpServletRequest request){
		String doctorId = request.getParameter("doctorId");
		DoctorDto doctor = doctorApi.getDoctor(Long.parseLong(doctorId),true);
		ModelMap modelMap = new ModelMap();
		modelMap.put(StringConstants.PAGE_TITLE,StringConstants.WEB_APP_INDIVIDUAL_DOCTOR);
		modelMap.put("doctor", doctor);
		return new ModelAndView("module/doctor/individualdoctor",modelMap);
	}

}
