package io.github.nataelienai.transformertester.user;

import java.util.List;
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

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());
  }

  public User update(String id, UserInputDto userInputDto) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

    String email = userInputDto.getEmail();
    if (!email.equals(user.getEmail())) {
      boolean emailUsed = userRepository.existsByEmail(email);
      if (emailUsed) {
        throw new EmailAlreadyUsedException(email);
      }
    }
    user.setName(userInputDto.getName());
    user.setEmail(email);
    return userRepository.save(user);
  }

  public void deleteById(String id) {
    boolean idExists = userRepository.existsById(id);
    if (!idExists) {
      throw new UserNotFoundException();
    }
    userRepository.deleteById(id);
  }

}
