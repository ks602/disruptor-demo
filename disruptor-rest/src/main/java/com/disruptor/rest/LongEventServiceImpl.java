package com.disruptor.rest;

import com.disruptor.core.event.LongEvent;
import com.disruptor.core.event.LongEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import java.nio.ByteBuffer;
import org.springframework.stereotype.Service;

@Service
public class LongEventServiceImpl implements LongEventService {

  private final int BUFFER_SIZE = 1024;
  private final Disruptor<LongEvent> disruptor;
  private final RingBuffer<LongEvent> ringBuffer;
  private final ByteBuffer bb = ByteBuffer.allocate(8);

  public LongEventServiceImpl(LongEventHandler longEventHandler) {
    disruptor = new Disruptor<>(LongEvent::new, BUFFER_SIZE, DaemonThreadFactory.INSTANCE);
    disruptor.handleEventsWith(longEventHandler);
    disruptor.start();
    ringBuffer = disruptor.getRingBuffer();
  }


  @Override
  public void publish(long value) {
    bb.putLong(0, value);
    ringBuffer.publishEvent(((event, sequence, buffer) -> event.set(bb.getLong(0))), bb);
  }

}
