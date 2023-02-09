package com.edu.mvc2.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//게시판의 목록 요청을 처리하는 하위 컨트롤러..
//2.x 방식
public class ListController implements Controller{
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("게시판 목록을 처리할께요");
		
		
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("/WEB-INF/views/    board/list    .jsp");
		mav.setViewName("board/list");
		
		return mav;
	}

}





