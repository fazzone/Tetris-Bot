package tai.util;

//needs to be comparable so a List<Point> can be sorted
//see PieceRecognize.java
public class Point implements Comparable<Point> {
	public int x, y;
	public Point(int a, int b) {
		x=a;
		y=b;
	}
	public boolean equals(Object o) {
		return ((Point)o).x == x && ((Point)o).y == y;
	}
	public int compareTo(Point p) {
		if (p.x == x)
			return y - p.y;
		return x - p.x;
	}
	public String toString() {
		return x+","+y;
	}
}
