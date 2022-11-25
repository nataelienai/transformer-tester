package io.github.nataelienai.transformertester.user;

import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document("users")
public class User {

  @Id
  private String id;

  private String name;

  @Indexed(unique = true)
  private String email;

  @CreatedDate
  @Field("created_at")
  private Instant createdAt;

  @LastModifiedDate
  @Field("updated_at")
  private Instant updatedAt;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

}
