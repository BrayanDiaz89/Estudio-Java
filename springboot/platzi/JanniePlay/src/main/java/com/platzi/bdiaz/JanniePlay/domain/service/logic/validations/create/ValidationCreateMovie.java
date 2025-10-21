package com.platzi.bdiaz.JanniePlay.domain.service.logic.validations.create;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;

public interface ValidationCreateMovie {
    void validate(MovieRequestDTO requestDTO);
}
