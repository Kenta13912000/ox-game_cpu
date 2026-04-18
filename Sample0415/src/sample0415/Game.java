package sample0415;

public class Game {
	//フィールド
	private Board board = new Board();
	private Display display = new Display();
	
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	
	//コンストラクタ
	public Game() {
		InputHandler inputHandler = new InputHandler();
		player1 = new HumanPlayer("o", inputHandler);
		player2 = new CpuPlayer("x");
		
		currentPlayer = player1;
	}

	//ゲーム開始
	public void run() {
		//ゲーム開始から終了までループ
		gameLoop();

		//終了処理
		finish();

	}

	//ゲーム開始～終了までのループメソッド
	private void gameLoop() {
		while (!isGameOver()) {
			//入力～配置までの処理
			playTurn();

			//勝敗判定
			if (board.checkWin(currentPlayer.getMark())) {
				break;
			}

			//プレイヤー切り替え
			switchPlayer();

		}
	}

	//1ターン分のメソッド
	private void playTurn() {
		//現在のプレイヤーのターンを表示
		display.showTurnInfo(currentPlayer.getMark());

		//盤面表示
		display.printBoard(board);
		display.showNewLine();

		//入力受付・バリデーション
		Position pos = currentPlayer.nextMove(board);

		// 指定された位置に現在のプレイヤーのマークを配置
		board.placeMark(pos.getRow(), pos.getColumn(), currentPlayer.getMark());

	}

	//終了判定メソッド
	//勝者がいる、または空きマスがない場合にゲーム終了とする
	private boolean isGameOver() {
		return board.getWinner() != null || !board.hasEmptyCells();
	}

	//プレイヤー切り替えメソッド
	private void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	//終了処理メソッド
	private void finish() {
		//終了後の盤面表示
		display.printBoard(board);

		//結果を表示
		display.showResult(board.getWinner());
	}
}
