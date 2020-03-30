package com.example.demo.service;

import com.example.demo.model.BonusModel;
import com.example.demo.repository.BonusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BonusServiceImpl implements BonusService{
    private BonusRepository bonusRepository;

    @Override
    public List<BonusModel> listALL() {
        List<BonusModel> bonusModels = new ArrayList<>();
        bonusRepository.findAll().forEach(bonusModels::add);
        return bonusModels;
    }

    @Override
    public Optional<BonusModel> getById(Long id) {
        return bonusRepository.findById(id);
    }

    @Override
    public BonusModel saveOrUpdate(BonusModel discount) {
        bonusRepository.save(discount);
        return discount;
    }

    @Override
    public void deleteById(Long id) {
        bonusRepository.deleteById(id);
    }
    //repository should be used in service?
}
