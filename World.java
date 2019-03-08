
import objectdraw.*;
import java.awt.*;
import java.util.LinkedList;
public class World extends ActiveObject
{
	LinkedList<Projectile> shotProjectiles = new LinkedList<Projectile>();
	private boolean running = true;
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
		if(ammoCount>0)
		{
			shotProjectiles.add(new Projectile (point.getX()+launcher.getWidth()/3,myCanvas.getHeight()-launcher.getHeight(),Color.BLUE,-10,myCanvas));
	        ammoCount--;
		}
	}
	public void run() //this is where the blocks are controlled
    {
		while(running)
		{
			for(int i = 0; i < shotProjectiles.size(); i++)
	        {
				 if(checkForOutOfBounds(shotProjectiles.get(i)))
				 {
					 shotProjectiles.get(i).removeFromCanvas();
					 shotProjectiles.remove(i);
				 }
				 else if(blocks.checkForHit(new Location(shotProjectiles.get(i).getX(),shotProjectiles.get(i).getY())))
				 {
					 //explosion occur
					 shotProjectiles.get(i).removeFromCanvas();
					 shotProjectiles.remove(i);
				 }
	        }
			pause(1);
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
