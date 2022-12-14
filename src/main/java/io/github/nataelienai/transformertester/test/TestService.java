package io.github.nataelienai.transformertester.test;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.nataelienai.transformertester.transformer.Transformer;
import io.github.nataelienai.transformertester.transformer.TransformerNotFoundException;
import io.github.nataelienai.transformertester.transformer.TransformerRepository;

@Service
public class TestService {

  private final TestRepository testRepository;
  private final TransformerRepository transformerRepository;

  @Autowired
  public TestService(
      TestRepository testRepository,
      TransformerRepository transformerRepository
  ) {
    this.testRepository = testRepository;
    this.transformerRepository = transformerRepository;
  }

  public Test create(CreateTestDto createTestDto) {
    List<String> transformerIds = createTestDto.getTransformerIds();
    List<Transformer> transformers = transformerRepository.findAllById(transformerIds);
    if (transformers.size() != transformerIds.size()) {
      throw new TransformerNotFoundException();
    }
    Test test = new Test(
        createTestDto.getName(),
        createTestDto.getStatus(),
        createTestDto.getDurationInSeconds(),
        transformers
    );
    return testRepository.save(test);
  }

  public List<Test> findAll() {
    return testRepository.findAll();
  }

  public Test findById(String id) {
    return testRepository.findById(id)
        .orElseThrow(() -> new TestNotFoundException());
  }

  public Test updateById(String id, UpdateTestDto updateTestDto) {
    Test test = testRepository.findById(id)
        .orElseThrow(() -> new TestNotFoundException());
    test.setName(updateTestDto.getName());
    test.setStatus(updateTestDto.getStatus());
    test.setDurationInSeconds(updateTestDto.getDurationInSeconds());
    return testRepository.save(test);
  }

  public void deleteById(String id) {
    boolean idExists = testRepository.existsById(id);
    if (!idExists) {
      throw new TestNotFoundException();
    }
    testRepository.deleteById(id);
  }

}
