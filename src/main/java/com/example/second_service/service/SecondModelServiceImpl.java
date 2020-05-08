package com.example.second_service.service;


import com.example.second_service.repository.SecondModelRepository;
import model.secondmodel.SecondModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondModelServiceImpl implements SecondModelService {

    @Autowired
    private SecondModelRepository secondModelRepository;

    @Override
    public SecondModel findByName(String name) {
        return secondModelRepository.findByName(name);
    }
}
