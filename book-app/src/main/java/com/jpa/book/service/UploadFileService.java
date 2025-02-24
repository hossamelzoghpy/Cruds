package com.jpa.book.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jpa.book.entity.Author;
import com.jpa.book.error.FileStorageException;

@Service
public class UploadFileService {
	
	Logger log=LoggerFactory.getLogger(UploadFileService.class);
	private Path filetorageLoaction;
	@Autowired
	private AuthorService authorService;
	//@Value("${file.upload.path}")
	private final String basePath="F:\\book\\";
	private Path location ;
	public String storeFile(File file,Long id,String pathType) {
		this.filetorageLoaction=Paths.get(basePath+pathType).toAbsolutePath().normalize();
		this.location=Paths.get(pathType).normalize();
		try {
			Files.createDirectories(this.filetorageLoaction);
			
		}catch(Exception ex) {
			throw new FileStorageException("Could not create direction to upload file",ex);
		}
		String fileName=StringUtils.cleanPath(id+"-"+file.getName());
		try {
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry file name contains invalid path "+fileName);
			}
			Path targetLocation=this.filetorageLoaction.resolve(fileName);
			Path dbLocation=this.location.resolve(fileName);
			InputStream inputStream=new FileInputStream(file);
			//باخد نسخه من الملف واحطها فى المكان بتاعى الجديد
			Files.copy(inputStream,targetLocation,StandardCopyOption.REPLACE_EXISTING);
			//After uploading take method of update author
			String newLocation=dbLocation.toString();
			updateImagePath(id,pathType,newLocation);
			return fileName;
		}catch(IOException ex){
			throw new FileStorageException("Could not store file : "+fileName+" Please try again!!",ex);
			
		}
	}
	public File convertMultiFileToFile(final MultipartFile multiFile) {
		final File file=new File(multiFile.getOriginalFilename());
		try(final FileOutputStream fileOutputStream=new FileOutputStream(file) ){
			fileOutputStream.write(multiFile.getBytes());
		}catch(final IOException ex) {
			log.error("Error converting multi file to file ",ex.getMessage());
			
		}
		return file;
		
	}
	public void updateImagePath(Long id,String pathType,String imagePath) {
		if(pathType.contains("author")) {
			Author author=authorService.getById(id);
			author.setImagePath(imagePath);
			authorService.update(author);
		}
		
		
	}

}
