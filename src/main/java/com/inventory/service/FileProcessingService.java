package com.inventory.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import io.github.classgraph.Resource;

public interface FileProcessingService {
	
	public void init();
	
	public void save(MultipartFile file);
	
	public Resource load(String filename);
	
	public void deleteAll();
	
	public Stream<Path> loadAll();

}
