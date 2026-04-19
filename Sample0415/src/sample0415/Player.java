package sample0415;

//プレイヤーを表すenum型→インターフェースとする方がよい？
public enum Player {
	// 各プレイヤーと表示用のマークを定義
	HumanPlayer("o"),
	CpuPlayer("x");

	// フィールド
	private final String mark;

	// コンストラクタ
	Player(String mark) {
		this.mark = mark;

	}

	// 表示用のマークのゲッターメソッド
	public String getMark() {
		return mark;

	}
}
