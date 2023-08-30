package io.pinsoft.pinsoftassignment.minesweeper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MinesweeperController {

  private final MinesweeperService service;

  public MinesweeperController(MinesweeperService service) {
    this.service = service;
  }

  @PostMapping("show-hint")
  public MinesweeperResponse showHint(@RequestBody MinesweeperRequest request) {
    return service.showHints(request);
  }

}
