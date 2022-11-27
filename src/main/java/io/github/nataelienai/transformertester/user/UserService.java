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

  public User create(UserDto userDto) {
    boolean emailUsed = userRepository.existsByEmail(userDto.getEmail());
    if (emailUsed) {
      throw new EmailAlreadyUsedException(userDto.getEmail());
    }
    User user = new User(userDto.getName(), userDto.getEmail());
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());
  }

  public User updateById(String id, UserDto userDto) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

    String email = userDto.getEmail();
    if (!email.equals(user.getEmail())) {
      boolean emailUsed = userRepository.existsByEmail(email);
      if (emailUsed) {
        throw new EmailAlreadyUsedException(email);
      }
    }
    user.setName(userDto.getName());
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
