package sample0415;

public class HumanPlayer implements Player {
	//フィールド
	private String mark;
	private InputHandler inputHandler;

	//コンストラクタ
	public HumanPlayer(String mark, InputHandler inputHandler) {
		this.mark = mark;
		this.inputHandler = inputHandler;

	}

	@Override
	public Position nextMove(Board board) {
		return inputHandler.inputPosition(board);
	}

	@Override
	public String getMark() {
		return mark;
		
	}
}
