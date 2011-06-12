package tai.branch;

import java.util.ArrayList;
import java.util.List;

import tai.Board;
import tai.Move;
import tai.Piece;
import tai.util.Pair;
import tai.util.Point;

public class PiecePlacements {
	public static List<Pair<Move, Board>> moves(Board b) {
		return moves(b, PieceRecognize.recognize(PieceFind.extract(b)));
	}
	public static List<Pair<Move, Board>> moves(Board b, Piece p) {
		if (p == null)
			return null;
		boolean[][][] rs = p.getRotations();
		List<Pair<Move,Board>> bs = new ArrayList<Pair<Move, Board>>();
		for (int i=0; i<rs.length; i++) {
			List<Point> ps = Piece.array2points(p.getRotations()[i]);
			for (int tx = 0; tx < Board.width - width(ps); tx++) {
				Board b2 = PieceDrop.dropPiece(b, Piece.translate(ps, new Point(tx, 0)));
				bs.add(new Pair<Move, Board>(new Move(tx, i), b2));
			}
		}
		return bs;
	}
	static int width(List<Point> ps) {
		int xmax = 0;
		for (Point p : ps)
			xmax = Math.max(xmax, p.x);
		return xmax;
	}
}
