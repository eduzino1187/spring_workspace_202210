package com.edu.springboard.client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springboard.model.reboard.ReBoardService;

//답변게시판의 CRUD를 수행할 하위 컨트롤러
//component-scan 의 대상이 됨
@Controller 
public class ReBoardController {
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired  //xml에 빈을 등록한적 없으므로, 자동주입 받자 
	private ReBoardService reboardService;
	
	//목록 요청 처리 
	@RequestMapping(value="/reboard/list", method=RequestMethod.GET)
	public ModelAndView getList() {
		logger.info("목록요청 받음");
		
		List reboardList=reboardService.selectAll(); //3단계:일 시키기
		
		//4단계: 결과저장
		ModelAndView mav = new ModelAndView("reboard/list");
		mav.addObject("reboardList", reboardList);
		
		return mav;
	}
	
	//답변등록 요청
	/*
	 * 서비스의 존재가 없을 경우, 컨트롤러는 업무를 구체적으로 처리해야 
	 * 하므로 모델과 컨트롤러와 경계가 모호해진다. 따라서 추후 모델만 
	 * 다른 어플리케이션에 옮길 경우, 모델의 업무를 일부 수행하고 있는 
	 * 컨트롤러까지 같이 가져가야 하게된다..따라서  Controller 는 Model의
	 * 역할을 수행해서는 안된다...이러한 이유때문에 Service 가 존재해야 
	 * 하며, 서비스는 트랜잭션 처리도 담당한다..(서비스가 DAO 여러개를
	 * 거느리고 있기 때문에...)
	 * */
	@RequestMapping(value="/reboard/reply", method=RequestMethod.POST)
	public ModelAndView reply() {
		
		return null;
	}
}












