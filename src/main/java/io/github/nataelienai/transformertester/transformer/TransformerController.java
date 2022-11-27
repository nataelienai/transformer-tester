package io.github.nataelienai.transformertester.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
      @RequestBody CreateTransformerInputDto createTransformerInputDto
  ) {
    return transformerService.create(createTransformerInputDto);
  }
}
