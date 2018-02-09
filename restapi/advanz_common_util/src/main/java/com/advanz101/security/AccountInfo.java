package com.advanz101.security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.advanz101.security.domain.Account;
import com.google.gson.Gson;

public class AccountInfo {
	
	public Account getAccount(String headerInfo,String url) {
		RestTemplate restTemplate = new RestTemplate();		
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.set("Authorization", headerInfo);    	
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
    	String result = restTemplate.postForObject(url, entity, String.class);
    	Gson gson = new Gson();
    	Account account = gson.fromJson(result, Account.class);
    	return account;
	}

}
