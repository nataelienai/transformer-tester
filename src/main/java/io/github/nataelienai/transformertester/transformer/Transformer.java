package io.github.nataelienai.transformertester.transformer;

import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import io.github.nataelienai.transformertester.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("transformers")
public class Transformer {

  @Id
  private String id;

  private String name;

  @Field("internal_number")
  private Double internalNumber;

  @Field("tension_class")
  private Double tensionClass;

  private Double potency;

  private Double current;

  @CreatedDate
  @Field("created_at")
  private Instant createdAt;

  @LastModifiedDate
  @Field("updated_at")
  private Instant updatedAt;

  @DocumentReference
  private User user;

  public Transformer(String name, double internalNumber, double tensionClass,
      double potency, double current, User user) {
    this.name = name;
    this.internalNumber = internalNumber;
    this.tensionClass = tensionClass;
    this.potency = potency;
    this.current = current;
    this.user = user;
  }

}
