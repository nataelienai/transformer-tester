package io.github.nataelienai.transformertester.user;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
    super("User not found");
  }

}
