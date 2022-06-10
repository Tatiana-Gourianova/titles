package com.gourianova.reformatting.repo;


import com.gourianova.reformatting.model.TextIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TextInRepo extends JpaRepository<TextIn,Integer> {

    void deleteTextInById(Integer id);

    Optional<TextIn> findTextInById(Integer id);
}

