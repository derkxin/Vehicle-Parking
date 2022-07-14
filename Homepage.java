import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Homepage extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	JLabel title= new JLabel("Welcome to Smart Parking OOP!");
	JButton but1= new JButton("SIGN UP");
	JButton but2 = new JButton("PARKING");
	JButton but3 = new JButton("TOP UP");
	JButton but4 = new JButton("QUIT");
	Font myfont = new Font("Times Roman", Font.BOLD,25);
	public Homepage(){
		
		Container x = getContentPane();
		x.setLayout(null);
		x.add(title);
		x.add(but1);
		x.add(but2);
		x.add(but3);
		x.add(but4);

		title.setFont(myfont);
		
		title.setBounds(190,-150,500,500);
		but1.setBounds(300,150,150,50);
		but2.setBounds(300,250,150,50);
		but3.setBounds(300,350,150,50);
		but4.setBounds(300,450,150,50);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		setSize(780,600);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane bg = new JLayeredPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Homepage.class.getResource("1.png"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			}
		};
		bg.setBounds(0,0,760,560);
		this.add(bg,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == but1){
			dispose() ;
			new Register();
		}else if(event.getSource() == but2){
			dispose() ;
			new Car();
		}else if(event.getSource() == but3){
			dispose();
			new Money();
		}else if(event.getSource() == but4){
			System.exit(0);
		}
	}
		
}