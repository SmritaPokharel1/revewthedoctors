package com.reviewthedoctors.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;


	public class WebAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
		
		private RequestCache requestCache = new HttpSessionRequestCache();

		@Override
		public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
				Authentication authentication) throws ServletException, IOException {
			logger.debug("in onAuthenticationSuccess==>");
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			logger.debug("savedRequest==>" + savedRequest);
			if (savedRequest == null) {
				super.onAuthenticationSuccess(request, response, authentication);
				return;
			}
			String targetUrlParameter = getTargetUrlParameter();
			logger.debug("targetUrlParameter==>" + targetUrlParameter);
			logger.debug("isAlwaysUseDefaultTargetUrl()==>" + isAlwaysUseDefaultTargetUrl());
			if (isAlwaysUseDefaultTargetUrl()
					|| (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
				requestCache.removeRequest(request, response);
				super.onAuthenticationSuccess(request, response, authentication);
				return;
			}
			clearAuthenticationAttributes(request);
			String targetUrl = savedRequest.getRedirectUrl();
			logger.debug("targetUrl==>" + targetUrl);
			getRedirectStrategy().sendRedirect(request, response, targetUrl);
		}

		public void setRequestCache(RequestCache requestCache) {
			this.requestCache = requestCache;
		}
		
		
}