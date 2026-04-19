package sample0415;

import java.util.Random;

//CPUの動きを担当するクラス
public class CpuPlayer {
  // フィールド
  private Random random = new Random();

  // メソッド
  public Position cpuMark(Board board) {
    int row;
    int column;

    do {
      row = random.nextInt(3);
      column = random.nextInt(3);

    } while (!board.isEmpty(row, column));

    return new Position(row, column);
  }
}
