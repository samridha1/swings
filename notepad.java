package swings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.*;

public class notepad extends JFrame implements ActionListener{
	JMenuBar mnb;
	JMenu FileMenu,EditMenu;
	JMenuItem New;
	JMenuItem open,save,quit,cut,copy,paste;
	JPanel mainpanel;
	Container c;
	JTextArea ta1;
	Dimension dim;
	String msg,txt,str,dir,fname;
	ImageIcon img1;
	notepad()
	{
		super("notepad......");
		setSize(500,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		designGUI();
		
	}
	

	private void designGUI() {
		// TODO Auto-generated method stub
		mnb= new JMenuBar();
		FileMenu=new JMenu("file");
		EditMenu=new JMenu("edit");
		img1=new ImageIcon("s.gif");
		New=new JMenuItem("new",img1);
		open=new JMenuItem("open");
		save=new JMenuItem("save");
		quit=new JMenuItem("quit");
		cut=new JMenuItem("cut");
		copy=new JMenuItem("copy");
		paste=new JMenuItem("paste");
		
		FileMenu.add(New);
		FileMenu.add(save);
		FileMenu.add(open);
		FileMenu.add(new JSeparator());
		FileMenu.add(quit);
		EditMenu.add(cut);
		EditMenu.add(copy);
		EditMenu.add(paste);
		
		mnb.add(FileMenu);
		mnb.add(EditMenu);
		setJMenuBar(mnb);
		
		//to add shortcut
		quit.setMnemonic('q');
		//quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
		quit.addActionListener((ActionEvent e)->
				{
			System.exit(0);
				});
		
		//moving the mouse near to it we get this
		cut.setToolTipText("cut the text");
		//new way fro get domension
		dim=getToolkit().getScreenSize();
		int x=(int) dim.getHeight();
		int y=(int) dim.getWidth();
		c=getContentPane();
		c.setLayout(new BorderLayout());
		mainpanel=new JPanel();
		ta1=new JTextArea(x/18,y/12);
		mainpanel.add(new JScrollPane(ta1));
		c.add(mainpanel,BorderLayout.CENTER);
		mymethods();
		open.addActionListener(this);
		save.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		
	}


	private void mymethods() {
		// TODO Auto-generated method stub
		New.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ta1.setText(" ");
			}
			
		});
		
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new notepad();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//now s is a string it will store the word which is there on the option we have chosed 
		String s=e.getActionCommand();
	
		if(s.equalsIgnoreCase("open"))
		{
			try
		
		{
			str="";msg="";
			FileDialog fd=new FileDialog(this,"openfile",FileDialog.LOAD);
		//to be added
			fd.setVisible(true);
			dir=fd.getDirectory();
			//path is got by directory
			fname=fd.getFile();
			//fname will get the name of the file so together we get teh full location
			FileInputStream fis=new FileInputStream(dir+fname);
			//file inputstream reader class obj is fis 
			DataInputStream dis=new DataInputStream(fis);
			//here input it to datastream reader it is must
			str=dis.readLine();
			while(str!=null)
			{
				msg=msg+str+"\n";
				str=dis.readLine();
			}
			ta1.setText(msg);
			dis.close();
			fis.close();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	
		}
		if(s.equalsIgnoreCase("save"))
		{	try
		{
			FileDialog fd=new FileDialog(this,"savefile",FileDialog.SAVE);
		//to be added
			fd.setVisible(true);
			txt=ta1.getText();
			dir=fd.getDirectory();
			//path is got by directory
			fname=fd.getFile();
			//fname will get the name of the file so together we get teh full location
			FileOutputStream fis=new FileOutputStream(dir+fname);
			//file inputstream reader class obj is fis 
			DataOutputStream dis=new DataOutputStream(fis);
			//here input it to datastream reader it is must
			//str=dis.readLine();
			/*while(str!=null)
			{
				msg=msg+str+"\n";
				str=dis.readLine();
			}
			ta1.setText(msg);*/
			dis.writeBytes(txt);
			dis.close();
			fis.close();
		}
		catch(Exception a)
		{
			a.printStackTrace();
		}
	

		}
	
	if (s.equalsIgnoreCase("cut"))
	{
		msg=ta1.getSelectedText();
		if(msg==null)
			JOptionPane.showMessageDialog(this,"select text");
		else
			ta1.replaceRange("", ta1.getSelectionStart(), ta1.getSelectionEnd());
				
	}

	if (s.equalsIgnoreCase("copy"))
	{
		msg=ta1.getSelectedText();
		if(msg==null)
			JOptionPane.showMessageDialog(this,"select text");
	
			
				
	}
	
	if (s.equalsIgnoreCase("paste"))
	{
		
		ta1.replaceRange(msg, ta1.getSelectionStart(), ta1.getSelectionEnd());
			
				
	}
	
	
}
	

}
