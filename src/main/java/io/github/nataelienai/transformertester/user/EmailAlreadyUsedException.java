package io.github.nataelienai.transformertester.user;

public class EmailAlreadyUsedException extends RuntimeException {

  public EmailAlreadyUsedException() {
    super("Email address is already being used");
  }

}
