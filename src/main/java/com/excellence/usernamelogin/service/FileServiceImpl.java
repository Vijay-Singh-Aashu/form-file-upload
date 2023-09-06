package com.excellence.usernamelogin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.excellence.usernamelogin.entity.Bank;
import com.excellence.usernamelogin.repository.BankRepository;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private BankRepository bankRepository;

	@Override
	public boolean hasCsvFormat(MultipartFile file) {
		String type = "text/csv";
		if (!type.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	@Override
	public void processAndSaveData(MultipartFile file, String accountNumber, String bankName) {
	    try {
	        List<Bank> banks = csvToBanks(file.getInputStream(), accountNumber, bankName);
	        bankRepository.saveAll(banks);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private List<Bank> csvToBanks(InputStream inputStream, String accountNumber, String bankName) {
		try (BufferedReader filereReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				CSVParser csvParser = new CSVParser(filereReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Bank> banks = new ArrayList<Bank>();
			List<CSVRecord> records = csvParser.getRecords();
			for (CSVRecord csvRecord : records) {
				Bank bank = new Bank();
	            bank.setAccountNumber(accountNumber); // Set the account number
	            bank.setBankName(bankName); // Set the bank name
	            bank.setNaration(csvRecord.get("Narration"));
	            bank.setValueDate(csvRecord.get("Value Date"));
	            bank.setDebitAmount(csvRecord.get("Debit Amount"));
	            bank.setCheque(csvRecord.get("Chq/Ref Number"));
	            bank.setClosingBalance(csvRecord.get("Closing Balance"));
	            banks.add(bank);
			}
			return banks;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Bank> getAllInvoices() {
		return this.bankRepository.findAll();
	}


}