package io.github.nataelienai.transformertester.global;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    FieldError fieldError = exception.getFieldError();
    if (fieldError == null) {
      return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed");
    }
    String message = fieldError.getDefaultMessage();
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
  }

}
