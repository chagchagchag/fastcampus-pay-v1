package io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in;

import io.chagchagchag.ddd.fastcampus_v1.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class FindMembershipCommand extends SelfValidating<FindMembershipCommand> {
  private final String membershipId;
}
