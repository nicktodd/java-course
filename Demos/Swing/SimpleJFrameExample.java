import javax.swing.*;
import java.awt.*;

public class SimpleJFrameExample extends JFrame
{
	public SimpleJFrameExample (String s)
      {
          super (s); 		// title passed to superclass
		  getContentPane().setLayout(new FlowLayout());
		  setJMenuBar(new JMenuBar());
	      JButton b = new JButton("OK");
	      getContentPane().add(b);
	      pack();	// set the size (0 by default)
	      setVisible (true);	// make visible to the user



	}

	public static void main(String[] args)
	{
		SimpleJFrameExample f = new SimpleJFrameExample("Title in here");

	}
}
