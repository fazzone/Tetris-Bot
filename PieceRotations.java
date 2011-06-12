package tai;

public class PieceRotations {
	static boolean[][] T_piece = 	{{true, false}, {true, true}, {true, false}};
	static boolean[][][] Ts = iterate_rotate(T_piece , 4);
	
	static boolean[][] I_piece = 	{{true}, {true}, {true}, {true}};
	static boolean[][][] Is = iterate_rotate(I_piece, 2);

	static boolean[][] S_piece = 	{{false, true}, {true, true}, {true, false}};
	static boolean[][][] Ss = iterate_rotate(S_piece, 2);
	
	static boolean[][] Z_piece =	{{true, false}, {true, true}, {false, true}};
	static boolean[][][] Zs = iterate_rotate(Z_piece, 2);
	
	static boolean[][] O_piece = 	{{true, true}, {true, true}};
	static boolean[][][] Os = iterate_rotate(O_piece, 1);
	
	static boolean[][] LD_piece=	{{true, true}, {true, false}, {true, false}};
	static boolean[][][] LDs = iterate_rotate(LD_piece, 4);
	
	static boolean[][] LU_piece=	{{true, false}, {true, false}, {true, true}};
	static boolean[][][] LUs = iterate_rotate(LU_piece, 4);
	
	static boolean[][][] iterate_rotate(boolean[][] in, int N) {
		boolean[][][] rs = new boolean[N][][];
		rs[0] = in;
		for (int i = 1; i < rs.length; i++)
			rs[i] = rotate(rs[i-1]);
		return rs;
	}
	static boolean[][] rotate(boolean[][] in) {
		boolean[][] n = new boolean[in[0].length][in.length];
		for (int x=0; x<in.length; x++)
			for (int y=0; y<in[x].length; y++)
				n[n.length-1-y][x] = in[x][y];
		return n;
	}
}
