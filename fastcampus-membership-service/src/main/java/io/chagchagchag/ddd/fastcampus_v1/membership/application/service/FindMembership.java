package io.chagchagchag.ddd.fastcampus_v1.membership.application.service;

import io.chagchagchag.ddd.fastcampus_v1.common.UseCase;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.FindMembershipCommand;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.FindMembershipUseCase;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out.FindMembershipPort;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembership implements FindMembershipUseCase {
  private final FindMembershipPort findMembershipPort;
  @Override
  public Membership findMembership(FindMembershipCommand command) {
    return findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
  }

  @Override
  public Membership findAxonMembership(FindMembershipCommand command) {
    return null;
  }
}
