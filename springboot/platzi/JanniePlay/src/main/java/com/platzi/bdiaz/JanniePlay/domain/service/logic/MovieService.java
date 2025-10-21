package com.platzi.bdiaz.JanniePlay.domain.service.logic;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.UpdateMovieDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import com.platzi.bdiaz.JanniePlay.domain.service.logic.rules.ValidationCrudMovie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final List<ValidationCrudMovie> movieValidationRules;

    public MovieService(MovieRepository movieRepository, List<ValidationCrudMovie> movieValidationRules) {
        this.movieRepository = movieRepository;
        this.movieValidationRules = movieValidationRules;
    }

    public List<MovieResponseDTO> getAllMovies() {
        return this.movieRepository.getAll();
    }

    public MovieResponseDTO getMovieById(Long id) {
        return this.movieRepository.findById(id);
    }

    public MovieResponseDTO addMovie(MovieRequestDTO requestDTO){
        movieValidationRules.forEach(v-> v.validate(requestDTO));
        return this.movieRepository.save(requestDTO);
    }

    public MovieResponseDTO updateMovie(Long id, UpdateMovieDTO updateMovieDTO){
        return this.movieRepository.updateMovie(id, updateMovieDTO);
    }

}
