package sample0415;

import java.util.Random;

//CPUの動きを担当するクラス
public class CpuPlayer {
  // フィールド
  private Random random = new Random();
  private static final int minSize = 0;
  private static final int maxSize = 3;

  // CPUの配置メソッド
  public Position cpuMark(Board board) {
    int row;
    int column;

    // 勝てるマスがあるかチェック→あれば配置
    for (int i = minSize; i < maxSize; i++) {
      for (int j = minSize; j < maxSize; j++) {
        if (board.isEmpty(i, j)) {
          board.placeMark(i, j, Player.CpuPlayer);
          GameState state = board.checkWin(Player.CpuPlayer);
          board.clearCell(i, j);

          if (state == GameState.WIN) {
            return new Position(i, j);
          }
        }
      }
    }

    // //相手の勝利を防止できるマスがあるかチェック→あれば配置
    for (int i = minSize; i < maxSize; i++) {
      for (int j = minSize; j < maxSize; j++) {
        if (board.isEmpty(i, j)) {
          board.placeMark(i, j, Player.HumanPlayer);
          GameState state = board.checkWin(Player.HumanPlayer);
          board.clearCell(i, j);

          if (state == GameState.WIN) {
            return new Position(i, j);
          }
        }
      }
    }

    // 勝てるマスがない場合はランダムで配置
    do {
      row = random.nextInt(maxSize);
      column = random.nextInt(maxSize);

    } while (!board.isEmpty(row, column));

    return new Position(row, column);
  }

  // 仮置きしてゲームの進行状態をチェックするメソッド

}
