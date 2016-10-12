package com.reviewthedoctors.controller;

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

import com.reviewthedoctors.api.ICityApi;
import com.reviewthedoctors.api.IUserApi;
import com.reviewthedoctors.model.dto.CityDto;
import com.reviewthedoctors.model.dto.UserDto;
import com.reviewthedoctors.model.entity.User;
import com.reviewthedoctors.util.SessionUtil;
import com.reviewthedoctors.util.StringConstants;

@Controller
public class MainController {

	@Autowired
	private ICityApi cityApi;
	
	@Autowired
	private IUserApi userApi;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignupPage() {
		return "signup";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getLoginSignupPage() {
		if (SessionUtil.getCurrentUser() != null) {
			User user = SessionUtil.getCurrentUser();
			if (user.getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
				return new ModelAndView("module/country/country", StringConstants.PAGE_TITLE, "Country");
			}
			if (user.getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_USER)) {
				return new ModelAndView("module/reviewer/search", StringConstants.PAGE_TITLE,
						StringConstants.WEB_APP_SEARCH);
			}
		}
		return new ModelAndView("module/loginsignup/loginsignup", StringConstants.PAGE_TITLE,
				StringConstants.WEB_APP_TITLE);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String get403Page() {
		return "forbidden403";
	}

	@RequestMapping(value = "/logoutsuccess", method = RequestMethod.GET)
	public String getLogoutSuccessPage() {
		return "logoutsuccess";
	}

	@RequestMapping(value = "/suser/test", method = RequestMethod.GET)
	public String getUserPage() {
		return "user";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String get404Page() {
		return "pagenotfound404";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRootPage() {
		
		return "redirect:/home";
	}

	@ResponseBody
	@RequestMapping(value = "main/cities", method = RequestMethod.GET)
	public Map<String, List<CityDto>> getCityList(ModelMap modelMap, @RequestHeader("List_Type") String listType) {
		Map<String, List<CityDto>> cityListMap = new HashMap<String, List<CityDto>>();
		if (listType.equalsIgnoreCase(StringConstants.HEAD_PARAM_LIST_TYPE_MULTIPLE)) {
			cityListMap.put("cityList", cityApi.getAllCityList());
		}
		return cityListMap;
	}

	@RequestMapping(value = "main/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();

		return "redirect:/home";
	}
	
	@RequestMapping(value = "main/users", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserDto user) {
		try {
			userApi.create(user);

		} catch (Exception expection) {
			expection.printStackTrace();
		}
		return "redirect:/home";
	}

}
