package io.github.nataelienai.transformertester.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User create(UserInputDto userInputDto) {
    boolean emailUsed = userRepository.existsByEmail(userInputDto.getEmail());
    if (emailUsed) {
      throw new EmailAlreadyUsedException(userInputDto.getEmail());
    }
    User user = new User(userInputDto.getName(), userInputDto.getEmail());
    return userRepository.save(user);
  }
}
