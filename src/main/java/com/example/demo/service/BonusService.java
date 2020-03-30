package com.example.demo.service;

import com.example.demo.model.BonusModel;

import java.util.List;
import java.util.Optional;

public interface BonusService {
    List<BonusModel> listALL();

    Optional<BonusModel> getById(Long id);

    BonusModel saveOrUpdate(BonusModel discount);

    void deleteById(Long id);


}
