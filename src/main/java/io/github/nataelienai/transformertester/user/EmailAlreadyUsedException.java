package io.github.nataelienai.transformertester.user;

public class EmailAlreadyUsedException extends RuntimeException {

  public EmailAlreadyUsedException(String emailAddress) {
    super("Email address '" + emailAddress + "' is already being used");
  }

}
