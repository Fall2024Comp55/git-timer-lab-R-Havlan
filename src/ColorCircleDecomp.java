import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.*;
import acm.program.*;

public class ColorCircleDecomp extends GraphicsProgram implements ActionListener {
	public static final int PROGRAM_WIDTH = 800;
	public static final int PROGRAM_HEIGHT = 600;
	public static final int BALL_SIZE = 50;
	public static final int DELAY_MS = 25;
	
	// Speed must be a number that evenly divides 255
	public static final int SPEED = 3;
	
	//TODO create a private GOval here
	private GOval ball;
	private int angle;
	
	private int color;
	
	private int colorR;
	private int colorG;
	private int colorB;
	
	public void run() {
		//TODO add your ball here
		ball = new GOval(300,300,BALL_SIZE, BALL_SIZE);
		ball.setFilled(getAutoRepaintFlag());
		ball.setFillColor(Color.RED);
		ball.setColor(Color.RED);
		add(ball);
		
		angle = 0;
		
		color = 0;
		
		// Solution 1
		//*
		colorR = 0;
		colorG = 85;
		colorB = 170;
		//*/
		
		// Solution 2
		/*
		colorR = 255;
		colorG = 0;
		colorB = 0;
		*/
		
		Timer t = new Timer(DELAY_MS, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ball.movePolar(2*SPEED, angle);
		angle += 1*SPEED;
		angle = angle % 360;
		
		// Make sure one of the two functions is commented out
		solution1();
		//solution2();
	}
	
	// Solution 1 using separate variables for R G B, no conditionals
	public void solution1() {
		ball.setFillColor(new Color(Math.abs(colorR-255), Math.abs(colorG-255), Math.abs(colorB-255)));
		ball.setColor(new Color(Math.abs(colorR-255), Math.abs(colorG-255), Math.abs(colorB-255)));
		colorR += SPEED;
		colorR = colorR % 510;
		colorG += SPEED;
		colorG = colorG % 510;
		colorB += SPEED;
		colorB = colorB % 510;
	}
	
	// Solution 2 using switch statement for a nicer gradient palette. Change run to: colorR = 255; colorG = 0; colorB = 0;
	public void solution2() {
		ball.setFillColor(new Color(colorR, colorG, colorB));
		ball.setColor(new Color(colorR, colorG, colorB));
		
		switch(color / 255) {
		case 0:
			colorG += SPEED;
			break;
		case 1:
			colorR -= SPEED;
			break;
		case 2:
			colorB += SPEED;
			break;
		case 3:
			colorG -= SPEED;
			break;
		case 4:
			colorR += SPEED;
			break;
		case 5:
			colorB -= SPEED;
		}
		
		color += SPEED;
		color = color % 1531;
	}
	
	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
	}
	
	public static void main(String args[]) {
		new ColorCircleDecomp().start();
	}
	
}
