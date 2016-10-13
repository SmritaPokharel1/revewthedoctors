package com.reviewthedoctors.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reviewthedoctors.api.ICityApi;
import com.reviewthedoctors.api.IDoctorApi;
import com.reviewthedoctors.api.IReviewApi;
import com.reviewthedoctors.api.IUserApi;
import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.DoctorDto;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.util.SessionUtil;
import com.reviewthedoctors.util.StringConstants;

/**
 * The <code>ReviewerController</code> has methods that are user specific. All the methods in this controller
 * are invoked by reviewer only. 
 * @author SmritaPokharel
 *
 */
@Controller
@RequestMapping("/reviewer")
public class ReviewerController {

	@Autowired
	private IReviewApi reviewApi;

	@Autowired
	private IDoctorApi doctorApi;

	@Autowired
	private IUserApi userApi;

	@Autowired
	private ICityApi cityApi;

	@RequestMapping(value = "myreviews", method = RequestMethod.GET)
	public ModelAndView getMyReviewsPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			String userName = SessionUtil.getCurrentUser().getEmail();
			List<ReviewDto> reviewDtoList = reviewApi.getCurrentUserReviewList(userName);
			
			ModelMap modelMap = new ModelMap();
			if(reviewDtoList.size()>0){
				modelMap.put("reviewList", reviewDtoList);
			}else{
				modelMap.put("message", "No reviews found. Please make a review first.");
			}
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_TITLE);

			return new ModelAndView("module/reviewer/myreviews", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public ModelAndView getMyProfilePage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			ModelMap modelMap = new ModelMap();
			modelMap.put("user", userApi.getUserByEmail(SessionUtil.getCurrentUser().getEmail()));
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_TITLE);
			return new ModelAndView("module/reviewer/profile", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "reviewfeed", method = RequestMethod.GET)
	public ModelAndView getReviewFeedPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			List<ReviewDto> reviewDtoList = reviewApi.getLatestReviewList();
			ModelMap modelMap = new ModelMap();
			if(reviewDtoList.size()>0){
				modelMap.put("reviewList", reviewDtoList);
			}else{
				modelMap.put("message", "No reviews found. Please make a review first.");
			}
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_TITLE);
			return new ModelAndView("module/reviewer/reviewfeed", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}


	@RequestMapping(value = "individualreview", method = RequestMethod.GET)
	public ModelAndView getIndividualReviewPage(HttpServletRequest request) {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			String reviewId = request.getParameter("reviewId");
			ReviewDto review = reviewApi.getReview(Long.parseLong(reviewId));
			ModelMap modelMap = new ModelMap();
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_SEARCH);
			modelMap.put("review", review);
			return new ModelAndView("module/reviewer/individualreview", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}


	@RequestMapping(value = "individualdoctor", method = RequestMethod.GET)
	public ModelAndView getIndividualDoctorPage(HttpServletRequest request) {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			String doctorId = request.getParameter("doctorId");
			DoctorDto doctor = doctorApi.getDoctor(Long.parseLong(doctorId), true);
			ModelMap modelMap = new ModelMap();
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_SEARCH);
			modelMap.put("doctor", doctor);
			return new ModelAndView("module/reviewer/individualdoctor", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "makeareview", method = RequestMethod.GET)
	public ModelAndView getMakeAReviewPage(ModelMap modelMap) {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
			modelMap.put(StringConstants.PAGE_TITLE, StringConstants.WEB_APP_SEARCH);
			modelMap.put("userRole", SessionUtil.getCurrentUser().getAuthority());
			return new ModelAndView("module/reviewer/makeareview", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "reviews", method = RequestMethod.POST)
	public String addReview(@ModelAttribute("review") ReviewDto review) {
		try {
			if (SessionUtil.getCurrentUser().getAuthority().equals(StringConstants.AUTHORITY_ROLE_USER)) {
				UserDto userDto = new UserDto();
				userDto.setEmail(SessionUtil.getCurrentUser().getEmail());
				review.setUser(userDto);
			}
			reviewApi.create(review);

		} catch (Exception expection) {
			expection.printStackTrace();
		}
		if (SessionUtil.getCurrentUser().getAuthority().equals(StringConstants.AUTHORITY_ROLE_USER)) {
			return "redirect:makeareview";
		} else {
			return "redirect:review";
		}
	}


	@ResponseBody
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public Map<String, List<UserDto>> getUserList(@RequestHeader("List_Type") String listType) {
		Map<String, List<UserDto>> userListMap = new HashMap<String, List<UserDto>>();
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)) {
			userListMap.put("userList", userApi.getAllUser());
		}
		return userListMap;
	}

	@ResponseBody
	@RequestMapping(value = "doctors", method = RequestMethod.GET)
	public Map<String, List<DoctorDto>> getDoctorList(@RequestHeader("List_Type") String listType,
			HttpServletRequest request) {
		Map<String, List<DoctorDto>> doctorListMap = new HashMap<String, List<DoctorDto>>();
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)) {
			doctorListMap.put("doctorList", doctorApi.getAllDoctors());
		}
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_SINGLE)) {
			String doctorId = request.getParameter("doctorId");
			DoctorDto doctorDto = doctorApi.getDoctor(Long.parseLong(doctorId));
			List<DoctorDto> doctorDtoList = new ArrayList<DoctorDto>();
			doctorDtoList.add(doctorDto);
			doctorListMap.put("doctorList", doctorDtoList);
		}
		return doctorListMap;
	}

	@ResponseBody
	@RequestMapping(value = "cities", method = RequestMethod.GET)
	public Map<String, List<CityDto>> getCityList(ModelMap modelMap, @RequestHeader("List_Type") String listType) {

		Map<String, List<CityDto>> cityListMap = new HashMap<String, List<CityDto>>();
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)) {
			cityListMap.put("cityList", cityApi.getAllCityList());
		}
		return cityListMap;
	}

}
