package com.platzi.bdiaz.JanniePlay.web.exception;

import com.platzi.bdiaz.JanniePlay.domain.exception.TitleMovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TitleMovieAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleException(TitleMovieAlreadyExistsException ex){
        ErrorResponseDTO error = new ErrorResponseDTO("movie-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
