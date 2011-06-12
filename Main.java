package tai;

import static tai.IO.Constants.NPX;
import static tai.IO.Constants.NPY;

import java.awt.Rectangle;
import java.awt.Robot;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tai.IO.BoardReader;
import tai.IO.NextPiece;
import tai.IO.Player;
import tai.ai.MoveEvaluator;
import tai.branch.PiecePlacements;
import tai.util.Pair;

public class Main {
	public static void main(String[] args) throws Exception {
		Robot r = new Robot();
		Player p = new Player(r);
		p.alttab();
		while (true) {
			long b = System.currentTimeMillis();
			
			move(r, p);
			
			long elapsed = System.currentTimeMillis() - b;
			System.out.println(elapsed+"ms");
			
			Thread.sleep(100);	//ensures that the board is read accurately	
		}
	}
	static void move(Robot r, Player p) throws Exception {
		Board b = BoardReader.read(r);
		final Piece next = NextPiece.readNextPiece(r.createScreenCapture(new Rectangle(NPX, NPY, 256, 256)));
		List<Pair<Move, Board>> moves = PiecePlacements.moves(b);
		if (moves == null)
			return;
		Collections.sort(moves, new Comparator<Pair<Move, Board>>() {
			public int compare(Pair<Move, Board> a, Pair<Move, Board> b) {
				return MoveEvaluator.score(b.second, next) - MoveEvaluator.score(a.second, next);
			}
		});
		p.play(moves.get(0).first);
	}
}
