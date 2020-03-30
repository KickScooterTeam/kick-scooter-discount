package com.example.demo.repository;

import com.example.demo.model.BonusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BonusRepository extends JpaRepository<BonusModel, Long> {
    //Jpa Repository allows to limit requests (e.g. provide pagination)
    //here standart CRUD doesn't require definition

    BonusModel findBonusByName(String name);
    Optional<BonusModel> findBonusByUserid(UUID userid);
}
