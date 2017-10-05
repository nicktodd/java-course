import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JListDemoApplet extends javax.swing.JApplet
{
	private JList myList;
	private JTextField tf;

	public void init()
	{
		String[] cars = {"Laguna", "Mondeo", "Vectra"};
		myList = new JList(cars);
		myList.setFixedCellWidth(80);
		tf = new JTextField(10);
		for(int i = 0; i < myList.getModel().getSize(); i++)  {
		  System.out.println(myList.getModel().getElementAt(i));
		}
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		getContentPane().add(myList);
		getContentPane().add(tf);


	}





}