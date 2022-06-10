package com.gourianova.reformatting.service;


import com.gourianova.reformatting.exception.TextNotFoundException;


import com.gourianova.reformatting.model.TextIn;
import com.gourianova.reformatting.repo.TextInRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TextService {
    private final TextInRepo textInRepo;
    private final static String FILE_NOT_FOUND_MSG =
            "file with title %s not found";

    @Autowired
    public TextService(TextInRepo textInRepo) {
        this.textInRepo = textInRepo;
    }

    public TextIn addTextIn(TextIn textIn) {
        return textInRepo.save(textIn);
    }

    public List<TextIn> findAllTextsIn() {
        return textInRepo.findAll();
    }

    public TextIn updateTextIn(TextIn textIn) {
        return textInRepo.save(textIn);
    }

    public TextIn findTextInById(Integer id) {
        return textInRepo.findTextInById(id).

                orElseThrow(() -> new TextNotFoundException("Text by id" + id + "not found"));

    }

    public void deleteText(Integer id) {
        this.findTextInById(id);
    }
}

