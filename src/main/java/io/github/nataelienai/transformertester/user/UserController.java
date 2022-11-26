package io.github.nataelienai.transformertester.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody UserInputDto userInputDto) {
    return userService.create(userInputDto);
  }

  @ExceptionHandler(EmailAlreadyUsedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleEmailAlreadyUsedException(EmailAlreadyUsedException exception) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
  }

}
