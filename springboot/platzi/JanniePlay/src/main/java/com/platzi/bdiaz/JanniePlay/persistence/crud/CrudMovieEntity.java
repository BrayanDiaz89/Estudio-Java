package com.platzi.bdiaz.JanniePlay.persistence.crud;

import com.platzi.bdiaz.JanniePlay.persistence.entitie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMovieEntity extends JpaRepository<Movie, Long> {

    Boolean existsByTitulo(String title);
}
