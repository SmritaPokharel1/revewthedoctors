package com.reviewthedoctors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.reviewthedoctors.util.SessionUtil;
import com.reviewthedoctors.util.StringConstants;

/**
 * The class <code>AdminMainController</code> is a <code>SpringController</code> that has methods to display different forms to add or list entities of the application. 
 *
 */
@Controller
@RequestMapping(value = "admin")
public class AdminMainController {


	@RequestMapping(value = "/document", method = RequestMethod.GET)
	public ModelAndView getDocumentPage() {
		return new ModelAndView("module/document/document", StringConstants.PAGE_TITLE, "Document");
	}

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list hospital if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
	public ModelAndView getHospitalPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
			return new ModelAndView("module/hospital/hospital", StringConstants.PAGE_TITLE, "Hospital");
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list review if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
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

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list Specialty if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/speciality", method = RequestMethod.GET)
	public ModelAndView getSpecialityPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
			return new ModelAndView("module/speciality/speciality", StringConstants.PAGE_TITLE, "Speciality");
		} else {
			return new ModelAndView("pagenotfound404");
		}
	}

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list user if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getUserPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/user/user", StringConstants.PAGE_TITLE, "User");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list doctor if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public ModelAndView getDoctorPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/doctor/doctor", StringConstants.PAGE_TITLE, "Doctor");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}
	
	

	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list country if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
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


	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list district if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/district", method = RequestMethod.GET)
	public ModelAndView getDistrictPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/district/district", StringConstants.PAGE_TITLE, "District");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}


	/**
	 * Returns <code>ModelAndView</code> of the form to either create or list city if the request is sent by an authenticated user.In case the user is not authenticated 404 page is returned.
	 * @return <code>ModelAndView</code>
	 * @see ModelAndView
	 */
	@RequestMapping(value = "/city", method = RequestMethod.GET)
	public ModelAndView getCityPage() {
		if (SessionUtil.getCurrentUser().getAuthority().equalsIgnoreCase(StringConstants.AUTHORITY_ROLE_ADMIN)) {
		return new ModelAndView("module/city/city", StringConstants.PAGE_TITLE, "City");
	} else {
		return new ModelAndView("pagenotfound404");
	}
	}
	
	
}
