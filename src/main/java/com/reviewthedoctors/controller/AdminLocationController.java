package com.reviewthedoctors.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reviewthedoctors.api.ICityApi;
import com.reviewthedoctors.api.ICountryApi;
import com.reviewthedoctors.api.IDistrictApi;
import com.reviewthedoctors.api.IZoneApi;
import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.CountryDto;
import com.reviewthedoctors.model.dto.DistrictDto;
import com.reviewthedoctors.model.dto.ZoneDto;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="/admin")
public class AdminLocationController {
	
	@Autowired
	private ICountryApi countryApi;
	
	@Autowired
	private IZoneApi zoneApi;
	
	@Autowired
	private IDistrictApi districtApi;
	
	@Autowired
	private ICityApi cityApi;
	

	@RequestMapping(value="countries",method=RequestMethod.POST)
	public String addCountry(@ModelAttribute("country") CountryDto country,RedirectAttributes redirectAttributes){
		
		try{
			countryApi.create(country);
			redirectAttributes.addFlashAttribute("successMessage", country.getName()+" has been successfully saved.");
		}catch(Exception expection){
			expection.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMessage", country.getName()+" couldnot be saved.");
		}
		return "redirect:country";
	}
	
	@ResponseBody
	@RequestMapping(value="countries",method=RequestMethod.GET)
	public Map<String,List<CountryDto>> getCountryList(ModelMap modelMap,@RequestHeader("List_Type") String listType){
		Map<String,List<CountryDto>> countryListMap = new HashMap<String,List<CountryDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			countryListMap.put("countryList",countryApi.getAllCountryList());
		}
		return countryListMap;
	}
	
	@ResponseBody
	@RequestMapping(value="countries", method=RequestMethod.DELETE)
	public String deleteCountry(@RequestBody Long countryId){
		boolean operation = countryApi.delete(countryId);
		if(operation){
			return "Record has successfully been deleted";
		}else{
			return "Record couldnot be deleted.";
		}
	}
	
	@RequestMapping(value="zones",method=RequestMethod.POST)
	public String addZone(@ModelAttribute("zone") ZoneDto zone,RedirectAttributes redirectAttributes){
		try{
			zoneApi.create(zone);
			redirectAttributes.addFlashAttribute("successMessage", zone.getName()+" has been successfully saved.");
		}catch(Exception expection){
			redirectAttributes.addFlashAttribute("errorMessage", zone.getName()+" could not be saved.");
			expection.printStackTrace();
		}
		return "redirect:zone";
	}

	@ResponseBody
	@RequestMapping(value="zones",method=RequestMethod.GET)
	public Map<String,List<ZoneDto>> getZoneList(ModelMap modelMap,@RequestHeader("List_Type") String listType){
		Map<String,List<ZoneDto>> zoneListMap = new HashMap<String,List<ZoneDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			zoneListMap.put("zoneList",zoneApi.getAllZoneList());
		}
		return zoneListMap;
	}
	
	@RequestMapping(value="districts",method=RequestMethod.POST)
	public String addDistrict(@ModelAttribute("district") DistrictDto district,RedirectAttributes redirectAttributes){
		try{
			districtApi.create(district);
			redirectAttributes.addFlashAttribute("successMessage", district.getName()+" has been successfully saved.");
		}catch(Exception expection){
			redirectAttributes.addFlashAttribute("errorMessage", district.getName()+" could not be saved.");
			expection.printStackTrace();
		}
		return "redirect:district";
	}

	@ResponseBody
	@RequestMapping(value="districts",method=RequestMethod.GET)
	public Map<String,List<DistrictDto>> getDistrictList(ModelMap modelMap,@RequestHeader("List_Type") String listType){
		Map<String,List<DistrictDto>> districtListMap = new HashMap<String,List<DistrictDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			districtListMap.put("districtList",districtApi.getAllDistrictList());
		}
		return districtListMap;
	}
	
	@RequestMapping(value="cities",method=RequestMethod.POST)
	public String addCity(@ModelAttribute("city")CityDto city,HttpServletRequest request,RedirectAttributes redirectAttributes ){
		redirectAttributes.addFlashAttribute(StringConstants.PAGE_TITLE,"City");
		try{
			cityApi.create(city);
			redirectAttributes.addFlashAttribute("successMessage","City "+city.getName()+" has been successfully saved.");
		}catch(Exception expection){
			redirectAttributes.addFlashAttribute("errorMessage", "City "+city.getName()+" could not be saved.");
			expection.printStackTrace();
		}
		
		return "redirect:city";
	}

	@ResponseBody
	@RequestMapping(value="cities",method=RequestMethod.GET)
	public Map<String,List<CityDto>> getCityList(ModelMap modelMap,@RequestHeader("List_Type") String listType){
		Map<String,List<CityDto>> cityListMap = new HashMap<String,List<CityDto>>();
		if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)){
			cityListMap.put("cityList",cityApi.getAllCityList());
		}
		return cityListMap;
	}
}
