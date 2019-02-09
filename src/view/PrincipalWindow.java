package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import controller.Commands;
import controller.ControllerApps;

public class PrincipalWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	JToolBar toolBar;
	JMenu menu0,menu1;
	JMenuBar menuBar0;
	JLabel label0;
	JButton button0,button1;
	JMenuItem item0,item1;
	
	public PrincipalWindow(ControllerApps controllerApps) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(650, 700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("TRUCKS");
		this.setLayout(new BorderLayout());
		this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		
		this.setUIManager();
		this.inItComponents();
		this.setCommands(controllerApps);
		this.setVisible(true);
	}
	
	private void setUIManager() {
		UIManager.put("MenuBar.background", Color.decode("#EB0F00"));
		UIManager.put("Menu.background",  Color.decode("#EB0F00"));
		UIManager.put("Menu.foreground",  Color.decode("#ffffff"));
		UIManager.put("Menu.font", new Font("Bahnschrift", 1, 16));
		
		UIManager.put("MenuItem.background",  Color.decode("#EB0F00"));
		UIManager.put("MenuItem.foreground",  Color.decode("#ffffff"));
		UIManager.put("MenuItem.font", new Font("Bahnschrift", 1, 16));
		UIManager.put("ToolBar.background", Color.BLACK);
		UIManager.put("ToolBar.foreground", Color.WHITE);
	}
	
	private void inItComponents() {
		toolBar=new JToolBar();
		this.createToolBar();
		menuBar0=new JMenuBar();
		menuBar0.setBorderPainted(false);
		this.InItItemsMenu();
		this.setJMenuBar(menuBar0);
		
		
		label0=new JLabel();
		label0.setOpaque(false);
		label0.setIcon(new ImageIcon(getClass().getResource("/imgs/fondo.jpg")));
		this.add(label0,BorderLayout.CENTER);
		
	}
	
	
	private void InItItemsMenu() {
		menu0=new JMenu("NUEVO");
		this.createItemsNew();
		menuBar0.add(menu0);
		
		menu1=new JMenu("REPORTE");
		this.createItemsReport();
		menuBar0.add(menu1);
		
	}
	
	private void createItemsReport() {
		item1=new JMenuItem("ACTUAL");
		menu1.add(item1);
	}
	
	private void createItemsNew() {
		item0=new JMenuItem("AGREGAR CAMION");
		menu0.add(item0);
	}
	
	private void createToolBar() {
		button0=new JButton();
		button0.setBorder(null);
		button0.setContentAreaFilled(false);
		button0.setText("NUEVO");
		toolBar.add(button0);
		toolBar.setFloatable(false);
		toolBar.addSeparator();
		toolBar.setOpaque(true);
		button1=new JButton();
		button1.setBorder(null);
		button1.setContentAreaFilled(false);
		button1.setText("REPORTE");
		toolBar.add(button1);
		this.add(toolBar,BorderLayout.NORTH);
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
	private void setCommands(ControllerApps controllerApps) {
		item0.setActionCommand(Commands.ADD_TRUCK_SHOW.name());
		item0.addActionListener(controllerApps);
		item1.setActionCommand(Commands.VIEW_REPORT_ACTUAL.name());
		item1.addActionListener(controllerApps);
		button0.setActionCommand(Commands.ADD_TRUCK_SHOW.name());
		button0.addActionListener(controllerApps);
		button1.setActionCommand(Commands.VIEW_REPORT_ACTUAL.name());
		button1.addActionListener(controllerApps);
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	
}
