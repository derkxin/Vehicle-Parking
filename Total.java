import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter ;
import java.io.FileReader ;
import java.io.BufferedReader;
import java.util.Scanner ;
import java.text.DecimalFormat;
import java.io.File;
public class Total extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JButton but1 = new JButton("Cancel");
	JButton but2 = new JButton("Pay");
	JLabel title = new JLabel("CONFIRMATION PAYMENT");
	JLabel all = new JLabel("Total Fees (RM) : ");
	JLabel plate = new JLabel("Car Plate No. : ");
	JLabel fees = new JLabel("Parking Fees per hour(RM) : ");
	JLabel duration = new JLabel("Duration (hours) : ") ;
	JLabel alls = new JLabel();
	JLabel plateno = new JLabel();
	JLabel duration1 = new JLabel();
	JLabel fee = new JLabel();
	JLabel x = new JLabel();
	JLabel y = new JLabel();
	JLabel z = new JLabel();
	JLabel c = new JLabel();
	JLabel d = new JLabel();
	JTextField a = new JTextField(20);
	JTextField b = new JTextField(20);
	JTextField user4 = new JTextField(20);
	BufferedReader reader ;
	FileReader	fileReader ;
	FileWriter fileWriter ;
	Font myfont1 = new Font("Times Roman", Font.BOLD,15);
	Font myfont2 = new Font("Times Roman", Font.BOLD,12);
	Font myfont3 = new Font("Times Roman", Font.BOLD,20);
	public Total(){
		
		Container x = getContentPane();
		x.setLayout(null);
		x.add(but1);
		x.add(but2);
		x.add(all);
		x.add(alls);
		x.add(fee); 
		x.add(fees);
		x.add(duration);
		x.add(plate);
		x.add(plateno);
		x.add(duration1);
		x.add(title);
		
		title.setFont(myfont3);
		plate.setFont(myfont1);
		duration.setFont(myfont1);
		all.setFont(myfont1);
		fees.setFont(myfont1);
		plateno.setFont(myfont2);
		fee.setFont(myfont2);
		duration1.setFont(myfont2);
		alls.setFont(myfont2);
		
		title.setBounds(220,-190,300,500);
		plate.setBounds(275,-30,300,300);
		fees.setBounds(175,20,300,300);
		duration.setBounds(255,70,300,300);
		all.setBounds(260,120,300,300);
		
		plateno.setBounds(400,110,150,25);
		fee.setBounds(400,160,150,25);
		duration1.setBounds(400,210,150,25);
		alls.setBounds(400,260,150,25);
		
		but1.setBounds(190,350,150,50);
		but2.setBounds(365,350,150,50);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		frame.setLayout(null);
		setSize(700,500);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try{
				BufferedReader lineReader = new BufferedReader(new FileReader("information.txt"));
				String lineText = null;
				while((lineText = lineReader.readLine()) != null){
					String token[] = lineText.split("@") ;
					 plateno.setText(token[2]) ;
					 fee.setText(token[3])  ;
					 duration1.setText(token[4]) ;
					 a.setText(token[5]);
					 b.setText(token[6]);
				}
				lineReader.close();
			}catch(Exception e){JOptionPane.showMessageDialog(null, e+"");}
			
			if (fee.getText().equals("0.30")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.30 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText( df);
				user4.setText(df);
			}else if (fee.getText().equals("0.40")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.40 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText( df);
				user4.setText(df);
			}else if (fee.getText().equals("0.50")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.50 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText(df);
				user4.setText(df);
			}else if (fee.getText().equals("0.60")){
				double timezone = Double.parseDouble(duration1.getText());
				double totalfee = 0.60 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText(df);
				user4.setText(df);
			}else if (fee.getText().equals("0.70")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.70 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText( df);
				user4.setText(df);
			}else if (fee.getText().equals("0.80")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.80 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText( df);
				user4.setText(df);
			}else if (fee.getText().equals("0.90")){
				double timezone = Double.parseDouble(duration1.getText()); 
				double totalfee = 0.90 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText(  df);
				user4.setText(df);
			}else if (fee.getText().equals("1.00")){
				double timezone = Double.parseDouble(duration1.getText());
				double totalfee = 1.0 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText(  df);
				user4.setText(df);
			}else if (fee.getText().equals("1.50")){
				double timezone = Double.parseDouble(duration1.getText());
				double totalfee = 1.50 * timezone ;
				String df = String.format("%.2f", totalfee);
				alls.setText( df);
				user4.setText(df);
			}
			
			JLayeredPane bg = new JLayeredPane(){
				public void paintComponent(Graphics g){
					Image img = Toolkit.getDefaultToolkit().getImage(Total.class.getResource("5.png"));
					g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
				}
			};
			bg.setBounds(0,0,700,500);
			this.add(bg,BorderLayout.CENTER);
			
		
	}
	public void actionPerformed(ActionEvent event){
		

		if (event.getSource() == but1){
			dispose();
			new Car();
		}else if (event.getSource() == but2){
			
			File in = new File("Accounts.txt");
			File out = new File("temp.txt");
			try{
				BufferedReader br1 = new BufferedReader(new FileReader("information.txt"));
				String line1 = null;
				while((line1 = br1.readLine()) != null){
					String token[] = line1.split("@") ;
					c.setText(token[0]);
					d.setText(token[1]);
					plateno.setText(token[2]) ;
					fee.setText(token[3])  ;
					duration1.setText(token[4]) ;
					a.setText(token[5]);
					b.setText(token[6]);
					
					BufferedReader br2 = new BufferedReader(new FileReader("Accounts.txt"));
					String line2 = null;
					while((line2 = br2.readLine()) != null){
						String token1[] = line2.split("@") ;
						x.setText(token1[0]) ;
						y.setText(token1[1]) ;
						z.setText(token1[2]) ;
						
						if((c.getText().equals(x.getText())) && (d.getText().equals(y.getText()))){
							double q = Double.parseDouble(user4.getText());
							double w = Double.parseDouble(z.getText());
							if(w >= q){
											double total1 = w - q ;
											String df = String.format("%.2f", total1);
											z.setText(df);
											
													
											FileWriter fw1 = new FileWriter(out,true);
											fw1.write(x.getText() + "@" + y.getText() + "@" + z.getText() + "\n");
											fw1.close();
													
													
											BufferedReader br3 = new BufferedReader(new FileReader(in));					
											FileWriter fw2 = new FileWriter(out,true);					
											String line3 = br3.readLine();
											while(line3 != null){						
												if(!line3.startsWith(x.getText())){
													if(!line3.startsWith(y.getText())){
													fw2.write(line3 + "\n");
													}
												}
												line3 = br3.readLine();
											}
											
											br3.close();
											fw2.close();
											br2.close();
											br1.close();
											in.delete();
											out.renameTo(in);
											fileWriter = new FileWriter("information.txt");
											fileWriter.write(plateno.getText() +"@" + "RM" + alls.getText() + "@" + duration1.getText() + "@" + a.getText() + "@" + b.getText() );
											fileWriter.close();
											JOptionPane.showMessageDialog(frame, "Payment Successful!");
											dispose();
											new Invoice();
										}else{
											JOptionPane.showMessageDialog(frame, "Insufficient Balance! Please Top Up!");
										}
						}
					}	
					br2.close();
				}	
				br1.close();				
			}catch(Exception e){ e.printStackTrace();}		
		}
	}
}






