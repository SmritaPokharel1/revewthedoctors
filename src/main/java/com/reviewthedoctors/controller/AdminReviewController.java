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

import com.reviewthedoctors.api.IReviewApi;
import com.reviewthedoctors.model.dto.ReviewDto;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.util.SessionUtil;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value="/admin")
public class AdminReviewController {

	@Autowired
	private IReviewApi reviewApi;

	@RequestMapping(value = "reviews", method = RequestMethod.POST)
	public String addReview(@ModelAttribute("review") ReviewDto review,RedirectAttributes redirectAttributes) {
		try {
			if (SessionUtil.getCurrentUser().getAuthority().equals(StringConstants.AUTHORITY_ROLE_USER)) {
				UserDto userDto = new UserDto();
				userDto.setEmail(SessionUtil.getCurrentUser().getEmail());
				review.setUser(userDto);
			}
			reviewApi.create(review);
			redirectAttributes.addFlashAttribute(StringConstants.MSG_SUCCESS,"Review for doctor "+review.getDoctorId()+" "+StringConstants.MSG_SUCCESS_CONTENT);
		} catch (Exception expection) {
			expection.printStackTrace();
			redirectAttributes.addFlashAttribute(StringConstants.MSG_ERROR,"Review for doctor "+review.getDoctorId()+" "+StringConstants.MSG_ERROR_CONTENT);
		}
		if (SessionUtil.getCurrentUser().getAuthority().equals(StringConstants.AUTHORITY_ROLE_USER)) {
			return "redirect:reviewer/makeareview";
		} else {
			return "redirect:review";
		}
	}

	@ResponseBody
	@RequestMapping(value = "reviews", method = RequestMethod.GET)
	public Map<String, List<ReviewDto>> getReviewList(HttpServletRequest request,@RequestHeader("List_Type") String listType) {
		Map<String, List<ReviewDto>> reviewListMap = new HashMap<String, List<ReviewDto>>();
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)) {
			reviewListMap.put("reviewList", reviewApi.getAllReviews());
		}if(listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_SINGLE)){
			String reviewId = (String)request.getParameter("reviewId");
			ReviewDto review= reviewApi.getReview(Long.parseLong(reviewId));
			List<ReviewDto> reviewList = new ArrayList<ReviewDto>();
			reviewList.add(review);
			reviewListMap.put("reviewList", reviewList);
		}
		return reviewListMap;
	}
	
	@RequestMapping(value="individualreview",method=RequestMethod.GET)
	public ModelAndView getIndividualReviewPage(HttpServletRequest request){
		String reviewId = request.getParameter("reviewId");
		ReviewDto review = reviewApi.getReview(Long.parseLong(reviewId));
		ModelMap modelMap = new ModelMap();
		modelMap.put(StringConstants.PAGE_TITLE,StringConstants.WEB_APP_INDIVIDUAL_REVIEW);
		modelMap.put("review", review);
		return new ModelAndView("module/review/individualreview",modelMap);
	}

}
