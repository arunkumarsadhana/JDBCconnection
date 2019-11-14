package jdbcConn;
import java.awt.BorderLayout;

import javax.swing.*;
public class Container {
JFrame frame;
JLabel jlbl1,jlbl2,jlbl3;
static JTextField jtf1,jtf2,jtf3;
JButton jbt1,jbt2;
JPanel panel;
Container(){
	frame = new JFrame("DataBase Connection");
	jlbl1 = new JLabel("Name : ");
	jlbl2 = new JLabel("ID : ");
	jlbl3 = new JLabel("Salary : ");
	jtf1 = new JTextField(35);
	jtf2 = new JTextField(35);
	jtf3 = new JTextField(35);
	jbt1 = new JButton("Submit");
	jbt1.setActionCommand("submit");
	jbt1.addActionListener(new EventHandling());
	jbt2 = new JButton("Clear");
	jbt2.setActionCommand("clear");
	jbt2.addActionListener(new EventHandling());
	panel = new JPanel();
	panel.add(jlbl1);
	panel.add(jtf1);
	panel.add(jlbl2);
	panel.add(jtf2);
	panel.add(jlbl3);
	panel.add(jtf3);
	panel.add(jbt1);
	panel.add(jbt2);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(480,400);
	frame.getContentPane().add(BorderLayout.CENTER,panel);
	frame.setVisible(true);
}
}
