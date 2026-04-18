package sample0415;

import java.util.Random;

public class CpuPlayer implements Player {
	//フィールド
	private String mark;
	private Random random = new Random();
	
	//コンストラクタ
	public CpuPlayer(String mark) {
		this.mark = mark;
		
	}
	
	@Override
	public Position nextMove(Board board) {
		int row;
		int column;
		
		do {
			row = random.nextInt(3);
			column = random.nextInt(3);
			
		}while(!board.isEmpty(row, column));
		
		System.out.println("CPUが (" + row + ", " + column + ") に置きました。");
		
		return new Position(row, column);
	}
	
	@Override
	public String getMark() {
		return mark;
	}
	
}
