package tai.IO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import tai.Piece;

//this should really work the same as / use the same code as PieceFind.java
//but I couldn't really make that work -- PieceFind is fairly closely coupled
//to the concept of finding pieces on the regular board (sadly)
public class NextPiece {
	public static Piece readNextPiece(BufferedImage ch) {
		return readNextPiece(ch, 0, 0);
	}
	public static Piece readNextPiece(BufferedImage ch, int sx, int sy) {
		WritableRaster wr = ch.getRaster();
		for (int x=sx; x<wr.getWidth(); x++)
			for (int y=sy; y<wr.getHeight(); y++) {
				int r = wr.getSample(x, y, 0);
				int g = wr.getSample(x, y, 1);
				int b = wr.getSample(x, y, 2);
				for (Piece p : Piece.values())
					if (new Color(r,g,b).equals(uiColor(p)))
						return p;
			}
		return null;
				
	}
	static Color uiColor(Piece p) {
		switch (p) {
		case T:		return new Color(255,255,0);
		case S:		return new Color(102,204,255);
		case Z:		return new Color(0,255,0);
		case LD:	return new Color(0,0,255);
		case LU:	return new Color(204,0,255);
		case O:		return new Color(255, 0, 0);
		case I:		return new Color(255,102,0);
		default:	return Color.PINK;	//doesn't occur in any pieces
		}
	}
}
