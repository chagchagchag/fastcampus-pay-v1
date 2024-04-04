package io.chagchagchag.ddd.fastcampus_v1.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
  @GetMapping(path = "/test")
  public String getTest(){
    return "Hello, nice to meet you.";
  }
}
