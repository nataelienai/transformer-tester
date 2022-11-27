package io.github.nataelienai.transformertester.test;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestDto {

  @NotBlank(message = "Field 'name' must not be blank")
  private String name;

  @NotBlank(message = "Field 'status' must not be blank")
  private String status;

  @NotNull(message = "Field 'durationInSeconds' must not be null")
  private Integer durationInSeconds;

  @NotEmpty(message = "Field 'transformerIds' must contain at least one transformer id")
  private List<String> transformerIds;

}
