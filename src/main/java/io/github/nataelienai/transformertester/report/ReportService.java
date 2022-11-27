package io.github.nataelienai.transformertester.report;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.nataelienai.transformertester.test.Test;
import io.github.nataelienai.transformertester.test.TestNotFoundException;
import io.github.nataelienai.transformertester.test.TestRepository;

@Service
public class ReportService {

  private final ReportRepository reportRepository;
  private final TestRepository testRepository;

  @Autowired
  public ReportService(
      ReportRepository reportRepository,
      TestRepository testRepository
  ) {
    this.reportRepository = reportRepository;
    this.testRepository = testRepository;
  }

  public Report create(CreateReportDto createReportDto) {
    Test test = testRepository.findById(createReportDto.getTestId())
        .orElseThrow(() -> new TestNotFoundException());
    Report report = new Report(
        createReportDto.getName(),
        createReportDto.getStatus(),
        test
    );
    return reportRepository.save(report);
  }

  public List<Report> findAll() {
    return reportRepository.findAll();
  }

  public Report findById(String id) {
    return reportRepository.findById(id)
        .orElseThrow(() -> new ReportNotFoundException());
  }
}
