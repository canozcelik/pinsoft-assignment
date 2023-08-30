package io.pinsoft.pinsoftassignment.minesweeper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinesweeperServiceTest {

  private MinesweeperService service;

  @BeforeEach
  void setUp() {
    service = new MinesweeperServiceImpl();
  }


  @Test
  void showHints_ShouldReturnValidResponseOne() {
    var request = new MinesweeperRequest();
    request.setSquare(new String[]{"**...",".....",".*..."});

    var result = service.showHints(request);

    assertEquals("33200", result.getHints()[1]);

  }

  @Test
  void showHints_ShouldReturnValidResponseTwo() {
    var request = new MinesweeperRequest();
    request.setSquare(new String[]{".*","*.","*."});

    var result = service.showHints(request);

    assertEquals("*2", result.getHints()[2]);

  }

  @Test
  void showHints_ShouldReturnValidResponseThree() {
    var request = new MinesweeperRequest();
    request.setSquare(new String[]{"***","*.*","***"});

    var result = service.showHints(request);

    assertEquals("*8*", result.getHints()[1]);

  }

  @Test
  void showHints_ShouldReturnValidResponseFour() {
    var request = new MinesweeperRequest();
    request.setSquare(new String[]{"***","***","***"});

    var result = service.showHints(request);

    assertEquals("***", result.getHints()[1]);

  }


}
