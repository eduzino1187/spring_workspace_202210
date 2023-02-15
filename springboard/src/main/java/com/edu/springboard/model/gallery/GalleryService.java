package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Gallery;

public interface GalleryService {
	public List selectAll(); //dao 동일.. 
	public Gallery select(int gallery_idx); //dao 동일 
	public void regist(Gallery gallery, String path); // insert + upload  
	public void update(Gallery gallery); //dao 와는 틀리다..
	public void delete(Gallery gallery); //db + file
}





