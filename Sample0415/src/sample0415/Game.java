package sample0415;

//ゲームの実行・進行を担当するクラス
public class Game {
	// フィールド
	private Board board;
	private Display display;
	private PlaceInput input;
	private CpuPlayer cpuPlayer;
	private Player currentPlayer;

	// コンストラクタ
	public Game() {
		// 初期化処理
		initialize();
	};

	// ゲーム実行
	public void run() {
		// メイン処理
		mainProcess();

		// 終了処理
		finish();

	}

	// 初期化処理
	private void initialize() {
		board = new Board();
		display = new Display();
		input = new PlaceInput();
		cpuPlayer = new CpuPlayer();
		currentPlayer = Player.HumanPlayer;
	}

	// メイン処理（終了条件を満たすまでループ）
	private void mainProcess() {
		// stateを定義
		GameState state = GameState.ONGOING;

		while (state == GameState.ONGOING) {
			// 入力～配置までの処理
			playTurn();

			// 勝敗判定
			state = board.checkWin(currentPlayer);

			// プレイヤー切り替え
			if (state == GameState.ONGOING) {
				switchPlayer();
			}

		}
	}

	// 1ターン分のメソッド
	private void playTurn() {
		// 現在のプレイヤーのターンを表示
		display.showTurnInfo(currentPlayer.getMark());

		// 盤面表示
		display.printBoard(board);
		display.showNewLine();

		// 入力受付・バリデーション
		Position pos;
		if (currentPlayer == Player.HumanPlayer) {
			pos = input.inputPlace(board);
		} else {
			pos = cpuPlayer.cpuMark(board);
		}

		// 指定された位置に現在のプレイヤーのマークを配置
		board.placeMark(pos.getRow(), pos.getColumn(), currentPlayer);

		// 配置場所をコンソールに表示
		display.showPlace(pos.getRow(), pos.getColumn(), currentPlayer);
	}

	// プレイヤー切り替えメソッド
	private void switchPlayer() {
		if (currentPlayer == Player.HumanPlayer) {
			currentPlayer = Player.CpuPlayer;
		} else {
			currentPlayer = Player.HumanPlayer;
		}
	}

	// 終了処理メソッド
	private void finish() {
		// 終了後の盤面表示
		display.printBoard(board);

		// 結果を表示
		display.showResult(board.getWinner());
	}
}
