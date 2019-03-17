import java.awt.*;
public class HitData 
{
	private boolean response;
	private Color myColor;
	//messenger object because Java doesn't have Tuples :(
	public HitData(boolean res, Color c)
	{
		this.response = res;
		this.myColor = c;
	}
	public boolean getResponse() 
	{
		return response;
	}
	public void setResponse(boolean response)
	{
		this.response = response;
	}
	public Color getColor() 
	{
		return myColor;
	}
	public void setColor(Color myColor)
	{
		this.myColor = myColor;
	}
	
}
