import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader ;
import java.io.BufferedReader;


public class Invoice extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JLabel titles = new JLabel("SMART PARKING OOP");
	JLabel Reference = new JLabel("Reference No. : ");
	JLabel carplate = new JLabel("Car Plate No. : ");
	JLabel duration = new JLabel("Duration (hours) : ");
	JLabel location = new JLabel("Location : ");
	JLabel cartype = new JLabel("Vehicle Type : ");
	JLabel parkingtype = new JLabel("Parking Type : ");
	JLabel totalfee = new JLabel("Total fee (RM) : ");
	JLabel total_fee = new JLabel();
	JLabel referenceno = new JLabel();
	JLabel carno = new JLabel();
	JLabel time= new JLabel();
	JLabel place = new JLabel();
	JLabel vehicle= new JLabel();
	JLabel parking = new JLabel();
	JButton but1 = new JButton("Print Invoice");
	JButton but2 = new JButton("Exit");
	BufferedReader reader ;
	FileReader	fileReader ;

	Font myfont = new Font("Times Roman", Font.BOLD,25);

	public Invoice(){

		Container x = getContentPane();
		x.setLayout(null);
		x.add(titles);
		x.add(Reference);
		x.add(carplate);
		x.add(duration);
		x.add(location);
		x.add(cartype);
		x.add(totalfee);
		x.add(total_fee);
		x.add(parkingtype);
		x.add(referenceno);
		x.add(carno);
		x.add(time);
		x.add(place);
		x.add(vehicle);
		x.add(parking);
		x.add(but1);
		x.add(but2);

		titles.setFont(myfont);
		titles.setBounds(150,-100,300,300);
		Reference.setBounds(160,-50,300,300);
		carplate.setBounds(167,0,300,300);
		duration.setBounds(150,50,300,300);
		location.setBounds(190,100,300,300);
		cartype.setBounds(163,150,300,300);
		parkingtype.setBounds(160,200,300,300);
		totalfee.setBounds(160,250,300,300);
		
		referenceno.setBounds(320,90,150,25);
		carno.setBounds(320,140,150,25);
		time.setBounds(320,190,150,25);
		place.setBounds(320,240,150,25);
		vehicle.setBounds(320,290,150,25);
		parking.setBounds(320,340,150,25);
		total_fee.setBounds(320,390,150,25);
		
		but1.setBounds(100,420,150,50);
		but2.setBounds(290,420,150,50);
		but1.addActionListener(this);
		but2.addActionListener(this);
		frame.setLayout(null);
		setSize(550,550);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane bg = new JLayeredPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Invoice.class.getResource("6.png"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			}
		};
		bg.setBounds(0,0,550,500);
		this.add(bg,BorderLayout.CENTER);
		
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == but1){
			long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			String key = Long.toString(number);
			referenceno.setText(key);
			parking.setText("On Street");
			try{
				BufferedReader lineReader = new BufferedReader(new FileReader("information.txt"));
				String lineText = null;
				while((lineText = lineReader.readLine()) != null){
					String token[] = lineText.split("@") ;
					carno.setText(token[0]) ;
					total_fee.setText(token[1]);
					time.setText(token[2]) ;
					place.setText(token[4]) ;
					vehicle.setText(token[3]) ;
				}
				lineReader.close();
			}catch(Exception e){ e.printStackTrace();}		
			
		}else if (event.getSource() == but2){
			System.exit(0);
		}
	}
}