package io.github.nataelienai.transformertester.report;

import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import io.github.nataelienai.transformertester.test.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("reports")
public class Report {

  @Id
  private String id;

  private String name;

  private String status;

  @CreatedDate
  @Field("created_at")
  private Instant createdAt;

  @LastModifiedDate
  @Field("updated_at")
  private Instant updatedAt;

  @DocumentReference
  private Test test;

  public Report(String name, String status, Test test) {
    this.name = name;
    this.status = status;
    this.test = test;
  }

}
