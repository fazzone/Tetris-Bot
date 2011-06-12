package tai.IO;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import tai.util.Point;

public class Constants {
	public static int BX, BY, BLOCKSIZE, NPX, NPY;
	static {
		System.err.print("Determining constants...");
		Robot r=null;
		try {
			r = new Robot();
		} catch (Exception e) {
			throw new Error(e);	//run around with our hair on fire
		}
		BufferedImage grab = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		Point origin = CFind.findBoard(grab);
		int blocksize = CFind.getBlocksize(grab, origin);
		Point NPL = CFind.getNPLocation(grab, origin, blocksize);
		BX = origin.x;
		BY = origin.y;
		BLOCKSIZE = blocksize;
		NPX = NPL.x;
		NPY = NPL.y;
		System.err.println("done");
		System.out.println("got blocksize "+blocksize);
	}
}
