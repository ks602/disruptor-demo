package com.disruptor.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LongEventController {

  private final LongEventService service;

  @GetMapping(value = "/{value}")
  public void publish(@PathVariable("value") long value) {
    service.publish(value);
  }

}
