package tai.util;

public class Pair<A,B> {
	public A first;
	public B second;
	public Pair(A a, B b) {
		first = a;
		second = b;
	}
	public String toString() {
		return "("+first+","+second+")";
	}
}
