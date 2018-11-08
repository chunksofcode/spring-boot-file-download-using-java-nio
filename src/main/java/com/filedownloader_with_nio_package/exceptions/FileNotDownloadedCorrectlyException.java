package com.filedownloader_with_nio_package.exceptions;

public class FileNotDownloadedCorrectlyException extends RuntimeException{

	public FileNotDownloadedCorrectlyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileNotDownloadedCorrectlyException(String message) {
		super(message);
		
	}

}
