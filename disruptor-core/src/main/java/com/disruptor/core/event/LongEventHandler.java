package com.disruptor.core.event;

import com.lmax.disruptor.EventHandler;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class LongEventHandler implements EventHandler<LongEvent> {

  private final Consumer<LongEvent> longEventConsumer;

  @Override
  public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
    log.info("Event {}", event);
    Thread.sleep(100);
    longEventConsumer.accept(event);
  }

}
