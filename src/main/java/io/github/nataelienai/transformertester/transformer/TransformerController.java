package io.github.nataelienai.transformertester.transformer;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.github.nataelienai.transformertester.user.ErrorResponse;

@RestController
@RequestMapping("/transformers")
public class TransformerController {

  private TransformerService transformerService;

  @Autowired
  public TransformerController(TransformerService transformerService) {
    this.transformerService = transformerService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Transformer create(
      @Valid @RequestBody CreateTransformerInputDto createTransformerInputDto
  ) {
    return transformerService.create(createTransformerInputDto);
  }

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
