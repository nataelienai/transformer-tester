package io.github.nataelienai.transformertester.test;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController {

  private final TestService testService;

  @Autowired
  public TestController(TestService testService) {
    this.testService = testService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Test create(@Valid @RequestBody CreateTestDto createTestDto) {
    return testService.create(createTestDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Test> findAll() {
    return testService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Test findById(@PathVariable("id") String id) {
    return testService.findById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Test updateById(
      @PathVariable("id") String id,
      @Valid @RequestBody UpdateTestDto updateTestDto
  ) {
    return testService.updateById(id, updateTestDto);
  }

}
