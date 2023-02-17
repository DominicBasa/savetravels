package com.example.savetravels.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.savetravels.models.Save;
import com.example.savetravels.repositories.SaveRepository;

@Service
public class SaveService {
  
  @Autowired SaveRepository saveRepository;

  public void createSave(Save save) {
    saveRepository.save(save);
  }

  public List<Save> getAllSaves() {
    return saveRepository.findAll();
  }

  public Save findSave(Long id) {
    return null;
  }

  public void updateSave(@Valid Save save) {
  }
}
