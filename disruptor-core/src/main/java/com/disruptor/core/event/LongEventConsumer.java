package com.disruptor.core.event;

import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class LongEventConsumer implements Consumer<LongEvent> {

  @Override
  public void accept(LongEvent longEvent) {

  }

  @Override
  public Consumer<LongEvent> andThen(Consumer<? super LongEvent> after) {
    return Consumer.super.andThen(after);
  }

}
