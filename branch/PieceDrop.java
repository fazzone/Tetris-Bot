package tai.branch;

import java.util.List;

import tai.Board;
import tai.Piece;
import tai.util.Point;

public class PieceDrop {
	//the piece is NOT ON 'a' (the board passed to this function) 
	static Board dropPiece(Board a, List<Point> points) {
		Board b = a.copy();
		Point downtr = new Point(0,1);
		while (checkAll(b, Piece.translate(points, downtr)))
			points = Piece.translate(points, downtr);
		b.toggleAll(points);
		return b;
	}
	static boolean checkAll(Board bx, List<Point> pts) {
		for (Point p : pts)
			if (p.y >= Board.height || bx.bx[p.x][p.y])
				return false;
		return true;
	}
}
