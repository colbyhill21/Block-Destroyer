
import objectdraw.*;
import java.awt.*;
import java.util.LinkedList;
public class World extends ActiveObject
{
	LinkedList<Projectile> shotProjectiles = new LinkedList<Projectile>();
	private boolean running = true, shotExisting = false;
	private int ammoCount = 100;
	private DrawingCanvas myCanvas;
	private BlockSet blocks;
	private Launcher launcher;
	public World(DrawingCanvas c) 
	{
		myCanvas = c;
		launcher = new Launcher(myCanvas,Color.GREEN);
		blocks = new BlockSet(10,10,myCanvas);
        start();
	}
	public void onMouseMove(Location point) //keeps the paddle with the mouse
	{
		launcher.moveTo(new Location(point.getX(),myCanvas.getHeight()-50));
	}
	public void onMouseClick(Location point) //creates the food
	{
		if(!shotExisting && ammoCount>0)
		{
			shotProjectiles.add(new Projectile (point.getX()+launcher.getWidth()/3,myCanvas.getHeight()-launcher.getHeight(),Color.BLUE,-10,myCanvas));
	        shotExisting = true;
	        ammoCount--;
		}
	}
	public void run() //this is where the blocks are controlled
    {
		while(running)
		{
			for(int j = 0; j < shotProjectiles.size(); j++)
	        {
				 if(checkForOutOfBounds(shotProjectiles.get(j)))
					 shotExisting = false;
	             //if(shotProjectiles.get(j).getFood().overlaps(block))
	             //{ TODO make overlap method in the block class that take it as a point.
	        }
			pause(5);
		}
    } //end of run method
	public boolean checkForOutOfBounds(Projectile proj)
	{
		if(proj.getY()>myCanvas.getHeight()||proj.getY()<0)
			return true;
		else
			return false;
	}
	
	
}
