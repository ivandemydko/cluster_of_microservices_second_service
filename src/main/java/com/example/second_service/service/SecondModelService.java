package com.example.second_service.service;


import model.secondmodel.SecondModel;

public interface SecondModelService {

    SecondModel findByName(String name);
}
