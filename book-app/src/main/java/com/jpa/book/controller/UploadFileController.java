package com.jpa.book.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.book.service.UploadFileService;

@RestController
@RequestMapping("/file")
public class UploadFileController {
	@Autowired
	private UploadFileService uploadFileService;
	@PostMapping("/upload")
	ResponseEntity<Object> uploadFile(@RequestParam Long id,@RequestParam String pathType,
			@RequestParam MultipartFile file){
		
		return ResponseEntity.ok(uploadFileService.storeFile
				(uploadFileService.convertMultiFileToFile(file), id, pathType));
	}
	@PostMapping("/multiFiles")
	public ResponseEntity<List<Object>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
			@RequestParam("id") Long id, @RequestParam String pathType) {
    
    List<Object> uploadedFiles = Arrays.stream(files)
            .map(file -> uploadFile(id, pathType, file))
            .collect(Collectors.toList());

    return ResponseEntity.ok(uploadedFiles);
}


}
