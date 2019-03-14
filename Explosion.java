import objectdraw.*;
import java.awt.*;
import java.util.LinkedList;
public class Explosion extends ActiveObject
{
	private LinkedList<FilledOval> balls = new LinkedList<FilledOval>();
	public Explosion(double x, double y, double size, Color col, DrawingCanvas c)
	{
		for(int i=0;i<12;i++)
		{
			balls.add(new FilledOval(x,y,size,size,c));
			balls.get(i).setColor(col);
		}
		start();
	}
	public void run()
	{
		for(int i = 0; i < 250; i++)
		{
			createExplosionMovement();
	        pause(3);
		}
		removeAllFromCanvas();
	}
	public void createExplosionMovement()
	{
		balls.get(0).move(0,5);
		balls.get(1).move(-3,0);
        balls.get(2).move(4,-5);
        balls.get(3).move(0,-2);
        balls.get(4).move(-2,3);
        balls.get(5).move(2,5);
        balls.get(6).move(-3,3);
        balls.get(7).move(-2,-3);
        balls.get(8).move(4,-3);
        balls.get(9).move(-3,2);
        balls.get(10).move(5,-3);
        balls.get(11).move(1,-7);
	}
	public void removeAllFromCanvas()
	{
		for(int i=0;i<balls.size();i++)
		{
			balls.get(i).removeFromCanvas();
			balls.remove(i);
		}
	}
}
