package io.github.nataelienai.transformertester.report;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private final ReportService reportService;

  @Autowired
  public ReportController(ReportService reportService) {
    this.reportService = reportService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Report create(@Valid @RequestBody CreateReportDto createReportDto) {
    return reportService.create(createReportDto);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Report> findAll() {
    return reportService.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Report findById(@PathVariable("id") String id) {
    return reportService.findById(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Report updateById(
      @PathVariable("id") String id,
      @RequestBody UpdateReportDto updateReportDto
  ) {
    return reportService.updateById(id, updateReportDto);
  }

}
