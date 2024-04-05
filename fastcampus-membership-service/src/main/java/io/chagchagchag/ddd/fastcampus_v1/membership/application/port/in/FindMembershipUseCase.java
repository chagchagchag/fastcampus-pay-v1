package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in;

import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;

public interface FindMembershipUseCase {
  Membership findMembership(FindMembershipCommand command);
  Membership findAxonMembership(FindMembershipCommand command);
}
