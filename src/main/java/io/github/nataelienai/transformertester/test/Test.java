package io.github.nataelienai.transformertester.test;

import java.time.Instant;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import io.github.nataelienai.transformertester.transformer.Transformer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("tests")
public class Test {

  @Id
  private String id;

  private String name;

  private String status;

  @Field("duration_in_seconds")
  private Integer durationInSeconds;

  @CreatedDate
  @Field("created_at")
  private Instant createdAt;

  @LastModifiedDate
  @Field("updated_at")
  private Instant updatedAt;

  @DocumentReference
  private List<Transformer> transformers;

  public Test(String name, String status, Integer durationInSeconds,
      List<Transformer> transformers) {
    this.name = name;
    this.status = status;
    this.durationInSeconds = durationInSeconds;
    this.transformers = transformers;
  }

}
