package com.practice.springboot.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.practice.springboot.repository.LogRepository;

@SuppressWarnings("deprecation")
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURI().toString();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username="";
		if(auth != null && auth.isAuthenticated()) {
			username=auth.getName();
		}
		logRepository.save(new com.practice.springboot.entity.Log(new Date(), auth.getDetails().toString(), username, url));
		
		LOG.info("Url to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
	}
	
}
