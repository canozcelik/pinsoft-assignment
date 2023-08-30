package io.pinsoft.pinsoftassignment.minesweeper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperServiceImpl implements MinesweeperService {

  @Override
  public MinesweeperResponse showHints(MinesweeperRequest request) {

    String[] square = request.getSquare();
    var columnSize = square[0].length();

    List<String> singleRowList = Arrays.stream(square)
        .flatMap(list -> list.chars().mapToObj(x -> {
          if (x == '.') {
            return "0";
          } else {
            return String.valueOf((char) x);
          }
        })).collect(
            Collectors.toList());

    for (var i = 0; i < singleRowList.size(); i++) {
      if ("*".equals(singleRowList.get(i))) {
        applyRule(i, singleRowList, columnSize);
      }
    }

    var hints = new String[square.length];
    for (var i = 0; i < singleRowList.size() / columnSize; i++) {
      hints[i] = String.join("", singleRowList.subList(i * columnSize, (i + 1) * columnSize));
    }

    var response = new MinesweeperResponse();
    response.setHints(hints);
    return response;
  }

  private void applyRule(int index, List<String> list, int columnSize) {

    //upper row
    var tempIndex = index - columnSize - 1;
    if (tempIndex >= 0 && tempIndex % columnSize != columnSize - 1 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    // upper row
    tempIndex = index - columnSize;
    if (tempIndex >= 0 && !"*".equals(list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    // upper row
    tempIndex = index - columnSize + 1;
    if (tempIndex >= 0 && tempIndex % columnSize != 0 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    // same row
    tempIndex = index - 1;
    if (tempIndex >= 0 && tempIndex % columnSize != columnSize - 1 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    // same row
    tempIndex = index + 1;
    if (tempIndex >= 0 && tempIndex % columnSize != 0 && !"*".equals(
        list.get(tempIndex))) { // same row
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    //lower row
    tempIndex = index + columnSize - 1;
    if (tempIndex <= list.size() - 1 && tempIndex % columnSize != columnSize - 1 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    //lower row
    tempIndex = index + columnSize;
    if (tempIndex <= list.size() - 1 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }

    //lower row
    tempIndex = index + columnSize + 1;
    if (tempIndex <= list.size() - 1 && tempIndex % columnSize != 0 && !"*".equals(
        list.get(tempIndex))) {
      var value = Integer.parseInt(list.get(tempIndex)) + 1;
      list.set(tempIndex, String.valueOf(value));
    }
  }


}
