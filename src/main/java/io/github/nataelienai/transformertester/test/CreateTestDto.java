package io.github.nataelienai.transformertester.test;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestDto {

  private String name;
  private String status;
  private Integer durationInSeconds;
  private List<String> transformerIds;

}
