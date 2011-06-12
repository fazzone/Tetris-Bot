package tai;

import java.util.ArrayList;
import java.util.List;

import tai.util.Point;


public enum Piece {
	T,I,S,Z,O,LU,LD;
	public boolean[][] asArray() {
		return getRotations()[0];
	}
	public List<Point> asPoints() {
		return array2points(asArray());
	}
	public boolean[][][] getRotations() {
		switch (this) {
			case T:		return PieceRotations.Ts;
			case I:		return PieceRotations.Is;
			case S:		return PieceRotations.Ss;
			case Z:		return PieceRotations.Zs;
			case O:		return PieceRotations.Os;
			case LU:	return PieceRotations.LUs;
			case LD:	return PieceRotations.LDs;
			default:	return null;
		}
	}
	public static List<Point> translate(List<Point> ps, Point tr) {
		List<Point> nps = new ArrayList<Point>();
		for (Point p : ps)
			nps.add(new Point(p.x + tr.x, p.y + tr.y));
		return nps;
	}
	public static List<Point> array2points(boolean[][] bs) {
		ArrayList<Point> ps = new ArrayList<Point>();
		for (int x=0; x<bs.length; x++)
			for (int y=0; y<bs[x].length; y++)
				if (bs[x][y])
					ps.add(new Point(x,y));
		return ps;
	}
}
