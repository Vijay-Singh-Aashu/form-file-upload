package com.excellence.usernamelogin.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	boolean hasCsvFormat(MultipartFile file);

	void processAndSaveData(MultipartFile file);
}
