package io.github.nataelienai.transformertester.test;

public class TestNotFoundException extends RuntimeException {

  public TestNotFoundException() {
    super("Test not found");
  }

}
