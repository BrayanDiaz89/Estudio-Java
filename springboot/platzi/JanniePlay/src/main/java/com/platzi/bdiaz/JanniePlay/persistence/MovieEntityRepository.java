package com.platzi.bdiaz.JanniePlay.persistence;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.domain.repository.MovieRepository;
import com.platzi.bdiaz.JanniePlay.persistence.crud.CrudMovieEntity;
import com.platzi.bdiaz.JanniePlay.persistence.entitie.Movie;
import com.platzi.bdiaz.JanniePlay.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final MovieMapper movieMapper;
    private final CrudMovieEntity crudMovieEntity;

    public MovieEntityRepository(MovieMapper movieMapper, CrudMovieEntity crudMovieEntity) {
        this.movieMapper = movieMapper;
        this.crudMovieEntity = crudMovieEntity;
    }

    @Override
    public List<MovieResponseDTO> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieResponseDTO findById(Long id) {
         return this.crudMovieEntity.findById(id)
                 .map(movieMapper::toDto)
                 .orElse(null);
    }

    @Override
    public MovieResponseDTO save(MovieRequestDTO requestDTO) {
        Movie movie = movieMapper.toEntity(requestDTO);
        return this.movieMapper.toDto(crudMovieEntity.save(movie));
    }

    @Override
    public Boolean existsByTitle(String title) {
        return this.crudMovieEntity.existsByTitulo(title);
    }
}
