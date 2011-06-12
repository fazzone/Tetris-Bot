package tai.IO;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import tai.Move;

public class Player {
	private Robot r;
	public Player(Robot k) {
		r = k;
	}
	public void play(Move m) {		 			
		pressKey(KeyEvent.VK_UP, m.rot);
		pressKey(KeyEvent.VK_LEFT, 4);			//go to coulmn 0
		pressKey(KeyEvent.VK_RIGHT, m.trans);	//translate to where we want to go
		pressKey(KeyEvent.VK_SPACE, 1);			//it's the only way to be sure
	}
	void pressKey(int keycode, int reps) {
		for (int i=0; i<reps; i++) {
			r.keyPress(keycode);
			r.keyRelease(keycode);
			wait(8);
		}
	}
	public void alttab() {
		//I don't feel like empirically determining which of these 'wait's I
		//actually need/don't need.
		r.keyPress(KeyEvent.VK_ALT);
		wait(20);
		r.keyPress(KeyEvent.VK_TAB);
		wait(20);
		r.keyRelease(KeyEvent.VK_ALT);
		wait(20);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	void wait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {}
	}
}