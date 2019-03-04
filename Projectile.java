import objectdraw.*;
import java.awt.*;
public class Projectile extends ActiveObject
{
	private FilledOval f;
	private int lifeLength, speed = -10;
	public Projectile(double x, double y, Color col, DrawingCanvas canvas)
	{
		f = new FilledOval(x,y,5,15,canvas);
		f.setColor(col);
		start();
	}
	public Projectile(double x, double y, Color col, int travelSpeed, DrawingCanvas canvas)
	{
		speed = travelSpeed;
		f = new FilledOval(x,y,5,15,canvas);
		f.setColor(col);
		start();
	}
	public FilledOval getFood()
	{
		return f;
	}
	public void run()
	{
		while(lifeLength<100)
		{
			f.move(0,speed);
			pause(5);
			lifeLength++;
			if(f.getY() < 0)
				f.hide();
		}
	}
	public void removeFromCanvas()
	{
		f.removeFromCanvas();
	}
	public double getX()
	{
		return f.getX();
	}
	public double getY()
	{
		return f.getY();
	}
	
}
