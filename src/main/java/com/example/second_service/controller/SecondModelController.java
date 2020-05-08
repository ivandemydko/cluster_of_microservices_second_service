package com.example.second_service.controller;


import com.example.second_service.service.FirstModelService;
import com.example.second_service.service.SecondModelService;
import model.AllModels;
import model.firstmodel.FirstModel;
import model.secondmodel.SecondModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecondModelController {

    @Autowired
    private SecondModelService secondModelService;

    @Autowired
    FirstModelService firstModelService;

    @Value("${example.value}")
    private String configExampleValue;

    @GetMapping("/secondModel/{name}")
    public SecondModel getModelByName(@PathVariable(name = "name") String name) {
        SecondModel secondModel = secondModelService.findByName(name);
        secondModel.setName(secondModel.getName() + " + " + configExampleValue);
        return secondModel;
    }

    @GetMapping("/allModels")
    public AllModels getAllModel() {
        FirstModel firstModel = firstModelService.getFirstModel();
        SecondModel secondModel = secondModelService.findByName("second_model_2");
        return new AllModels(firstModel, secondModel);
    }


}
