import objectdraw.*;
public class Driver extends WindowController 
{
	private static final long serialVersionUID = 1L;
	
	private World w;
	public static void main(String[] args)
	{
		new Driver().startController(600,600);
	}
	public void begin()
	{
		w = new World(canvas);
	}
	public void onMouseClick(Location point)
	{
		if(w != null)
			w.onMouseClick(point);
	}
	public void onMouseMove(Location point)
	{
		if(w != null)
			w.onMouseMove(point);
	}
}

