package com.platzi.bdiaz.JanniePlay.domain.dto;

import com.platzi.bdiaz.JanniePlay.domain.enums.Genre;

import java.time.LocalDate;

public record MovieRequestDTO(
        String title,
        Integer duration,
        Genre genre,
        Double rating,
        LocalDate releaseDate,
        Boolean isAvailable
) {
}
