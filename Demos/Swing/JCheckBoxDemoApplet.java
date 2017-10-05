import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JCheckBoxDemoApplet extends javax.swing.JApplet
{
	private JCheckBox one, two, three;

	public void init()
	{
		one = new JCheckBox("One");
		two = new JCheckBox("Two");
		three = new JCheckBox("Three");

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(one);
		getContentPane().add(two);
		getContentPane().add(three);

	}





}