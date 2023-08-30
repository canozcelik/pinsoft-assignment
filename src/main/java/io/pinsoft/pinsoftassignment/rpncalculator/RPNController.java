package io.pinsoft.pinsoftassignment.rpncalculator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RPNController {

  private final RPNService service;

  public RPNController(RPNService service) {
    this.service = service;
  }

  @PostMapping("calculate")
  public RPNResponse showHint(@RequestBody RPNRequest request) {
    return service.calculate(request);
  }
}
