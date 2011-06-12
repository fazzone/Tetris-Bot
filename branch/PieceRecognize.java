package tai.branch;

import java.util.Collections;
import java.util.List;

import tai.Piece;
import tai.util.Point;

public class PieceRecognize {
	public static Piece recognize(List<Point> ps) {
		Collections.sort(ps);
		for (Piece p : Piece.values()) {
			boolean[][][] rts = p.getRotations();
			for (int i=0; i<rts.length; i++)
				if (Piece.array2points(rts[i]).equals(ps))
					return p;
		}
		return null;
	}
}
