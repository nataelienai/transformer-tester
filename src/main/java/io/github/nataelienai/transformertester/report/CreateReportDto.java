package io.github.nataelienai.transformertester.report;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportDto {

  @NotBlank(message = "Field 'name' must not be blank")
  private String name;

  @NotBlank(message = "Field 'status' must not be blank")
  private String status;

  @NotBlank(message = "Field 'testId' must not be blank")
  private String testId;

}
