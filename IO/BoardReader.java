package tai.IO;

import static tai.IO.Constants.BLOCKSIZE;
import static tai.IO.Constants.BX;
import static tai.IO.Constants.BY;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import tai.Board;

public class BoardReader {
	public static Board read(Robot r) {
		return read(r.createScreenCapture(new Rectangle(BX, BY, BLOCKSIZE*Board.width, BLOCKSIZE*Board.height)));
	}
	public static Board read(BufferedImage grab) {
		Board pB = new Board();
		WritableRaster wr = grab.getRaster();
		for (int x = 0; x < Board.width; x++)
			for (int y = 0; y < Board.height; y++) {
				int e = x*BLOCKSIZE + BLOCKSIZE/2;
				int f = y*BLOCKSIZE + BLOCKSIZE/2;
				int r = wr.getSample(e, f, 0);
				int g = wr.getSample(e, f, 1);
				int b = wr.getSample(e, f, 2);
				pB.bx[x][y] = r==255 || g==255 || b==255;
			}
		return pB;
	}
}
