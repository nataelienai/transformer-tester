package io.github.nataelienai.transformertester.transformer;

public class TransformerNotFoundException extends RuntimeException {

  public TransformerNotFoundException() {
    super("Transformer not found");
  }

}
