package com.edu.springshop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.edu.springshop.model.category.CategoryService;

/*
 * 쇼핑몰 어플리케이션에 전반적으로 적용될 수 있는 공통코드를 AOP의 
 * advice로 정의해놓고, 필요한 곳에 적용시켜본다...  
 * */
public class CategoryAdvice {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	private CategoryService categoryService;
	
	//아래의 메서드에서 서비스의 selectAll() 을 호출하여 ModelAndView에
	//저장하자
	public void getCategoryList(ProceedingJoinPoint joinPoint) {
		//원래 호출하려던 메서들 호출 전, 후에 관여할 수 있는 기능을 지원 
		
		String target=joinPoint.getTarget().getClass().getName();
		logger.info("target is "+target);
		
	}
	
	
	
	
}





