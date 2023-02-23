package com.edu.springshop.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	//DAO 모델
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private PimgDAO pimgDAO;
	
	//FileManager 모델
	@Autowired
	private FileManager fileManager;
	
	
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
	public void regist(Product product, String dir) {
		//상품저장 (부모 Product)
		productDAO.insert(product);//select-key에 의해 pk존재하게 됨
		
		//파일저장 
		fileManager.save(product, dir);
		
		
		//이미지 저장 (Pimg)
		MultipartFile[] photoList=product.getPhoto();
		for(MultipartFile photo : photoList) {
			Pimg pimg = new Pimg();
			
			//pimgDAO.insert(pimg);
		}
		
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
