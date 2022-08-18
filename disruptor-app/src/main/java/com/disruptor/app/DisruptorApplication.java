package com.disruptor.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
    basePackages = {
        "com.disruptor"
    }
)
public class DisruptorApplication {

  public static void main(String[] args) {
    SpringApplication.run(DisruptorApplication.class);
  }

}
