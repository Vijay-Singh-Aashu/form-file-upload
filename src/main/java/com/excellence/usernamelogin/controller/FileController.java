package com.excellence.usernamelogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excellence.usernamelogin.entity.Bank;
import com.excellence.usernamelogin.response.ResponseMessage;
import com.excellence.usernamelogin.service.FileService;
import com.excellence.usernamelogin.service.FileServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/files")
public class FileController {

	@Autowired
	private FileService service;

	@Autowired
	private FileServiceImpl fileServiceImpl;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("accountNumber") String accountNumber, @RequestParam("bankName") String bankName) {
		if (service.hasCsvFormat(file)) {
			service.processAndSaveData(file, accountNumber, bankName);
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseMessage("Uploaded the file successfully:" + file.getOriginalFilename()));
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
				.body(new ResponseMessage("Please upload a CSV file"));
	}

	@GetMapping("/invoice")
	public List<Bank> getAllInvoices() {
		return this.fileServiceImpl.getAllInvoices();
	}

}
