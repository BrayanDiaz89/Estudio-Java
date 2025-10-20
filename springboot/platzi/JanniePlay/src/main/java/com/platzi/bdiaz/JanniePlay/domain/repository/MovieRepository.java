package com.platzi.bdiaz.JanniePlay.domain.repository;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import java.util.List;


public interface MovieRepository {

    List<MovieResponseDTO> getAll();
    MovieResponseDTO findById(Long id);

}
