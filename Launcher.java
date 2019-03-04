
import objectdraw.*;
import java.awt.*;
public class Launcher
{
	private FilledRect launcher;
	private int width = 20, height = 50;
	public Launcher(DrawingCanvas canvas)
	{
		launcher = new FilledRect(0,(canvas.getHeight()-50),width,height,canvas);
		launcher.setColor(Color.blue);
	}
	public Launcher(DrawingCanvas canvas, Color c)
	{
		launcher = new FilledRect(0,(canvas.getHeight()-50),width,height,canvas);
		launcher.setColor(c);
	}
	public void moveTo(Location p)
	{
		launcher.moveTo(p.getX(),p.getY());
	}
	public void move(double x, double y)
	{
		launcher.move(x, y);
	}
	public void moveX(double x)
	{
		launcher.move(x, 0);
	}
	public FilledRect getPaddle()
    {
        return launcher;
    }
    public double getX()
    {
        return launcher.getX();
    }
    public double getY()
    {
        return launcher.getY();
    }
    public void setColor(Color c)
    {
    	launcher.setColor(c);
    }
    public Color getColor()
    {
    	return launcher.getColor();
    }
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width)
	{
		this.width = width;
		launcher.setWidth(width);
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
		launcher.setHeight(height);
	}
    
}
