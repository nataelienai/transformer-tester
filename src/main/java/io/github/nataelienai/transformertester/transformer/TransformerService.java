package io.github.nataelienai.transformertester.transformer;

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

  public Transformer create(CreateTransformerInputDto createTransformerInputDto) {
    User user = userRepository.findById(createTransformerInputDto.getUserId())
        .orElseThrow(() -> new UserNotFoundException());
    Transformer transformer = new Transformer(
        createTransformerInputDto.getName(),
        createTransformerInputDto.getInternalNumber(),
        createTransformerInputDto.getTensionClass(),
        createTransformerInputDto.getPotency(),
        createTransformerInputDto.getCurrent(),
        user
    );
    return transformerRepository.save(transformer);
  }

}
