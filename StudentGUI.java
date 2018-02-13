/*
Andrew Grosskurth
CIST 2372
Lab #6----Part 1----
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentGUI extends JFrame implements ActionListener{
		
		private JButton b1 = new JButton("Find");
		private JButton b2 = new JButton("Insert");
		private JButton b3 = new JButton("Delete");
		private JButton b4 = new JButton("Update");
		private JButton b5 = new JButton("Exit");
		private JTextField tf1 = new JTextField();
		private JTextField tf2 = new JTextField();
		private JTextField tf3 = new JTextField();
		private JTextField tf4 = new JTextField();
		private JTextField tf5 = new JTextField();
		private JTextField tf6 = new JTextField();
		private JTextField tf7 = new JTextField();
		private JTextField tf8 = new JTextField();
		private JTextField tf9 = new JTextField();
	
	public StudentGUI()
	{
		JFrame f1 = new JFrame("Student GUI");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JLabel l1 = new JLabel("Student Info");
		p1.add(l1);
		
		p2.setLayout(new GridLayout(9,2));
		JLabel l2 = new JLabel("ID:");
		JLabel l3 = new JLabel("First Name:");		
		JLabel l4 = new JLabel("Last Name:");
		JLabel l5 = new JLabel("Street:");
		JLabel l6 = new JLabel("City:");
		JLabel l7 = new JLabel("State:");
		JLabel l8 = new JLabel("Zipcode:");
		JLabel l9 = new JLabel("Email:");
		JLabel l10 = new JLabel("GPA:");
		p2.add(l2);
		p2.add(tf1);
		p2.add(l3);
		p2.add(tf2);
		p2.add(l4);
		p2.add(tf3);
		p2.add(l5);
		p2.add(tf4);
		p2.add(l6);
		p2.add(tf5);
		p2.add(l7);
		p2.add(tf6);
		p2.add(l8);
		p2.add(tf7);
		p2.add(l9);
		p2.add(tf8);
		p2.add(l10);
		p2.add(tf9);
		
		p3.setLayout(new FlowLayout());
		b1.setToolTipText("Find student info given the student ID");
		b2.setToolTipText("Insert new student information(Requires all fields)");
		b3.setToolTipText("Delete student information of the given student ID");
		b4.setToolTipText("Update student information of the given student ID(Use find first, then change information and press update)");
		b5.setToolTipText("Close the Application");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		p3.add(b1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		
		f1.setLayout(new BorderLayout());
		f1.add(p1, BorderLayout.NORTH);
		f1.add(p2, BorderLayout.CENTER);
		f1.add(p3, BorderLayout.SOUTH);
		f1.setLocation(100,300);
		f1.setSize(400,350);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b5)
		{
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to close?", "Close?", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		else if(e.getSource() == b1)
		{
			try
			{
			Student s1 = new Student();
			int id = Integer.parseInt(tf1.getText());
			String zip = Integer.toString(s1.getZipcode());
			s1.selectDB(id);
			tf2.setText(s1.getFirstName());
			tf3.setText(s1.getLastName());
			tf8.setText(s1.getEMail());
			tf4.setText(s1.getStreet());
			tf5.setText(s1.getCity());
			tf6.setText(s1.getState());
			tf7.setText(zip);
			double gpa = s1.getGPA();
			double roundOff = Math.round(gpa * 100.0) / 100.0;
			tf9.setText(Double.toString(roundOff));
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		else if(e.getSource() == b2)
		{
			Student s2 = new Student();
			String fn = tf2.getText();
			String ln = tf3.getText();
			String em = tf8.getText();
			String str = tf4.getText();
			String cit = tf5.getText();
			String sta = tf6.getText();
			int zip2 = Integer.parseInt(tf7.getText());
			int id2 = Integer.parseInt(tf1.getText());
			double gpa2 = Double.parseDouble(tf9.getText());
			s2.insertDB(id2, fn, ln, str, cit, sta, zip2, em, gpa2);
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf8.setText("");
			tf9.setText("");
		}
		else if(e.getSource() == b3)
		{
			Student s3 = new Student();
			int id3 = Integer.parseInt(tf1.getText());
			s3.selectDB(id3);
			s3.deleteDB();
			tf1.setText("");
		}
		else if(e.getSource() == b4)
		{
			Student s4 = new Student();
			int id4 = Integer.parseInt(tf1.getText());
			int zip3 = Integer.parseInt(tf7.getText());
			double gpa3 = Double.parseDouble(tf9.getText());
			s4.setID(id4);
			s4.setFirstName(tf2.getText());
			s4.setLastName(tf3.getText());
			s4.setStreet(tf4.getText());
			s4.setCity(tf5.getText());
			s4.setState(tf6.getText());
			s4.setZipcode(zip3);
			s4.setEMail(tf8.getText());
			s4.setGPA(gpa3);
			s4.updateDB();
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf7.setText("");
			tf8.setText("");
			tf9.setText("");
		}
	}
	
	public static void main(String args[])
	{
		StudentGUI sg = new StudentGUI();
	}
}