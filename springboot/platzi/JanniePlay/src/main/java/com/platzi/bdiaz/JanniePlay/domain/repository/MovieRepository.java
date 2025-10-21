package com.platzi.bdiaz.JanniePlay.domain.repository;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import jakarta.validation.Valid;

import java.util.List;


public interface MovieRepository {

    List<MovieResponseDTO> getAll();
    MovieResponseDTO findById(Long id);
    Boolean existsByTitle(String title);

    MovieResponseDTO save(MovieRequestDTO requestDTO);
}
