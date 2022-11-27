package io.github.nataelienai.transformertester.transformer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransformerDto {

  private String name;
  private Double internalNumber;
  private Double tensionClass;
  private Double potency;
  private Double current;

}
