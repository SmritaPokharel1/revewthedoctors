package com.reviewthedoctors.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reviewthedoctors.api.IDoctorApi;
import com.reviewthedoctors.api.IReviewApi;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.dto.SearchDto;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="reviewer")
public class SearchController {
	
	@Autowired
	private IReviewApi reviewApi;
	
	@Autowired
	private IDoctorApi doctorApi;
	
	@RequestMapping(value="searches",method=RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request,@ModelAttribute("search") SearchDto search){
		if(search.getSearchMainCriteria().equalsIgnoreCase(StringConstants.SEARCH_MAIN_CRITERIA_DOCTOR)){
			List<DoctorDto> doctorDtoList = doctorApi.searchDoctor(search.getSearchQuery());
			if(doctorDtoList.size()>0){
				ModelMap modelMap= new ModelMap();
				modelMap.put("searchList", doctorDtoList);
				return new ModelAndView("module/reviewer/searchresultdoctor",modelMap);
			}else{
				return new ModelAndView("module/reviewer/search","message","No result found.Please Search again!");
			}
		}else if(search.getSearchMainCriteria().equalsIgnoreCase(StringConstants.SEARCH_MAIN_CRITERIA_REVIEW)){
			List<ReviewDto> reviewDtoList = reviewApi.searchReview(search.getSearchQuery());
			if(reviewDtoList.size()>0){
				ModelMap modelMap= new ModelMap();
				modelMap.put("searchList", reviewDtoList);
				return new ModelAndView("module/reviewer/searchresultreview",modelMap);
			}else{
				return new ModelAndView("module/reviewer/search","message","No result found.Please Search again!");
			}
			
		}
		
		return new ModelAndView("module/reviewer/search","message","No result found.Please Search again!");
	}
	
	
	
	
}
