import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

//To Do:

//  We need to add our event handling code to the Button component of this
//  applet

//  Implement Actionlister on this applet

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

//  Implement the actionPerformed() method


//  Within your actionPerformed() method, create a URL object based on the
//  value entered into the text field

//  Send the browser to that URL





//  Place the code that creates the URL inside a try/catch block.  Set the text field
//  to say something appropriate.


}