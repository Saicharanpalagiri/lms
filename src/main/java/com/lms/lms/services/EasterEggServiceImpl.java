package com.lms.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EasterEggServiceImpl implements EasterEggService{
    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "http://numbersapi.com/";

    @Override
    public String getFacts(long number) {
        // TODO Auto-generated method stub
        String apiUrl = API_URL + number+"?notfound=floor";
        System.out.println(apiUrl+" apiurl");
        String response = restTemplate.getForObject(apiUrl, String.class);
        return response;
    }
    
}
