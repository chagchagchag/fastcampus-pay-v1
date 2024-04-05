package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand {
  @NotNull
  private final String name;

  @NotNull
  private final String email;

  @NotNull
  private final String address;

  @NotNull
  private final boolean isValid;

  public RegisterMembershipCommand(String name, String email, String address, boolean isValid) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.isValid = isValid;
  }
}
