import objectdraw.*;
import java.awt.*;
public class Explosion extends ActiveObject
{
	private int count;
	private FilledOval[] balls;
	public Explosion(double x, double y, double size, Color col, DrawingCanvas c)
	{
		balls = new FilledOval[12];
		for(int i=0;i<balls.length;i++)
		{
			balls[i] = new FilledOval(x,y,size,size,c);
			balls[i].setColor(col);
		}
		start();
	}
	public void run()
	{
		while(count <500)
		{
			balls[0].move(0,5);
			balls[1].move(-3,0);
	        balls[2].move(4,-5);
	        balls[3].move(0,-2);
	        balls[4].move(-2,3);
	        balls[5].move(2,5);
	        balls[6].move(-3,3);
	        balls[7].move(-2,-3);
	        balls[8].move(4,-3);
	        balls[9].move(-3,2);
	        balls[10].move(5,-3);
	        balls[11].move(1,-7);
	        pause(3);
			count++;
		}
	}
}
