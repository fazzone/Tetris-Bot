package tai.IO;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Debug {
	public static void draw(boolean[][] bx, String fn) {
		try {
			BufferedImage bi = new BufferedImage(bx.length*Constants.BLOCKSIZE, bx[0].length*Constants.BLOCKSIZE, BufferedImage.TYPE_BYTE_INDEXED);
			Graphics2D g = bi.createGraphics();
			for (int x=0; x<bx.length; x++)
				for (int y=0; y<bx[x].length; y++) {
					g.setColor(Color.black);
					if (bx[x][y])
						g.setColor(Color.red);
					g.fillRect(x*Constants.BLOCKSIZE, y*Constants.BLOCKSIZE, Constants.BLOCKSIZE-1, Constants.BLOCKSIZE-1);
				}
			ImageIO.write(bi, "png", new File(fn));
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}
