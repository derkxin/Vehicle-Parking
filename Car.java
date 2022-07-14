import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter ;
import java.io.FileReader ;
import java.io.BufferedReader;
public class Car extends JFrame implements ActionListener{
	JFrame frame = new JFrame() ;
	JLabel ID = new JLabel ("Enter ID : ");
	JLabel pass = new JLabel("Enter Password : ");
	JLabel plateno = new JLabel("Vehicle Plate No. : ");
	JLabel car_type = new JLabel("Vehicle Type : ");
	JLabel place = new JLabel("Local Council : ");
	JLabel fees = new JLabel("Parking Fees per hour (RM): ");
	JLabel duration = new JLabel("Parking Duration (hours) : ");
	JButton but1 = new JButton("Cancel");
	JButton but2 = new JButton("Continue");
	JTextField ID1 = new JTextField (20);
	JTextField pass1 = new JTextField(20);
	JTextField user1 = new JTextField(15);
	JTextField user2 = new JTextField(15);
	JTextField plate_no = new JTextField(15);
	JLabel fee = new JLabel();
	JComboBox cartype = new JComboBox();  
	JComboBox place1 = new JComboBox();
	JComboBox time = new JComboBox();
	FileWriter fileWriter ;
	Container y = getContentPane();
	Font myfont1 = new Font("Times Roman", Font.BOLD,15);
	
	public Car(){
		y.setLayout(null);
		y.add(plateno);			
		y.add(car_type); 
		y.add(place);			
		y.add(fees);		
		y.add(duration);		
		y.add(but1);			
		y.add(but2);		
		y.add(plate_no);		
		y.add(fee);				
		y.add(cartype);			
		y.add(place1); 			
		y.add(time) ;
		y.add(ID);
		y.add(ID1);
		y.add(user1);
		y.add(user2);
		y.add(pass);
		y.add(pass1);
		
		ID.setFont(myfont1);
		pass.setFont(myfont1);
		plateno.setFont(myfont1);
		car_type.setFont(myfont1);
		place.setFont(myfont1);
		fees.setFont(myfont1);
		duration.setFont(myfont1);
		
		cartype.addItem("Motorcycle");		
		cartype.addItem("Car");				
		cartype.addItem("Lorry");			
		place1.addItem("Bukit Beruang");	
		place1.addItem("Kota Laksamana");	
		place1.addItem("Ayer Keroh");		
		time.addItem("1");
		time.addItem("2");
		time.addItem("3");
		time.addItem("4");
		time.addItem("5");
		time.addItem("6");
		time.addItem("7");
		time.addItem("8");
		time.addItem("9");
		time.addItem("10");
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		cartype.addActionListener(this);
		place1.addActionListener(this);
		
		ID.setBounds(300,-70,300,300);
		ID1.setBounds(400,70,150,25);
		pass.setBounds(248,-35,300,300);
		pass1.setBounds(400,105,150,25);
		plateno.setBounds(240,0,300,300);
		car_type.setBounds(265,50,300,300);
		place.setBounds(265,100,300,300);
		fees.setBounds(170,150,300,300);
		duration.setBounds(190,200,300,300);
		but1.setBounds(215,410,150,50);
		but2.setBounds(390,410,150,50);
		plate_no.setBounds(400,140,150,25);
		fee.setBounds(400,290,150,25);
		cartype.setBounds(400,190,150,25);
		place1.setBounds(400,238,150,25);
		time.setBounds(400,340,50,25);
		
		frame.setLayout(null);
		setSize(800,600);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane bg = new JLayeredPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Car.class.getResource("4.png"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			}
		};
		bg.setBounds(0,0,780,700);
		this.add(bg,BorderLayout.CENTER);
		
		
		
	}
	
	public void actionPerformed(ActionEvent event){
		String transport = (String) cartype.getSelectedItem();
		String area = (String) place1.getSelectedItem();
							
		if (transport == "Motorcycle" && area == "Bukit Beruang"){
			fee.setText("0.30");
		}else if (transport == "Motorcycle" && area == "Kota Laksamana"){
			fee.setText("0.50");
		}else if (transport == "Motorcycle" && area == "Ayer Keroh"){
			fee.setText("0.40");
		}else if (transport == "Car" && area == "Bukit Beruang"){
			fee.setText("1.00");
		}else if (transport == "Car" && area == "Ayer Keroh"){
			fee.setText("0.70");
		}else if (transport == "Car" && area == "Kota Laksamana"){
			fee.setText("1.50");
		}else if (transport == "Lorry" && area == "Bukit Beruang"){
			fee.setText("0.80");
		}else if (transport == "Lorry" && area == "Kota Laksamana"){
			fee.setText("0.60");
		}else if (transport == "Lorry" && area == "Ayer Keroh"){
			fee.setText("0.90");
		}
		
		if (event.getSource() == but1){
			dispose();
			new Homepage();
		}else if (event.getSource() == but2){
			try{
					BufferedReader lineReader = new BufferedReader(new FileReader("Accounts.txt"));
					String lineText = null;
					while((lineText = lineReader.readLine()) != null){
						String token[] = lineText.split("@") ;
						user1.setText(token[0]);
						user2.setText(token[1]);
							if( (ID1.getText().equals(user1.getText()))  && (pass1.getText().equals(user2.getText())) ){
								
										fileWriter = new FileWriter("information.txt");
										fileWriter.write(user1.getText() + "@" + user2.getText() + "@" +  plate_no.getText() +"@" + fee.getText() + "@" + time.getSelectedItem() + "@" + cartype.getSelectedItem() + "@" + place1.getSelectedItem() );
										fileWriter.close();
							
									dispose() ;	
									new Total();
							}			
					}		
					lineReader.close();				
			}catch(Exception e){ e.printStackTrace();}	
		}
	}
}