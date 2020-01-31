import java.awt.Color;

import objectdraw.*;
public class Scoreboard 
{
	private int ammo, score;
	private FramedRect shell;
	private Text ammoHolder, scoreHolder;
	public Scoreboard(Location point, DrawingCanvas canvas, int ammoCount, int uScore)
	{
		ammo = ammoCount;
		score = uScore;
		shell = new FramedRect(point.getX(),point.getY(),100,40,canvas);
		shell.setColor(Color.white);
		ammoHolder = new Text(" Ammo: "+ammoCount,point.getX(),point.getY()+2,canvas);
		ammoHolder.setFont("Calibri");
		ammoHolder.setColor(Color.white);
		scoreHolder = new Text(" Score: "+uScore,point.getX(),point.getY()+ammoHolder.getHeight(),canvas);
		scoreHolder.setFont("Calibri");
		scoreHolder.setColor(Color.white);
	}

	public int getAmmo() 
	{
		return ammo;
	}

	public void setAmmo(int ammo) 
	{
		this.ammo = ammo;
		ammoHolder.setText(" Ammo: "+ammo);
		
	}

	public int getScore() 
	{
		return score;
	}

	public void setScore(int score) 
	{
		this.score = score;
		scoreHolder.setText(" Score: "+score);
	}
}
