package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo getInfo(String id) {
		return blogDao.getInfo(id);
	}
	
	public void update(BlogVo blogVo, MultipartFile file) {
		
		if(file == null) {
			// 이미지 예외
			String id = blogVo.getId();
			BlogVo oldData = blogDao.getInfo(id);
			String oldLogoFile = oldData.getLogoFile();
			blogVo.setLogoFile(oldLogoFile);
			blogDao.update(blogVo);
		}else {
			if(blogVo.getBlogTitle() == null) {
				// 제목 예외
				String id = blogVo.getId();
				BlogVo oldData = blogDao.getInfo(id);
				String oldtitle = oldData.getBlogTitle();
				blogVo.setBlogTitle(oldtitle);
			}
			
			String saveDir = "/Users/jaykim0918/javaStudy/upload/";
			String orgName = file.getOriginalFilename();
			String exName = orgName.substring(orgName.lastIndexOf("."));
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			String filePath = saveDir + saveName;
			
			try {
				byte[] fileData = file.getBytes();
				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				bos.write(fileData);
				bos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			blogVo.setLogoFile(saveName);
			System.out.println("service : " + blogVo);
			blogDao.update(blogVo);
		}
		
		System.out.println("update : " + blogVo);
	}
	
	
	
	
	
}
