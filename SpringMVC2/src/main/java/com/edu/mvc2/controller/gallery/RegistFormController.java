package com.edu.mvc2.controller.gallery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import lombok.Setter;

//겔러리 등록 요청을 처리하는 하위 컨트롤러
public class RegistFormController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("gallery/regist");
	}
}





