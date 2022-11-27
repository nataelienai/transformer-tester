package io.github.nataelienai.transformertester.transformer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransformerDto {

  @NotBlank(message = "Field 'name' must not be blank")
  private String name;

  @NotNull(message = "Field 'internalNumber' must not be null")
  private Double internalNumber;

  @NotNull(message = "Field 'tensionClass' must not be null")
  private Double tensionClass;

  @NotNull(message = "Field 'potency' must not be null")
  private Double potency;

  @NotNull(message = "Field 'current' must not be null")
  private Double current;

}
