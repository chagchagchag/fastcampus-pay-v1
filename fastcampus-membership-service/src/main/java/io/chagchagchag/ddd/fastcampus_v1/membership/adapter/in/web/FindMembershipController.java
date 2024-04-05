package io.chagchagchag.ddd.fastcampus_v1.membership.adapter.in.web;

import io.chagchagchag.ddd.fastcampus_v1.common.WebAdapter;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.FindMembershipCommand;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.FindMembershipUseCase;
import io.chagchagchag.ddd.fastcampus_v1.membership.domain.Membership;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "member find", description = "회원조회")
@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {
  private final FindMembershipUseCase findMembershipUseCase;
  @GetMapping(path = "/membership/{membershipId}")
  @Parameters(value = {
      @Parameter(name = "membershipId", description = "회원 id", example = "1")
  })
  @Operation(summary = "회원조회", description = "회원조회")
  ResponseEntity<Membership> findMembershipByMemberId(@PathVariable(name = "membershipId") String membershipId){
    FindMembershipCommand command = FindMembershipCommand.builder()
        .membershipId(membershipId)
        .build();
    return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
  }

  @GetMapping(path = "/membership/axon/{membershipId}")
  ResponseEntity<Membership> findAxonMembershipByMemberId(@PathVariable String membershipId){
    return null;
  }
}
