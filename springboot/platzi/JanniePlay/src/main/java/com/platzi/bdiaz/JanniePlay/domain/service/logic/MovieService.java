package com.platzi.bdiaz.JanniePlay.domain.service.logic;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import com.platzi.bdiaz.JanniePlay.domain.service.logic.validations.create.ValidationCreateMovie;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final List<ValidationCreateMovie> validators;
    private final MovieRepository movieRepository;

    public MovieService(List<ValidationCreateMovie> validators, MovieRepository movieRepository) {
        this.validators = validators;
        this.movieRepository = movieRepository;
    }

    public List<MovieResponseDTO> getAllMovies() {
        return this.movieRepository.getAll();
    }

    public MovieResponseDTO getMovieById(Long id) {
        return this.movieRepository.findById(id);
    }

    public MovieResponseDTO createMovie(@Valid MovieRequestDTO requestDTO) {
        validators.forEach(v -> v.validate(requestDTO));
        return this.movieRepository.save(requestDTO);
    }
}
