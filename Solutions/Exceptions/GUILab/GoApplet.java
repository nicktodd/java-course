import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

public class GoApplet extends Applet implements ActionListener
{
	private URL url;
	private TextField newPage;
	private Button go;

	public void init()
	{
		add (newPage = new TextField(25));
		add (go = new Button("Go"));
		go.addActionListener(this);
	}

	public void actionPerformed (ActionEvent evt)
	{
		if (!(newPage.getText().equals("")))
		{
			try
			{
				url = new URL(newPage.getText());
				AppletContext context = getAppletContext();
				context.showDocument(url, "_blank");
			}
			catch (MalformedURLException e)
			{
				newPage.setText("Invalid URL");
			}
		}
	}


}