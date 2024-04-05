package io.chagchagchag.ddd.fastcampus_v1.membership.adapter.in.web;

import io.chagchagchag.ddd.fastcampus_v1.common.WebAdapter;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.RegisterMembershipCommand;
import io.chagchagchag.ddd.fastcampus_v1.membership.application.port.in.RegisterMembershipUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "member register", description = "회원가입")
@WebAdapter
@RequiredArgsConstructor
@RestController
public class RegisterMembershipController {

  private final RegisterMembershipUseCase registerMembershipUseCase;

  @PostMapping(path = "/membership/register")
  @Operation(summary = "회원가입", description = "회원가입")
  public void register(@RequestBody RegisterMembershipRequest request){
    // request 받기

    // request → command 변환 작업 수행
    RegisterMembershipCommand command = RegisterMembershipCommand.builder()
        .name(request.getName())
        .address(request.getAddress())
        .email(request.getEmail())
        .isValid(true)
        .build();

    // Use case 처리
    registerMembershipUseCase.registerMembership(command);
  }

  @GetMapping("/hello")
  public String test(){
    return "Hello, Nice to meet you";
  }
}
