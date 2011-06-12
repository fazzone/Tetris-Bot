package tai;

import java.util.List;

import tai.util.Point;

public class Board {
	public static final int width = 10, height = 18;
	public boolean[][] bx = new boolean[width][height];
	public int nLines() {
		int ct = 0;
		for (int row = 0; row < height; row++)
			if (hasLine(row))
				ct++;
		return ct;
	}
	public void clearLines() {
		for (int row=0; row<height; row++)
			if (hasLine(row))
				clearLine(row);
	}
	public void toggleAll(List<Point> ps) {
		for (Point p : ps)
			bx[p.x][p.y] ^= true;	//a^=true looks so much cooler than a=!a
	}
	public Board copy() {
		Board b = new Board();
		for (int x=0; x<width; x++)
			System.arraycopy(bx[x], 0, b.bx[x], 0, height);
		return b;
	}
	private boolean hasLine(int row) {
		for (int i=0; i<width; i++)
			if (!bx[i][row])
				return false;
		return true;
	}
	private void clearLine(int row) {
		for (int i=0; i<width; i++)
			bx[i][row] = false;
		for (int y=0; y<row; y++)
			for (int x=0; x<width; x++) {
				bx[x][y+1] = bx[x][y];
				bx[x][y] = false;
			}
	}
}
