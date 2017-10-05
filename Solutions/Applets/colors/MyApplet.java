
import java.applet.*;
import java.awt.*;

public class MyApplet extends Applet
{
	private String text = "hello";
	private String color="red";

	public void init()
	{
		String s = getParameter("text");
		if (s!=null)
			text = s;
		String t = getParameter("color");
		if (t!=null)
			color = t;
		setColor();
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString(text, 10, 10);
		g.drawString(text, 20, 20);
		g.drawString(text, 30, 30);
		g.drawString(text, 40, 40);

	}

	public void setColor()
	{
		Graphics grap = getGraphics();

		if (color.equalsIgnoreCase("red"))
			grap.setColor(Color.red);
		else if (color.equalsIgnoreCase("blue"))
			grap.setColor(Color.blue);
		else if (color.equalsIgnoreCase("green"))
			grap.setColor(Color.green);
		else
			grap.setColor(Color.white);
	}


}