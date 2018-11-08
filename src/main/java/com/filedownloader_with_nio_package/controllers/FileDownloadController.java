package com.filedownloader_with_nio_package.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filedownloader_with_nio_package.model.FileDetails;
import com.filedownloader_with_nio_package.services.FileDownloadService;

@RestController
public class FileDownloadController {

	@Autowired
	FileDownloadService fileDownloadService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(method = RequestMethod.POST, value = "/filedownload")
	public String downloadFile(@RequestBody FileDetails fileDetails) {
		return fileDownloadService.downloadFile(fileDetails);
	}

}
