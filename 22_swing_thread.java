import javax.swing.*;
import java.awt.*;

class MovingCircle extends JPanel implements Runnable{
	private int x=0;
	private int y=0;
	private int diameter = 50;
	private boolean movingRight = true;
	private final int speed = 5;

	public MovingCircle(){
		Thread movingThread = new Thread(this);
		movingThread.start(); 
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(x,y,diameter,diameter);
	}
	public void run(){
		while(true){
			if(movingRight){
				x+=speed;
				if(x+diameter>=getWidth()){
					movingRight=false;
				}
			}
			else{
				x-=speed;
				if(x<=0){
					movingRight=true;
				}
			}
			repaint();
			try{
				Thread.sleep(30);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Moving Circle ");
		MovingCircle movC = new MovingCircle();
		frame.add(movC);
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}