package com.excellence.usernamelogin.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.excellence.usernamelogin.entity.Bank;

public interface FileService {

	boolean hasCsvFormat(MultipartFile file);

	void processAndSaveData(MultipartFile file, String accountNumber, String bankName);

}
