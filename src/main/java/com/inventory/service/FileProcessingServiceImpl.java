package com.inventory.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.github.classgraph.Resource;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {
	
	//Path for uploading product images
	private static final String PATH_FILE= "D:\\ITS\\MY-PROJECTS\\SPRING_BOOT\\inventory\\src\\main\\resources\\static\\images\\product_img\\";
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(MultipartFile file) {
		try {
			byte[] fileSize = file.getBytes();
			Path path = Paths.get(PATH_FILE + file.getOriginalFilename());
			Files.write(path, fileSize);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Resource load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
