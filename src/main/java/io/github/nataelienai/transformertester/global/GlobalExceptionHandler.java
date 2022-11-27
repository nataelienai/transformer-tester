package io.github.nataelienai.transformertester.global;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.github.nataelienai.transformertester.transformer.TransformerNotFoundException;
import io.github.nataelienai.transformertester.user.EmailAlreadyUsedException;
import io.github.nataelienai.transformertester.user.UserNotFoundException;

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

  @ExceptionHandler({
      UserNotFoundException.class,
      TransformerNotFoundException.class
  })
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleResourceNotFoundException(RuntimeException exception) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

  @ExceptionHandler(EmailAlreadyUsedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleEmailAlreadyUsedException(EmailAlreadyUsedException exception) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
  }

}
