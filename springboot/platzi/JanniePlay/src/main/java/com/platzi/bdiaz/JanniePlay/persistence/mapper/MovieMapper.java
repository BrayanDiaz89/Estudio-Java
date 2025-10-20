package com.platzi.bdiaz.JanniePlay.persistence.mapper;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.persistence.entitie.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, ContentStatusMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre") //Con qualifiedByName llamamos al metodo que convierte el String a enum
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    @Mapping(source = "contentStatus", target = "isAvailable", qualifiedByName = "stringToBoolean")
    MovieResponseDTO toDto(Movie movie);
    List<MovieResponseDTO> toDto(List<Movie> movies);
}
