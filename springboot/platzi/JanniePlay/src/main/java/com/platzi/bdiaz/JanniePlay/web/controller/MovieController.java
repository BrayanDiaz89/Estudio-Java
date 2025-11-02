package com.platzi.bdiaz.JanniePlay.web.controller;

import com.platzi.bdiaz.JanniePlay.domain.dto.MovieRequestDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.MovieResponseDTO;
import com.platzi.bdiaz.JanniePlay.domain.dto.UpdateMovieDTO;
import com.platzi.bdiaz.JanniePlay.domain.service.logic.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
        return ResponseEntity.ok(this.movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
        var movieDto = this.movieService.getMovieById(id);
        return (movieDto == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieResponseDTO> addMovie(@RequestBody @Valid MovieRequestDTO movieRequestDTO,
                                                     UriComponentsBuilder uriComponentsBuilder){
        MovieResponseDTO movieCreated = movieService.addMovie(movieRequestDTO);
        URI uri = uriComponentsBuilder.path("/movies/{id}").buildAndExpand(movieCreated.id()).toUri();
        return ResponseEntity.created(uri).body(movieCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable Long id, @RequestBody @Valid UpdateMovieDTO updateMovieDTO){
        return ResponseEntity.ok(this.movieService.updateMovie(id, updateMovieDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        this.movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/status")
    public ResponseEntity deactivateMovie(@PathVariable Long id){
        this.movieService.deactivateMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<MovieResponseDTO> activateMovie(@PathVariable Long id){
        return ResponseEntity.ok(this.movieService.activateMovie(id));
    }

}
