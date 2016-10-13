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

import com.reviewthedoctors.api.IHospitalApi;
import com.reviewthedoctors.model.dto.HospitalDto;
import com.reviewthedoctors.util.StringConstants;

/**
 * The class <code>AdminHospitalController</code> is a <code>SpringController</code> that has methods to add and list hospitals
 * @author SmritaPokharel
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminHospitalController {

	@Autowired
	private IHospitalApi hospitalApi;
	
	/**
	 * Persists <code>hospitalDto</code> to database. 
	 * @param hospitalDto the hospital that is to be persisted in the database
	 * @param redirectAttributes 
	 * @return
	 * @see RedirectAttributes
	 * @see ModelAttribute
	 */
	@RequestMapping(value="hospitals",method=RequestMethod.POST)
	public String addHospital(@ModelAttribute("hospital")HospitalDto hospitalDto,RedirectAttributes redirectAttributes){
		try{
			hospitalApi.create(hospitalDto);
			redirectAttributes.addFlashAttribute(StringConstants.MSG_SUCCESS,hospitalDto.getName()+" "+StringConstants.MSG_SUCCESS_CONTENT );
		}catch(Exception expection){
			redirectAttributes.addFlashAttribute(StringConstants.MSG_ERROR,hospitalDto.getName()+" "+StringConstants.MSG_ERROR_CONTENT );
			expection.printStackTrace();
		}
		return "redirect:hospital";
	}

	/**
	 * Retrieves the list of hospitals that are persisted in the database.
	 * @param listType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="hospitals",method=RequestMethod.GET)
	public Map<String,List<HospitalDto>> getHospitalList(@RequestHeader("List_Type") String listType){
		Map<String,List<HospitalDto>> hospitalListMap = new HashMap<String,List<HospitalDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			hospitalListMap.put("hospitalList",hospitalApi.getAllHospitals());
		}
		return hospitalListMap;
	}

}
