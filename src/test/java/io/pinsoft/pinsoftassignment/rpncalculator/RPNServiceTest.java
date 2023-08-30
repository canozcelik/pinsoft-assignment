package io.pinsoft.pinsoftassignment.rpncalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RPNServiceTest {

  private RPNService rpnService;

  @BeforeEach
  void setUp() {
    rpnService = new RPNServiceImpl();
  }

  @Test
  void calculate_shouldReturnExactResultOne() {
    var request = new RPNRequest();
    request.setExpression("3 5 8 * 7 + *");

    var result = rpnService.calculate(request);

    assertEquals(141, result.getResult());
  }

  @Test
  void calculate_shouldReturnExactResultTwo() {
    var request = new RPNRequest();
    request.setExpression("20 5 /");

    var result = rpnService.calculate(request);

    assertEquals(4, result.getResult());
  }

  @Test
  void calculate_shouldReturnExactResultThree() {
    var request = new RPNRequest();
    request.setExpression("4 2 + 3 -");

    var result = rpnService.calculate(request);

    assertEquals(3, result.getResult());
  }

}
