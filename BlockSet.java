import objectdraw.*;
import java.awt.*;
import java.util.LinkedList;
public class BlockSet extends ActiveObject
{
	private int width, height, movementSpeed = 1, explosionCount = 0;
	private LinkedList<FilledRect> blocks = new LinkedList<FilledRect>();
	private DrawingCanvas myCanvas;
	private boolean running = true;
	private final Color DEFAULT_COLOR = Color.GREEN;
	public BlockSet(int x, int y, int moveSpeed, DrawingCanvas canvas)
	{
		movementSpeed = moveSpeed;
		myCanvas = canvas;
		width = canvas.getWidth()/10;
		int gap = width/12;
		height = canvas.getHeight()/20;
		for(int i = 0; i < 15; i++)
		{
			if(i < 5)
				blocks.add(new FilledRect(x + (width+gap)*i, y,width,height,canvas));	
			else if(i <10)
				blocks.add(new FilledRect(x + (width+gap)*(i-5), y + height + gap*2,width,height,canvas));
			else
				blocks.add(new FilledRect(x + (width+gap)*(i-10), y + height*2 + gap*4,width,height,canvas));
			blocks.get(i).setColor(DEFAULT_COLOR);
		}
		start();
	}
	public void run()
	{
		while(running)
		{
			if(blocks.size() < 1)
			{
				running = false;
				break;
			}
			setMovement(movementSpeed);
			for(FilledRect block: blocks)
			{
				if(block.getX()  > myCanvas.getWidth()-width) //right boundary
		        {
		            movementSpeed = -movementSpeed;
		            setMovement(movementSpeed);
		            break;
		        }
				else if(block.getX() < 1) //left boundary
		        {
		            movementSpeed = -movementSpeed;
		            setMovement(movementSpeed);
		            break;
		        }
			}
	        pause(5);
		}
	}
	public void setColorAll(Color c)
	{
		for(int i = 0; i < blocks.size(); i++)
		{
			blocks.get(i).setColor(c);
		}
	}
	public void setMovement(int speed)
	{
		for(int i = 0; i < blocks.size(); i++)
		{
			blocks.get(i).move(speed,0);
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
	public int getExplosionCount()
	{
		return explosionCount;
	}
	public boolean checkForHit(Location point)
	{
		for(FilledRect block: blocks)
		{
			if(block != null && block.contains(point))
			{
				if(block.getColor()==Color.GREEN)
        		{
        			block.setColor(Color.YELLOW);
        			new Explosion(block.getX(),block.getY(),10,Color.GREEN,myCanvas);
        		} 
        		else if(block.getColor()==Color.YELLOW)
        		{
        			block.setColor(Color.ORANGE);
        			new Explosion(block.getX(),block.getY(),11,Color.YELLOW,myCanvas);
        		}
        		else if(block.getColor()==Color.ORANGE)
        		{
        			block.setColor(Color.RED);
        			new Explosion(block.getX(),block.getY(),12,Color.ORANGE,myCanvas);
        		}
        		else if(block.getColor()==Color.RED)
        		{
        			new Explosion(block.getX(),block.getY(),13,Color.RED,myCanvas);
        			blocks.remove(block);
        			block.removeFromCanvas();
        			explosionCount++;
        		}
				return true;
			}
		}
		return false;
	}
}
