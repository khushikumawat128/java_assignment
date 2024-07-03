import javax.swing.*;
import java.awt.*;

class MovingCircles extends JPanel{
	private int redx=0;
	private int bluex=0;
	private int greenx=0;
	private final int redy=50;
	private final int bluey=150;
	private final int greeny=250;
	private final int diameter = 50;
	private final int redSpeed = 10;
	private final int blueSpeed = 5;
	private final int greenSpeed = 2;
	private final Object lock = new Object();
	private int width;

	public MovingCircles(){
		Thread redThread = new Thread(() -> moveCircle(redSpeed,"red"));
		Thread blueThread = new Thread(() -> moveCircle(blueSpeed,"blue"));
		Thread greenThread = new Thread(() -> moveCircle(greenSpeed,"green"));

		redThread.start();
		blueThread.start();
		greenThread.start();
	}
	private void moveCircle(int speed, String color){
		while(true){
			synchronized(lock){
				while((redx<width && bluex<width && greenx < width) 
					  || (redx >= width && bluex < width && greenx<width && !color.equals("red"))
			          || (redx<width && bluex>=width && greenx<width && !color.equals("blue"))
			      	  || (redx<width && bluex<width && greenx>=width && !color.equals("green"))
			      	  )
				{
					try{
						lock.wait();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
			if(color.equals("red")){
				redx=0;
			}else if(color.equals("blue")){
				bluex=0;
			}else if(color.equals("green")){
				greenx=0;
			}
			while(true){
				if(color.equals("red")){
					redx+=speed;
				}else if(color.equals("blue")){
					bluex+=speed;
				}else if(color.equals("green")){
					greenx+=speed;
				}
			repaint();

			if((color.equals("red")&& redx>=width) ||
				(color.equals("blue")&& bluex>=width) ||
				(color.equals("green")&& greenx>=width)){
				synchronized (lock){
					lock.notifyAll();
				}
				break;
			}
			try{
				Thread.sleep(30);
			}catch(InterruptedException e){
				e.printStackTrace();
				}
			}
		}
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		width=getWidth()-diameter;
		g.setColor(Color.RED);
		g.fillOval(redx,redy,diameter,diameter);
		g.setColor(Color.BLUE);
		g.fillOval(bluex,bluey,diameter,diameter);
		g.setColor(Color.GREEN);
		g.fillOval(greenx,greeny,diameter,diameter);
	}
	public static void main(String[] args){
		JFrame frame = new JFrame("Moving Circles");
		MovingCircles movC = new MovingCircles();
		frame.add(movC);
		frame.setSize(800,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}