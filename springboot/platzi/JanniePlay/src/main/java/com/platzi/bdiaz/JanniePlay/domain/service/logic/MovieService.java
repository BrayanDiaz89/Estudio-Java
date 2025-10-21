package com.platzi.bdiaz.JanniePlay.domain.service.logic;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResponseDTO> getAllMovies() {
        return this.movieRepository.getAll();
    }

    public MovieResponseDTO getMovieById(Long id) {
        return this.movieRepository.findById(id);
    }

    public MovieResponseDTO createMovie(@Valid MovieRequestDTO requestDTO) {
        return this.movieRepository.save(requestDTO);
    }
}
