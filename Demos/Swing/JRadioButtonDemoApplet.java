import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JRadioButtonDemoApplet extends javax.swing.JApplet
{
	private JRadioButton one, two, three;
	private ButtonGroup group;

	public void init()
	{
		one = new JRadioButton("One");
		two = new JRadioButton("Two");
		three = new JRadioButton("Three");

		one.setActionCommand("one");
		two.setActionCommand("two");
		three.setActionCommand("three");

		group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(one);
		getContentPane().add(two);
		getContentPane().add(three);

		String selected = group.getSelection().getActionCommand();

	}





}