package tai.IO;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import tai.Board;
import tai.util.Point;

public class CFind {
	private static final int[] borderColor = {102,119,153};
	static Point findBoard(BufferedImage bi) {
		WritableRaster wr = bi.getRaster();
		for (int x=0; x<bi.getWidth(); x++)
			for (int y=0; y<bi.getHeight(); y++)
				if (isBorder(wr.getPixel(x, y, new int[3])))
					return new Point(x+6,y+6);	//+6 for the border
		return null;
	}
	static int getBlocksize(BufferedImage bi, Point origin) {
		WritableRaster wr = bi.getRaster();
		for (int x=origin.x+12; x<bi.getWidth(); x++)	//plus 12 to make double-sure we don't hit the same border
			if (isBorder(wr.getPixel(x, origin.y+12, new int[3])))
				return (int)Math.ceil((double)(x-12-origin.x)/Board.width);
		return -1;
	}
	static Point getNPLocation(BufferedImage bi, Point origin, int blocksize) {	//get location of the next-piece block
		WritableRaster wr = bi.getRaster();
		for (int x=origin.x+blocksize*Board.width; x<bi.getWidth(); x++) //+3 to make double-sure we don't hit the same border
			if (isBorder(wr.getPixel(x, origin.y, new int[3])))
				return new Point(x+6, origin.y);	//origin.y was already corrected
		return null;
	}
	private static boolean isBorder(int[] c) {
		return distanceSq(c, borderColor) < 7;
	}
	private static double distanceSq(int[] a, int[] b) {	//why bother with the sqrt
		int d0=a[0]-b[0], d1=a[1]-b[1], d2=a[2]-b[2];
		return d0*d0 + d1*d1 + d2*d2;
	}
}
