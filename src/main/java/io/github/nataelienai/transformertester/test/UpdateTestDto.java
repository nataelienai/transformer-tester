package io.github.nataelienai.transformertester.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTestDto {

  private String name;
  private String status;
  private Integer durationInSeconds;

}
