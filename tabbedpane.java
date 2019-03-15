package swings;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class tabbedpane extends JFrame{
	JTabbedPane tpane;
	JPanel p1,p2,p3,toppanel;
	tabbedpane()
	{
		setTitle("tabbed pane");
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		designGUI();
	}
	private void designGUI() 
	{
		// TODO Auto-generated method stub
		toppanel=new JPanel();
		toppanel.setLayout(new BorderLayout());
		getContentPane().add(toppanel);
		createTab1();
		createTab2();
		createTab3();
		tpane=new JTabbedPane();
		tpane.add("Login",p1);
		toppanel.add(tpane,BorderLayout.CENTER);

	}
	private void createTab3() {
		
		p3=new JPanel();
		JLabel l1,l2,l3;
		JButton b1;
		JTextField t1;
		JTextArea ta1;
		JRadioButton r1,r2,r3;
		ButtonGroup bg;
		JComboBox ch1;
		String[]s={"cse","ec","mech"};
		JPanel p4;
		l1=new JLabel("enter ur name");
		l2=new JLabel("choose ur branch");
		l3=new JLabel("select ur semester");
		t1=new JTextField(25);
		ta1=new JTextArea(50,50);
		b1=new JButton("submit");
		p4=new JPanel();
		r1=new JRadioButton("I");
		r2=new JRadioButton("II");
		r3=new JRadioButton("III");
		ch1=new JComboBox(s);
		bg=new ButtonGroup();
		bg.add(r1);bg.add(r2);bg.add(r3);
		p4.add(r1);p4.add(r2);p4.add(r3);
		p3.add(l1);p3.add(t1);
		p3.add(l2);p3.add(ch1);
		p3.add(l3);p3.add(p4);
		p3.add(b1);p3.add(ta1);
		setLayout(null);
		l1.setBounds(20,20,120,30);t1.setBounds(180,20,120,30);
		l2.setBounds(20,70,120,30);ch1.setBounds(180,70,120,30);
		l3.setBounds(20,120,120,30);p4.setBounds(180,120,120,30);
		b1.setBounds(20,170,120,30);ta1.setBounds(180,170,120,30);
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s1,s2;
				
				s1=t1.getText()+"\n"+ch1.getSelectedItem();
				if(r1.isSelected())
					s2=r1.getLabel();
				
				else if(r2.isSelected())
					s2=r2.getLabel();
				else
					s2=r3.getLabel();

				ta1.setText(s1+"  "+s2);
				
				
			}
			
		});
		

		
		
		
		
		
		

		
		
	}
	private void createTab2() {
		// TODO Auto-generated method stub
		p2=new JPanel(new BorderLayout());
		JButton b1,b2,b3,b4,b5;
		JLabel l1;
		ImageIcon img;
		img=new ImageIcon("tomcat.gif");
		l1=new JLabel("");
		b1=new JButton("NORTH");
		b2=new JButton("EAST");
		b3=new JButton("SOUTH");
		b4=new JButton("WEST");
		//b5=new JButton("CENTRE");
		p2.add(b1,BorderLayout.NORTH);
		p2.add(b2,BorderLayout.EAST);
		p2.add(b3,BorderLayout.SOUTH);
		p2.add(b4,BorderLayout.WEST);
		p2.add(l1,BorderLayout.CENTER);
		b1.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						l1.setIcon(img);
						
					}
			
				});
			
		
		
		
	}
	private void createTab1() {
		// TODO Auto-generated method stub
		JLabel l1,l2;
		JButton b1,b2;
		JTextField t1;
		JPasswordField ps1;
		l1=new JLabel ("user name");
		l2=new JLabel ("password");
		t1=new JTextField(25);
		ps1=new JPasswordField(25);
		b1=new JButton("submit");
		b2=new JButton("cancel");
		p1=new JPanel();p1.setLayout(null);
		l1.setBounds(20,40,120,30);
		t1.setBounds(20,90,120,30);
		l2.setBounds(20,140,120,30);
		ps1.setBounds(20,190,120,30);
		b1.setBounds(20,250,120,30);
		b2.setBounds(180,250,120,30);
		p1.add(l1);	p1.add(t1);
		p1.add(l2);	p1.add(ps1);
		p1.add(b1);	p1.add(b2);
		//every button code individually
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(t1.getText().equals("hi")&&ps1.getText().equals("hello"))
				{
					tpane.addTab("Borders",p2);
					tpane.addTab("dataEntry",p3);
					tpane.removeTabAt(0);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid user or password","error..",JOptionPane.OK_OPTION);
					t1.setText("");
					ps1.setText("");
					t1.requestFocus();
					//for cursor to be there

				}
			}
			
		});
		b2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method st
				System.exit(0);
				
			}
			
		});
		
		
		
		
	}
	public static void main(String[] args) {
		new tabbedpane();
	}

}
