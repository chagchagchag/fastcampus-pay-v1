package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in;

import io.chagchagchag.ddd.fastcampus_v1.common.UseCase;

//@UseCase
public interface RegisterMembershipUseCase {
  void registerMembership(RegisterMembershipCommand command);
  void registerAxonMembership(RegisterMembershipCommand command);
}
