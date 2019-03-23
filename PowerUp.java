import objectdraw.*;
import java.awt.*;
public class PowerUp extends ActiveObject {
	private Text view;
	private static int lifeLength = 1250;
	public PowerUp(double x, double y, Color col, String text, int fontSize, DrawingCanvas canvas)
	{
//		view = new Text(t,x,y,canvas);
//		view.setFont("Calibri");
		view = new Text(text,x,y,canvas);
		view.setFont("Calibri");
		view.setFontSize(fontSize);
		view.setColor(Color.BLACK);
		start();
	}
	public void run()
	{
		for(int i = 0; i < lifeLength; i++)
		{
			pause(1);
		}
		try
		{
			view.removeFromCanvas();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}



