package io.github.nataelienai.transformertester.transformer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.nataelienai.transformertester.user.User;
import io.github.nataelienai.transformertester.user.UserNotFoundException;
import io.github.nataelienai.transformertester.user.UserRepository;

@Service
public class TransformerService {

  private final TransformerRepository transformerRepository;
  private final UserRepository userRepository;

  @Autowired
  public TransformerService(
      TransformerRepository transformerRepository,
      UserRepository userRepository
  ) {
    this.transformerRepository = transformerRepository;
    this.userRepository = userRepository;
  }

  public Transformer create(CreateTransformerDto createTransformerDto) {
    User user = userRepository.findById(createTransformerDto.getUserId())
        .orElseThrow(() -> new UserNotFoundException());
    Transformer transformer = new Transformer(
        createTransformerDto.getName(),
        createTransformerDto.getInternalNumber(),
        createTransformerDto.getTensionClass(),
        createTransformerDto.getPotency(),
        createTransformerDto.getCurrent(),
        user
    );
    return transformerRepository.save(transformer);
  }

  public List<Transformer> findAll() {
    return transformerRepository.findAll();
  }

  public Transformer findById(String id) {
    return transformerRepository.findById(id)
        .orElseThrow(() -> new TransformerNotFoundException());
  }

  public Transformer updateById(String id, UpdateTransformerDto updateTransformerDto) {
    Transformer transformer = transformerRepository.findById(id)
        .orElseThrow(() -> new TransformerNotFoundException());
    transformer.setName(updateTransformerDto.getName());
    transformer.setInternalNumber(updateTransformerDto.getInternalNumber());
    transformer.setTensionClass(updateTransformerDto.getTensionClass());
    transformer.setPotency(updateTransformerDto.getPotency());
    transformer.setCurrent(updateTransformerDto.getCurrent());
    return transformerRepository.save(transformer);
  }

}
