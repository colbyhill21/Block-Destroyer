import objectdraw.*;
import java.awt.*;
public class BlockSet extends ActiveObject
{
	private int width, height, movementSpeed = 1;
	private FilledRect[] blocks = new FilledRect[15];
	private DrawingCanvas myCanvas;
	private boolean running = true;
	public BlockSet(int x, int y, DrawingCanvas canvas)
	{
		myCanvas = canvas;
		width = canvas.getWidth()/10;
		int gap = width/12;
		height = canvas.getHeight()/20;
		for(int i = 0; i < 15; i++)
		{
			if(i < 5)
				blocks[i] = new FilledRect(x + (width+gap)*i, y,width,height,canvas);	
				
			else if(i <10)
				blocks[i] = new FilledRect(x + (width+gap)*(i-5), y + height + gap*2,width,height,canvas);
			else
			{
				blocks[i] = new FilledRect(x + (width+gap)*(i-10), y + height*2 + gap*4,width,height,canvas);
			}
		}
		start();
	}
	public void run()
	{
		while(running)
		{
			setMovement(movementSpeed);
	        if(blocks[blocks.length-1].getX() > myCanvas.getWidth()-width)
	        {
	            movementSpeed = -movementSpeed;
	            setMovement(movementSpeed);
	        }
	        else if(blocks[0].getX() < 1)
	        {
	            movementSpeed = -movementSpeed;
	            setMovement(movementSpeed);
	        }
	        pause(5);
		}
	}
	public void setColorAll(Color c)
	{
		for(int i = 0; i < blocks.length; i++)
		{
			blocks[i].setColor(c);
		}
	}
	public void setMovement(int speed)
	{
		for(int i = 0; i < blocks.length; i++)
		{
			blocks[i].move(speed,0);
		}
	}
	public boolean getStatus()
	{
		return running;
	}
	public void setStatus(Boolean b)
	{
		running = b;
	}
	
}
