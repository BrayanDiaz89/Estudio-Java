package com.platzi.bdiaz.JanniePlay.domain.service.logic.rules.create;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import com.platzi.bdiaz.JanniePlay.domain.service.logic.rules.ValidationCrudMovie;
import org.springframework.stereotype.Component;

@Component
public class ValidationTitleExists implements ValidationCrudMovie {

    private final MovieRepository movieRepository;

    public ValidationTitleExists(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void validate(MovieRequestDTO movieRequestDTO) {
        if(movieRepository.existsByTitle(movieRequestDTO.title())){
            throw new IllegalArgumentException("Title already exists");
        }
    }
}
