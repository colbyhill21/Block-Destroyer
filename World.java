
import objectdraw.*;
import java.awt.*;
import java.util.LinkedList;
public class World extends ActiveObject
{
	LinkedList<Projectile> shotProjectiles = new LinkedList<Projectile>();
	private boolean running = true;
	private int ammoCount = 100, score = 0;
	private DrawingCanvas myCanvas;
	private BlockSet blocks;
	private Launcher launcher;
	private Scoreboard scoreKeeper;
	/*difficulty levels: Easy = 0, Medium = 1, Hard = 2.
	 * Easy - Ammo = 120, Movement speed = 1
	 * Medium - Ammo = 80, Movement speed = 1
	 * Hard - Ammo = 80, Movement speed = 2
	*/
	public World(DrawingCanvas c, int difficulty)
	{
		int mvm;
		if(difficulty == 2)
			mvm = 2;
		else
			mvm = 1;
		
		if(difficulty == 0)
			ammoCount = 120;
		else
			ammoCount = 80;
		
		myCanvas = c;
		launcher = new Launcher(myCanvas,Color.GREEN);
		blocks = new BlockSet(10,10,mvm,myCanvas);
		scoreKeeper = new Scoreboard(new Location(10,200),myCanvas,ammoCount,score);
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
	        scoreKeeper.setAmmo(ammoCount);
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
