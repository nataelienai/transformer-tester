package io.github.nataelienai.transformertester.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  @NotBlank(message = "Field 'name' must not be blank")
  private String name;

  @NotBlank(message = "Field 'email' must not be blank")
  @Email(message = "Field 'email' must be a valid email address")
  private String email;

}
