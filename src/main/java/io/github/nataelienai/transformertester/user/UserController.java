package io.github.nataelienai.transformertester.user;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public User create(@Valid @RequestBody UserDto userDto) {
    return userService.create(userDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public User findById(@PathVariable("id") String id) {
    return userService.findById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public User updateById(
      @PathVariable("id") String id,
      @Valid @RequestBody UserDto userDto
  ) {
    return userService.updateById(id, userDto);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable("id") String id) {
    userService.deleteById(id);
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

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
    return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
  }

}
