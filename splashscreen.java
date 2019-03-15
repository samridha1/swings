package swings;

import java.awt.*;

import javax.swing.*;

public class splashscreen extends JWindow{
	int duration;
	splashscreen(int d)
	{
		duration=d;
	}
	void showSplash()
	{
		JLabel l1,l2;
		JButton b1;
		ImageIcon img1;
		JPanel content =(JPanel)getContentPane();
		content.setBackground(Color.cyan);
		int width=300,height=1000;
		Dimension scrn=Toolkit.getDefaultToolkit().getScreenSize();
		//dimenstion is class here scrn has many values we need only height
		int x=(scrn.width)/4;
		int y=(scrn.height)/4;
		setBounds(x,y,width,height);
		//full screen bounds this is
		l1=new JLabel("welcome");
		l2=new JLabel("developed by sa");
		l1.setFont(new Font("Arial",Font.BOLD,16));
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,19));
		l1.setForeground(Color.BLUE);
		l2.setForeground(Color.red);
		img1=new ImageIcon("1.png");
		b1=new JButton(img1);
		content.add(l1,BorderLayout.NORTH);
		content.add(l2,BorderLayout.SOUTH);
		content.add(b1,BorderLayout.CENTER);
		content.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		setVisible(true);
		try
		{
			Thread.sleep(duration);
		}
		catch(Exception e)
		{
			
		}
		setVisible(false);
		
		
	}

}
