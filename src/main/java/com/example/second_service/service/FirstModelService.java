package com.example.second_service.service;

import model.firstmodel.FirstModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class FirstModelService {


    @Value("${firstServiceURL}")
    private String firstServiceURL;

    @Autowired
    private OAuth2RestTemplate clientForFirstService;

    public FirstModel getFirstModel() {
        HttpEntity<FirstModel> request = new HttpEntity<>(null, null);
        String url = firstServiceURL+"/firstModel/first_model_1";
        return clientForFirstService.exchange(url, HttpMethod.GET, request, FirstModel.class).getBody();
    }
}
