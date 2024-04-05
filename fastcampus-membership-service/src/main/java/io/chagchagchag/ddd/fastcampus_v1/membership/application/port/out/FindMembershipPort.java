package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out;

import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipId;

public interface FindMembershipPort {
  Membership findMembership(MembershipId membershipId);
}
