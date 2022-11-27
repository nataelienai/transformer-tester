package io.github.nataelienai.transformertester.transformer;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.github.nataelienai.transformertester.global.ErrorResponse;
import io.github.nataelienai.transformertester.user.UserNotFoundException;

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
      @Valid @RequestBody CreateTransformerDto createTransformerDto
  ) {
    return transformerService.create(createTransformerDto);
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

}
