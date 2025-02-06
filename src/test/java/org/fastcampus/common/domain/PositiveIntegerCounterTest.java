package org.fastcampus.common.domain;

import static org.junit.Assert.assertEquals;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Test;

/**
 * 테스트용 클래스는 public 을빼주는것이좋다
 * Given -when -then 형식, 가독성을 위해 한글로 해도 무방
 */
class PositiveIntegerCounterTest {

  @Test
  void givenCreated_whenIncrease_thenCounterIsOne() {

    //given
    PositiveIntegerCounter counter = new PositiveIntegerCounter();

    //when
    counter.increase();

    //then
    assertEquals(1,  counter.getCount());
  }

  @Test
  void givenCreatedAndIncreased_whenAndDecrease_thenCounterIsZero() {

    //given
    PositiveIntegerCounter counter = new PositiveIntegerCounter();
    counter.increase();

    //when
    counter.decrease();

    //then
    assertEquals(0,  counter.getCount());
  }

  @Test
  void givenCreated_whenDecrease_thenCountIsZero() {
    //given
    PositiveIntegerCounter counter = new PositiveIntegerCounter();

    //when
    counter.decrease();

    //then
    assertEquals(0,  counter.getCount());
  }

}
