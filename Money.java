import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.border.Border;
import java.io.FileWriter;
import java.io.File;
import java.io.*;

public class Money extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JLabel titles = new JLabel("Select Top up values (MYR):");
	JLabel ID = new JLabel("Enter ID : ");
	JLabel pass = new JLabel("Enter Password : ");
	JLabel money = new JLabel("Enter Values : ");
	JTextField money1 = new JTextField(20);
	JTextField ID1 = new JTextField(20);
	JTextField pass1 = new JTextField(20);
	JTextField user1 = new JTextField(20);
	JTextField user2 = new JTextField(20);
	JTextField user3 = new JTextField(20);
	JButton but1 = new JButton("5");
	JButton but2 = new JButton("10");
	JButton but3 = new JButton("20");
	JButton but4 = new JButton("50");
	JButton but5 = new JButton("100");		
	JButton but6 = new JButton("CANCEL");
	JButton but7 = new JButton("CONFIRM");
	BufferedReader reader ;
	FileReader	fileReader ;
	Font myfont = new Font("Times Roman", Font.BOLD,15);
	FileWriter fileWriter ;
	public Money(){
		Container x = getContentPane();
		x.setLayout(null);
		x.add(titles);
		x.add(money);
		x.add(money1);
		x.add(ID);
		x.add(ID1);
		x.add(user1);
		x.add(user2);
		x.add(user3);
		x.add(pass);
		x.add(pass1);
		x.add(but1);
		x.add(but2);
		x.add(but3);
		x.add(but4);
		x.add(but5);
		x.add(but6);
		x.add(but7);
		
		titles.setFont(myfont);
		
		ID.setBounds(200,-60,300,300);
		ID1.setBounds(300,75,150,25);
		pass.setBounds(150,0,300,300);
		pass1.setBounds(300, 135,150,25);
		titles.setBounds(200,50,500,300);
		but1.setBounds(180,250,80,50);
		but2.setBounds(260,250,80,50);
		but3.setBounds(340,250,80,50);
		but4.setBounds(180,300,80,50);
		but5.setBounds(260,300,80,50);
		money.setBounds(160,240,300,300);
		money1.setBounds(300,380,150,25);
		but6.setBounds(130,450,150,50);
		but7.setBounds(300,450,150,50);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		
		frame.setLayout(null);
		setSize(620,650);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane bg = new JLayeredPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Money.class.getResource("3.jpg"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			}
		};
		bg.setBounds(0,0,600,600);
		this.add(bg,BorderLayout.CENTER);

	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == but1){
			money1.setText("5");	
		}else if (event.getSource() == but2){
			money1.setText("10");	
		}else if (event.getSource() == but3){
			money1.setText("20");
		}else if (event.getSource() == but4){
			money1.setText("50");
		}else if (event.getSource() == but5){
			money1.setText("100");
		}else if (event.getSource() == but6){
			dispose();
			new Homepage();
		}
			File x = new File("Accounts.txt");
			File y = new File("temp.txt");
			try{
					BufferedReader lineReader = new BufferedReader(new FileReader(x));
					String lineText = null;
					while((lineText = lineReader.readLine()) != null){
						String token[] = lineText.split("@") ;
						user1.setText(token[0]) ;
						user2.setText(token[1]) ;
						user3.setText(token[2]) ;
						
						if( (ID1.getText().equals(user1.getText())) && (pass1.getText().equals(user2.getText())) ){
							if (event.getSource() == but7){
								double fee = Double.parseDouble(money1.getText());
								double d = Double.parseDouble(user3.getText());
								double total = d + fee ;
								String df = String.format("%.2f", total);
								user3.setText(df);
								FileWriter fw2 = new FileWriter(y,true);
								fw2.write(user1.getText() + "@" + user2.getText() + "@" + user3.getText() + "\n");
								fw2.close();
								
								
								BufferedReader br1 = new BufferedReader(new FileReader(x));					
								FileWriter fw1 = new FileWriter(y,true);					
								String line1 = br1.readLine();
								while(line1 != null){						
									if(!line1.startsWith(ID1.getText())){
										if(!line1.startsWith(pass1.getText())){
										fw1.write(line1 + "\n");
										}
									}
									line1 = br1.readLine();
								}
								fw1.close();
								br1.close();
								lineReader.close();
								x.delete();
								y.renameTo(x);
								JOptionPane.showMessageDialog(frame, "Top UP Successfully!");
								dispose();
								new Homepage();
								
							}
						}
					}
					lineReader.close();

					
			}catch(Exception e){ e.printStackTrace();}		
			
	
	}
}