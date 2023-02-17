package com.example.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.savetravels.models.Save;

@Repository
public interface SaveRepository extends CrudRepository<Save, Long> {
  List<Save> findAll();
}
