import objectdraw.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Driver extends WindowController 
{
	private static final long serialVersionUID = 1L;
	
	private World w;
	private boolean difficultyChosen = false;
	private Text start,easyText,mediumText,hardText;
	private FramedRect easy, medium, hard;
	public static void main(String[] args)
	{
		new Driver().startController(600,600);
	}
	public void begin()
	{
		FilledRect background = new FilledRect(0,0,canvas.getWidth(), canvas.getHeight(), canvas);
		background.setColor(Color.black);
		start = new Text("Block Destroyer", canvas.getWidth()/10, canvas.getHeight()/30, canvas);
		start.setColor(Color.white);
		start.setFontSize(60);
		start.setFont("Calibri");
		start.setBold(true);
		
		easy = new FramedRect(50,200,canvas.getWidth()/4, canvas.getHeight()/8, canvas);
		easy.setColor(Color.white);
		easyText = new Text("Easy", easy.getX()+canvas.getWidth()/14, easy.getY()+canvas.getHeight()/30, canvas);
		easyText.setColor(Color.green);
		easyText.setFont("Calibri");
		easyText.setFontSize(30);
		easyText.setBold(true);
		
		medium = new FramedRect(easy.getX()+easy.getWidth()+10, 200, canvas.getWidth()/4, canvas.getHeight()/8, canvas);
		medium.setColor(Color.white);
		mediumText = new Text("Medium", medium.getX()+canvas.getWidth()/45, medium.getY()+canvas.getHeight()/30, canvas);
		mediumText.setColor(Color.orange);
		mediumText.setFont("Calibri");
		mediumText.setFontSize(30);
		mediumText.setBold(true);
		
		hard = new FramedRect(medium.getX()+medium.getWidth()+10, 200, canvas.getWidth()/4, canvas.getHeight()/8, canvas);
		hard.setColor(Color.white);
		hardText = new Text("Hard", hard.getX()+canvas.getWidth()/15, hard.getY()+canvas.getHeight()/30, canvas);
		hardText.setColor(Color.red);
		hardText.setFontSize(30);
		hardText.setFont("Calibri");
		hardText.setBold(true);
	}
	public void onMouseClick(Location point)
	{
		
		if(difficultyChosen && w != null)
		{
			w.onMouseClick(point);
		}
		else
		{
			if(easy.contains(point))
				w = new World(canvas,0);
			else if(medium.contains(point))
				w = new World(canvas,1);
			else if(hard.contains(point))
				w = new World(canvas,2);
			else
				return;
			
			clearStartScreen();
			difficultyChosen = true;
			
		}
			
	}
	public void onMouseMove(Location point)
	{
		if(w != null)
			w.onMouseMove(point);
	}
	public void clearStartScreen()
	{
		easy.removeFromCanvas();
		medium.removeFromCanvas();
		hard.removeFromCanvas();
		easyText.removeFromCanvas();
		mediumText.removeFromCanvas();
		hardText.removeFromCanvas();
		start.removeFromCanvas();
	}
}

