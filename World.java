
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
	 * Easy - Ammo = 100, Movement speed = 1
	 * Medium - Ammo = 70, Movement speed = 1
	 * Hard - Ammo = 70, Movement speed = 2
	*/
	public World(DrawingCanvas c, int difficulty)
	{
		int mvm;
		if(difficulty == 2)
			mvm = 2;
		else
			mvm = 1;
		
		if(difficulty == 0)
			ammoCount = 100;
		else
			ammoCount = 70;
		
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
		if(ammoCount > 0 && running) 
		{	//launch a projectile.
			shotProjectiles.add(new Projectile (point.getX()+launcher.getWidth()/3,myCanvas.getHeight()-launcher.getHeight(),Color.BLUE,-10,myCanvas));
	        ammoCount--;
	        scoreKeeper.setAmmo(ammoCount);
	        if(ammoCount==0)
        		running = false;
		}
	}
	public void run() //this is where the blocks are controlled
    {
		while(running) //game loop
		{
			for(int i = 0; i < shotProjectiles.size(); i++)
	        {
				 HitData message = blocks.checkForHit(new Location(shotProjectiles.get(i).getX(),shotProjectiles.get(i).getY()));
				 if(checkForOutOfBounds(shotProjectiles.get(i)))
				 {
					 shotProjectiles.get(i).removeFromCanvas();
					 shotProjectiles.remove(i);
					 continue;
				 }
				 if(message.getResponse())
				 {
					 //increment score;
					 //colors work as score multipliers: green = 1, yellow = 2, orange = 4, red = 8
					 if(message.getColor() == Color.GREEN)
					 {
						 score++;
					 }
					 if(message.getColor() == Color.YELLOW)
					 {
						 score += 2;
					 }
					 if(message.getColor() == Color.ORANGE)
					 {
						 score += 4;
					 }
					 if(message.getColor() == Color.RED)
					 {
						 score += 8;
					 }
					 //do all score calculations.
					 score++;
					 scoreKeeper.setScore(score);
					 shotProjectiles.get(i).removeFromCanvas();
					 shotProjectiles.remove(i);
				 }
	        }
			checkForWin(false); //checks for a win but won't declare it a loss if not a win.
			pause(1);
		}
		if(!running)
		{
			checkForWin(true); //checks for a win and will declare it a loss if not a win.
		}
    }
	public boolean checkForOutOfBounds(Projectile proj)
	{
		if(proj.getY()>myCanvas.getHeight()||proj.getY()<0)
			return true;
		else
			return false;
	}
	public void checkForWin(Boolean forceChoice)
	{
		if(blocks.getNumberOfBlocksLeft() == 0)
			new Text("You win!",myCanvas.getWidth()/5,myCanvas.getWidth()/2,myCanvas).setFontSize(72);
		else if(!forceChoice)
			return;
		else
			new Text("You lose! ",myCanvas.getWidth()/5,myCanvas.getWidth()/2,myCanvas).setFontSize(72);
	
		new Text("Your Score was "+score,myCanvas.getWidth()/5,myCanvas.getWidth()/2+75,myCanvas).setFontSize(42);
	}
	
	
}
