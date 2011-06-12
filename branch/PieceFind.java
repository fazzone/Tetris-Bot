package tai.branch;

import java.util.ArrayList;
import java.util.List;

import tai.Board;
import tai.util.Point;

public class PieceFind {
	//returns the 'untranslated' points -- also removes the piece from the board
	public static List<Point> extract(Board b) {
		int high = firstNonEmptyRow(b.bx);
		int low = firstEmptyRow(b.bx, high);
		ArrayList<Point> pts = new ArrayList<Point>();
		for (int y = high; y<low; y++)
			for (int x=3; x<8; x++)		//between 3 and 8 means it only searches the shaft
				if (b.bx[x][y])			//of the board where pieces appear - so it doesn't
					pts.add(new Point(x, y));	//get confused
		b.toggleAll(pts);
		return untranslate(pts);
	}
	static boolean rowEmpty(boolean[][] bx, int y) {
		for (int x=0; x<bx.length; x++)
			if (bx[x][y])
				return false;
		return true;
	}
	static int firstNonEmptyRow(boolean[][] bx) {
		for (int i=0; i<bx[0].length; i++)
			if (!rowEmpty(bx, i))
				return i;
		return -1;
	}
	static int firstEmptyRow(boolean[][] bx, int sR) {	//sR = start row
		for (int i=sR; i<bx[0].length; i++)
			if (rowEmpty(bx, i))
				return i;
		return -1;
	}
	static Point findMins(List<Point> ps) {
		Point m = new Point(Board.width, Board.height);
		for (Point p : ps)
			m = new Point(Math.min(p.x, m.x), Math.min(p.y, m.y));
		return m;
	}
	static List<Point> untranslate(List<Point> r) {
		ArrayList<Point> n = new ArrayList<Point>();
		Point m = findMins(r);		
		for (Point e : r)
			n.add(new Point(e.x - m.x, e.y - m.y));
		return n;
	}
}