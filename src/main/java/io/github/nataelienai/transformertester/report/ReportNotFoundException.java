package io.github.nataelienai.transformertester.report;

public class ReportNotFoundException extends RuntimeException {

  public ReportNotFoundException() {
    super("Report not found");
  }

}
