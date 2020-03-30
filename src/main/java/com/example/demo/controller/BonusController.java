package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BonusModel;
import com.example.demo.repository.BonusRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController()
@RequestMapping("/v1")
@AllArgsConstructor
public class BonusController {

    private BonusRepository bonusRepository;

    @GetMapping("/bonus/{id}")
    public ResponseEntity<?> getBonusById(@PathVariable(value = "id") Long bonusId)
            throws ResourceNotFoundException {
        BonusModel bonusModel = bonusRepository.findById(bonusId)
                .orElseThrow(() -> new ResourceNotFoundException("Bonus not found for this id : " + bonusId));
        return new ResponseEntity<>(bonusModel, HttpStatus.OK);
    }

    @GetMapping("/{userid}/bonus")
    public ResponseEntity<?> getUserBonus(@PathVariable(value="userid") UUID userId)
        throws ResourceNotFoundException {
            BonusModel bonusModel = bonusRepository.findBonusByUserid(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("Bonus not found for user id : " + userId));
            return new ResponseEntity<>(bonusModel, HttpStatus.OK);
    }


    //todo: remove bonus arg and set param as UUID id
    @PostMapping("/bonus")
    public ResponseEntity<?> createBonus(@Valid @RequestBody BonusModel bonusModel) {
        bonusRepository.save(bonusModel);
        return new ResponseEntity<>(bonusModel, HttpStatus.OK);
    }

}
