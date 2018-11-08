package com.filedownloader_with_nio_package.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.springframework.stereotype.Service;

import com.filedownloader_with_nio_package.exceptions.FileNotDownloadedCorrectlyException;
import com.filedownloader_with_nio_package.model.FileDetails;
import com.filedownloader_with_nio_package.utils.Constants;

@Service
public class FileDownloadService {

	public String downloadFile(FileDetails fileDetails) {
		try {
            
			URL url = new URL(fileDetails.getFileUrl());
			ReadableByteChannel readableByteChannel = Channels.newChannel(url
					.openStream());
			String downloadedFile = fileDetails.getFileDownloadLocation() + "/"
					+ fileDetails.getFileName() + "."
					+ fileDetails.getFileType();
			FileOutputStream fileOutputStream = new FileOutputStream(
					downloadedFile);
			WritableByteChannel writableByteChannel = fileOutputStream.getChannel();
			//
			//
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (readableByteChannel.read(buffer)!=-1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					writableByteChannel.write(buffer);
					
				}
				buffer.clear();
			}
			//
			//		
			fileOutputStream.flush();
			fileOutputStream.close();
			return downloadedFile;
		} catch (MalformedURLException e) {
			throw new FileNotDownloadedCorrectlyException(
					Constants.FILE_NOT_DOWNLOADED_CORRECTLY, e);
		} catch (IOException e) {
			throw new FileNotDownloadedCorrectlyException(
					Constants.FILE_NOT_DOWNLOADED_CORRECTLY, e);
		}

	}
}
