package tai;

public class Move {
	public int trans;	//translation along the +x axis (right)
	public int rot;		//rotation-state
	public Move(int tr, int r) {
		trans = tr;
		rot = r;
	}
	public String toString() {
		return "(tr="+trans+" rot="+rot+")";
	}
}
