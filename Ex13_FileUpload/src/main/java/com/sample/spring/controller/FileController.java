package com.sample.spring.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.spring.service.FileDataService;

@RestController
@RequestMapping("/api")
public class FileController {
	
	@Autowired
	FileDataService fileDataService;
	
	
	@PostMapping("/file")
	public ResponseEntity<?> uploadImage(
			@RequestParam("images") List<MultipartFile> files
			) throws IOException{
		List<String> uploadResult = files.stream().map(
				file->{
					try {
						return fileDataService.uploadImageToFileSystem(file);
						
					}catch(IOException e){
						e.printStackTrace();
						return "failed to upload";
					}
					
				}
				).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(uploadResult);
	}
}
