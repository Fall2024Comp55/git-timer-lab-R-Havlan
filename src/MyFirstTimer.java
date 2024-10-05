import java.awt.event.*;
import javax.swing.Timer;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class MyFirstTimer extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	
	private int numTimes = 0;

	Timer myTimer = new Timer(1000, this);
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
		myTimer.setInitialDelay(3000);
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		myTimer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		myLabel.move(5, 0);
		numTimes += 1;
		myLabel.setLabel("times called? " + numTimes);
		if(numTimes > 9) myTimer.stop();
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}