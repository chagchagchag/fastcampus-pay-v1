package io.chagchagchag.ddd.fastcampus_v1.membership.application.service;

import io.chagchagchag.ddd.fastcampus_v1.common.UseCase;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.RegisterMembershipCommand;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.RegisterMembershipUseCase;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out.RegisterMembershipPort;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterMembership implements RegisterMembershipUseCase {
  private final RegisterMembershipPort registerMembershipPort;

  @Override
  public void registerMembership(RegisterMembershipCommand command) {
    registerMembershipPort.createMembership(
        new Membership.MembershipName(command.getName()),
        new Membership.MembershipEmail(command.getEmail()),
        new Membership.MembershipAddress(command.getAddress()),
        new Membership.MembershipIsValid(command.isValid()),
        new Membership.MembershipAggregateIdentifier("default")
    );
  }

  @Override
  public void registerAxonMembership(RegisterMembershipCommand command) {

  }
}
