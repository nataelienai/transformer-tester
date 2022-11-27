package io.github.nataelienai.transformertester.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportDto {

  private String name;
  private String status;
  private String testId;

}