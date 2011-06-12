package tai.ai;

import java.util.List;

import tai.Board;
import tai.Move;
import tai.Piece;
import tai.branch.PiecePlacements;
import tai.util.Pair;

public class MoveEvaluator {
	public static int score(Board b) {
		int sc = 0;
		sc += 2001*b.nLines();
		
		for (int row = 0; row < Board.height; row++) {
			int ct = 0;
			for (int col = 0; col < Board.width; col++)
				if (b.bx[col][row])
					ct++;
			sc += 7*row*row*ct;
		}
		
		return sc - 1300*countHoles(b.bx);
	}
	static int countHoles(boolean[][] bx) {
		int ct = 0;
		for (int y=1; y < Board.height; y++)
			for (int x=0; x < Board.width; x++)
				if (!bx[x][y] && bx[x][y-1])
					ct++;
		return ct;
	}
	//TODO: clear lines when necessary
	public static int score(Board b, Piece next) {
		List<Pair<Move, Board>> ms = PiecePlacements.moves(b, next);
		int maxscore = 0;
		for (Pair<Move, Board> p : ms)
			maxscore = Math.max(maxscore, score(p.second));
		return score(b) + maxscore;
	}
}
