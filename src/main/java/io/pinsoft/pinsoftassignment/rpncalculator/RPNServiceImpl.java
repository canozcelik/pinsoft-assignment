package io.pinsoft.pinsoftassignment.rpncalculator;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;


@Service
public class RPNServiceImpl implements RPNService {


  private static final Map<String, BiFunction<String, String, Long>> operationMap;

  static {
    operationMap = Map.of(
        "+", (a, b) -> Long.parseLong(a) + Long.parseLong(b),
        "-", (a, b) -> Long.parseLong(a) - Long.parseLong(b),
        "/", (a, b) -> Long.parseLong(a) / Long.parseLong(b),
        "*", (a, b) -> Long.parseLong(a) * Long.parseLong(b)
    );
  }


  @Override
  public RPNResponse calculate(RPNRequest expression) {

    String[] splitExpression = expression.getExpression().split(" ");
    Stack<String> stack = new Stack<>();
    for (String s : splitExpression) {

      if (!operationMap.containsKey(s)) {
        stack.push(s);
        continue;
      }

      String expressionTwo = stack.pop();
      String expressionOne = stack.pop();
      long calculation = operationMap.get(s).apply(expressionOne,
          expressionTwo);
      stack.push(String.valueOf(calculation));
    }

    var response = new RPNResponse();
    response.setResult(Long.parseLong(stack.pop()));
    return response;
  }
}
