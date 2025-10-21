package com.platzi.bdiaz.JanniePlay.domain.service.logic.validations.create;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidateTitleExists implements ValidationCreateMovie {

    private final MovieRepository movieRepository;

    public ValidateTitleExists(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void validate(MovieRequestDTO requestDTO) {
        if (movieRepository.existsByTitle(requestDTO.title())){
            throw new IllegalArgumentException("El titulo ya existe");
        }
    }
}
