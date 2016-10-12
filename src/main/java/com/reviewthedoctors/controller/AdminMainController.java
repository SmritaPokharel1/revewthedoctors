package com.reviewthedoctors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.reviewthedoctors.api.impl.CountryApi;
import com.reviewthedoctors.util.SessionUtil;
import com.reviewthedoctors.util.StringConstants;

@Controller
@RequestMapping(value = "admin")
public class AdminMainController {

	@Autowired
	private CountryApi countryApi;

	@RequestMapping(value = "/document", method = RequestMethod.GET)
	public ModelAndView getDocumentPage() {
		return new ModelAndView("module/document/document", StringConstants.PAGE_TITLE, "Document");
	}

	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
	public ModelAndView getHospitalPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
			return new ModelAndView("module/hospital/hospital", StringConstants.PAGE_TITLE, "Hospital");
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView getReviewPage(ModelMap modelMap) {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
			modelMap.put("userRole", SessionUtil.getCurrentUser().getAuthority());
			modelMap.put(StringConstants.PAGE_TITLE, "Review");
			return new ModelAndView("module/review/review", modelMap);
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "/speciality", method = RequestMethod.GET)
	public ModelAndView getSpecialityPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
			return new ModelAndView("module/speciality/speciality", StringConstants.PAGE_TITLE, "Speciality");
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getUserPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/user/user", StringConstants.PAGE_TITLE, "User");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public ModelAndView getDoctorPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/doctor/doctor", StringConstants.PAGE_TITLE, "Doctor");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public ModelAndView getCountryPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/country/country", StringConstants.PAGE_TITLE, "Country");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	@RequestMapping(value = "/zone", method = RequestMethod.GET)
	public ModelAndView getZonePage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/zone/zone", StringConstants.PAGE_TITLE, "Zone");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	@RequestMapping(value = "/district", method = RequestMethod.GET)
	public ModelAndView getDistrictPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/district/district", StringConstants.PAGE_TITLE, "District");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public ModelAndView getCityPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/city/city", StringConstants.PAGE_TITLE, "City");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}
	
	
}
