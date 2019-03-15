package swings;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class validation extends JFrame{
	int i,z;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5,t6;
	JTextArea ta1;
	JList lst1;
	ButtonGroup bg;
	JRadioButton jrb[];
	String[] gr={"a","b","c","d","e"};
	String[] area={"udupi","manipal","chennai","mumbai","alaphuzha"};
	JPanel p1;
	Date dt1,dt2;
	JButton b1;
	String s;
	validation()
	{
		setTitle("validation");
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		designGUI();
		mymethod();
	}
	private void mymethod() {
		// TODO Auto-generated method stub
		
		
			jrb[1].addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stu
							
					t3.setText("100");
					
				}
				
			});

			
			
			jrb[2].addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stu
							
					t3.setText("200");
					
				}
				
			});
			
			
			jrb[0].addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stu
							
					t3.setText("0");
					
				}
				
			});
			
			jrb[3].addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stu
							
					t3.setText("90");
					
				}
				
			});
			
			jrb[4].addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stu
							
					t3.setText("80");
					
				}
				
			});

		t1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
				{
				e.consume();
				//show on Jtextbox
				//not !Character.isDigit(c) means it will takeonly numbers
				}		
			}
			
		});
		t1.addKeyListener(new KeyAdapter()
		{
			public void KeyTyped(KeyEvent e)
			{
				
			}
		});
		t2.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
				{
				e.consume();
				//sshow on etxt bok
				//not !Character.isDigit(c) means it will takeonly numbers
				}		
			}
			
		});
		t2.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				t1.setEditable(false);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				int x=t2.getText().length();
				if(x<3)
				{
					JOptionPane.showMessageDialog(null, "invaid");
					t2.setText(" ");
					t2.requestFocus();
				}
			}
			
		});
		t3.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				char c=e.getKeyChar();
				if(!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)
				{
				e.consume();
				//sshow on etxt bok
				//not !Character.isDigit(c) means it will takeonly numbers
				}		
			}
			
		});
		
		t3.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@ Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				int m=Integer.parseInt(t3.getText());
				int n=Integer.parseInt(t4.getText());
				
				if(n<1||n>100)
				{
					JOptionPane.showMessageDialog(null, "cost not within limit");
					t4.setText(" ");
					t4.requestFocus();

				}
				else
				{
					int z=n*m;
					t6.setText(String.valueOf(z));
				}
				
			}
			
		});
		t5.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
				// we have to put try catch because if we supply invalid it will give error msm
				try
				{
					dt2=sdf.parse(t5.getText());
					//here parse will convert what is in t5 in to sdf format
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(dt2.after(dt1))
				{
					JOptionPane.showMessageDialog(null, "invalid date");
					t5.setText(s);
				}
				
			}
			
		});
		b1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String s1,s2;
				s1=t1.getText()+"\n"+t2.getText()+"\n"+t3.getText()+"\n"+t4.getText()+"\n"+t5.getText();
				ta1.setText(s1);
				//int j=lst1.getSelectedIndex();
				
			
		
				
				// TODO Auto-generated method stub
				
			}
			
		});
		
	
		
		
		

		
	}
	private void designGUI()
	{
		// TODO Auto-generated method stub
		Container c=getContentPane();
		c.setLayout(new GridLayout(9,2,10,10));
		l1=new JLabel("code no");
		l2=new JLabel("prod name");
		l3=new JLabel("grade");
		l4=new JLabel("cost");
		l5=new JLabel("sale area");
		l6=new JLabel("sale quantity");
		l7=new JLabel("sale date");
		l8=new JLabel("sale value");
		l9=new JLabel("enter quantity first");
		t1=new JTextField(25);
		t2=new JTextField(25);
		t3=new JTextField(25);
		t4=new JTextField(25);
		t5=new JTextField(25);
		t6=new JTextField(25);
		lst1 = new JList();
		lst1.setListData(gr);
		//list allow mutliple options selsction by default
		lst1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		p1=new JPanel();
		bg=new ButtonGroup();
		jrb=new JRadioButton[area.length];
		for(int i=0;i<area.length;i++)
		{
			jrb[i]=new JRadioButton(area[i]);
			bg.add(jrb[i]);
			p1.add(jrb[i]);
		}
		b1=new JButton(" submit");
		ta1=new JTextArea(10,50);
		
		//for tadays date to come
		dt1 =new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");//cap gives monday 
		s=sdf.format(dt1);
		t5.setText(s);
		c.add(l1);c.add(t1);
		c.add(l2);c.add(t2);
		c.add(l3);c.add(new JScrollPane(lst1));
		c.add(l6);c.add(t4);
		c.add(l5);c.add(p1);
		c.add(l4);c.add(t3);
		c.add(l7);c.add(t5);
		c.add(l8);c.add(t6);
		c.add(b1);c.add(ta1);
		
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new validation();
	}

}
//for list use"" getSelectedIndex()==0""""
//""getselectedValue==a
//""getSelectedItem().toString() will convert it to into string 
//for list listSelectionListener
//choiceListener()
//radio button actionLIstener
//