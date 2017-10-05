
import java.applet.*;
import java.awt.*;

public class MyApplet extends Applet
{
	private String text = "hello";

	public void init()
	{
		String s = getParameter("text");
		if (s!=null)
			text = s;
	}

	public void paint(Graphics g)
	{
		g.drawString(text, 10, 10);
		g.drawString(text, 20, 20);
		g.drawString(text, 30, 30);
		g.drawString(text, 40, 40);

	}

}