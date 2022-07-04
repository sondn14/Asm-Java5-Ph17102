package com.asm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asm.model.User;

@Component
public class AdminIntercepter implements HandlerInterceptor{

		@Autowired
		HttpSession session;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			System.out.println(request.getRequestURI());
			User user = (User) session.getAttribute("userSession");
			if(session.getAttribute("userSession") != null && user.getRole() == 0) {
				return true;
			}

			session.setAttribute("redirect-uri", request.getRequestURI());
			response.sendRedirect("/login");
			return false;
		}
		
		
}
