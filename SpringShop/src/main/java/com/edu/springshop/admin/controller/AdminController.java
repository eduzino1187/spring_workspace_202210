package com.edu.springshop.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/loginform")
	public ModelAndView getLoginForm() {
		ModelAndView mav = new ModelAndView("admin/login/loginform");
		
		return mav;
	}
	
	@GetMapping("/main")
	public ModelAndView getMain() {
		logger.info("관리자 메인 호출됨");
		
		//로그인 인증 여부를 따져봐야 한다...
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/index");
		
		return mav;
	}
}




