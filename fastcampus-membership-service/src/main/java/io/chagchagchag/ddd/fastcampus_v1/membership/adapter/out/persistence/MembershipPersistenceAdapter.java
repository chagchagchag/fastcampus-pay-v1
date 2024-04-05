package io.chagchagchag.ddd.fastcampus_v1.membership.adapter.out.persistence;

import io.chagchagchag.ddd.fastcampus_v1.common.PersistenceAdapter;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out.FindMembershipPort;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.out.RegisterMembershipPort;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipAddress;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipAggregateIdentifier;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipEmail;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipId;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipIsValid;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership.MembershipName;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {
  private final SpringDataMembershipRepository membershipRepository;
  private final MembershipMapper membershipMapper;

  @Override
  public void createMembership(
      MembershipName membershipName,
      MembershipEmail membershipEmail,
      MembershipAddress membershipAddress,
      MembershipIsValid membershipIsValid,
      MembershipAggregateIdentifier membershipAggregateIdentifier
  ){
    membershipRepository.save(
        new MembershipJpaEntity(
            membershipName.getNameValue(),
            membershipEmail.getEmailValue(),
            membershipAddress.getAddressValue(),
            membershipIsValid.isValidValue(),
            membershipAggregateIdentifier.getAggregateIdentifier()
        )
    );
  }

  @Override
  public Membership findMembership(MembershipId membershipId) {
    return membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()))
        .map(entity -> membershipMapper.mapToDomainEntity(entity))
        .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
  }
}
