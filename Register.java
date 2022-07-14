import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.io.*;
public class Register extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	JLabel title = new JLabel("Registration Form");
	JLabel user_name = new JLabel("Enter user name : ");
	JLabel money = new JLabel ("Enter Amount (RM): ");
	JLabel password = new JLabel("Enter Password : ");
	JLabel password2 = new JLabel("Please re-enter password : ");
	JTextField username = new JTextField(20);
	JTextField money1 = new JTextField(20);
	JPasswordField pass_word = new JPasswordField(20);
	JPasswordField pass_word2 = new JPasswordField(20);
	JButton but1 = new JButton("SIGN UP");
	JButton but2 = new JButton("Back");
	Font myfont1 = new Font("Times Roman", Font.BOLD,30);
	Font myfont2 = new Font("Times Roman", Font.BOLD,15);
	FileWriter fileWriter ;
	public Register(){
		Container x = getContentPane();
		x.setLayout(null);
		x.add(title);
		x.add(user_name);
		x.add(money);
		x.add(password);
		x.add(password2);
		x.add(username);
		x.add(money1);
		x.add(pass_word);
		x.add(pass_word2);
		x.add(but1);
		x.add(but2);
		title.setFont(myfont1);

		title.setBounds(250,-30,500,300);
		user_name.setBounds(245,50,500,300);
		money.setBounds(245,150,500,300);
		password.setBounds(250,250,500,300);
		password2.setBounds(195,350,500,300);

		username.setBounds(400,190,150,25);
		money1.setBounds(400,290,150,25);
		pass_word.setBounds(400,390,150,25);
		pass_word2.setBounds(400,490,150,25);
		
		but1.setBounds(400,550,150,50);
		but2.setBounds(200,550,150,50);
		
		but1.addActionListener(this);
		but2.addActionListener(this);

		setSize(790,700);
		setLocationRelativeTo(null) ;
		setTitle("VPS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane bg = new JLayeredPane(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Register.class.getResource("2.jpg"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
			}
		};
		bg.setBounds(0,0,780,700);
		this.add(bg,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == but1){
			if(pass_word.getText().equals(pass_word2.getText())){
				try{
					fileWriter = new FileWriter("Accounts.txt", true);
					fileWriter.write(username.getText() +"@" + pass_word.getText() + "@" + money1.getText() +"\n");
					fileWriter.close();
				}catch(Exception e){JOptionPane.showMessageDialog(null, e+"");}
				
				JOptionPane.showMessageDialog(frame , "Account Created Successfully!");
				dispose();
				new Homepage();
				
			}else{
				JOptionPane.showMessageDialog(frame , "Invalid Password! Please Re-enter again.");
			}
			
			
		}else if(event.getSource() == but2){
			dispose() ;
			new Homepage();
		}
	}
		
}