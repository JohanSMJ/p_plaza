package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;

public class AddTruckWindow extends JDialog {

	JTextField text0,text1;
	JButton button0;
	JLabel label0;
	GridSystem gridSystem;
	public AddTruckWindow(ControllerApps controllerApps,Component c) {
		setLayout(new GridBagLayout());
		gridSystem=new GridSystem(this);
		this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		//this.setLocationRelativeTo(c);
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setUIManager();
		this.initComponents();
		this.setCommands(controllerApps);
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
	
	
	public void cleanWindow() {
		text0.setText("");
		text1.setText("");
	}
	
	private void setCommands(ControllerApps controllerApps) {
		button0.addActionListener(controllerApps);
		button0.setActionCommand(Commands.ADD_INVENTARIO_SHOW.name());
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	
	private void setUIManager() {
		UIManager.put("Label.font",new Font("Bahnschrift", 1, 18));
		UIManager.put("Label.opaque", true);
		UIManager.put("Label.foreground", Color.RED);
		UIManager.put("Button.opaque", true);
		UIManager.put("Button.font",new Font("Bahnschrift", 1, 22));
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.WHITE);
	}
	
	private void initComponents() {
		gridSystem.addExternalBorder(10, 0, 0, 0);
		
		label0=new JLabel();
		label0.setText("AGREGAR CAMION");
		label0.setHorizontalAlignment(JLabel.CENTER);
		this.add(label0,gridSystem.insertComponent(1, 1, 10, 1));
		
		text0=new JTextField();
		text0.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"PLATE"));
		this.add(text0,gridSystem.insertComponent(2, 1, 10, 1));
		
		text1=new JTextField();
		text1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"NAME DRIVER"));
		this.add(text1,gridSystem.insertComponent(3, 1, 10, 1));
		
		button0 =new JButton("AGREGAR INVENTARIO");
		gridSystem.addExternalBorder(10, 0, 10, 0);
		this.add(button0,gridSystem.insertComponent(4, 4, 5, 1));

		
	}
	
	public boolean validateText() {
		boolean temp=true;
		if (text0.getText().equals("")&&text1.getText().equals("")) {
			temp=false;
		}
		return temp;
	}
	
	public String[] getTextComponets() {
		String [] temp= {text0.getText(),text1.getText()};
		return temp;
	}
	
}
