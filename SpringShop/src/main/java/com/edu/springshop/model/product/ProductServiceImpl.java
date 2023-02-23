package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springshop.domain.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	//DAO 모델
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private PimgDAO pimgDAO;
	
	//FileManager 모델
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(Product product) {
		
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_idx) {
		// TODO Auto-generated method stub
		
	}
	
}
