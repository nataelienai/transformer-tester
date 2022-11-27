package io.github.nataelienai.transformertester.transformer;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transformers")
public class TransformerController {

  private final TransformerService transformerService;

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

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Transformer> findAll() {
    return transformerService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Transformer findById(@PathVariable("id") String id) {
    return transformerService.findById(id);
  }

}
