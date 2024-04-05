package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out;

import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;

public interface RegisterMembershipPort {
  void createMembership(
      Membership.MembershipName membershipName
      , Membership.MembershipEmail membershipEmail
      , Membership.MembershipAddress membershipAddress
      , Membership.MembershipIsValid membershipIsValid
      , Membership.MembershipAggregateIdentifier membershipAggregateIdentifier
  );
}
