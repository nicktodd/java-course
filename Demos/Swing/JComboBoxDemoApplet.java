import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JComboBoxDemoApplet extends javax.swing.JApplet
{
	private JComboBox myBox;

	public void init()
	{
		String[] cars = {"Laguna", "Mondeo", "Vectra"};
		myBox = new JComboBox(cars);


		for(int i = 0; i < myBox.getModel().getSize(); i++)  {
		  System.out.println(myBox.getModel().getElementAt(i));
		}
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(myBox);




	}





}