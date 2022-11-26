package io.github.nataelienai.transformertester.user;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
  public User create(@Valid @RequestBody UserInputDto userInputDto) {
    return userService.create(userInputDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> findAll() {
    return userService.findAll();
  }

  @ExceptionHandler(EmailAlreadyUsedException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ErrorResponse handleEmailAlreadyUsedException(EmailAlreadyUsedException exception) {
    return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    FieldError fieldError = exception.getFieldError();
    if (fieldError == null) {
      return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed");
    }
    String message = fieldError.getDefaultMessage();
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
  }
}
