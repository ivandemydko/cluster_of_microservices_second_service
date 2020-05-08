package com.example.second_service.repository;


import model.secondmodel.SecondModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SecondModelRepository extends JpaRepository<SecondModel, Long> {

    SecondModel findByName(String name);
}
