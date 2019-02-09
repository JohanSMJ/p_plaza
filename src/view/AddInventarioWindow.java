package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.Commands;
import controller.ControllerApps;
import model.Carga;
import model.ModelManager;
import model.Truck;
import model.TypeProduct;
import utilities.Utilities;

public class AddInventarioWindow extends JDialog {

	JTextField text0;
	JButton button0,button1,button2;
	JLabel label0;
	JPanel panel0,panel1,panel2;
	JComboBox<String> typeProduct ;
	GridSystem gridSystem,gridSystem0,gridSystem1;
	private static final long serialVersionUID=1L;
	private DefaultTableModel dtmElements; //plantilla de la tabla filas cabecera
	private JTable jtElements;
	private JScrollPane jsTable;
	private ArrayList<Carga> listaInventario =new ArrayList<>();
	public AddInventarioWindow(ControllerApps controllerApps) {
		setLayout(new GridBagLayout());
		gridSystem=new GridSystem(this);
		this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setResizable(false);
		//this.setLocationRelativeTo(c);
		 this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setUIManager();
		this.initComponent(controllerApps);
		this.setCommands(controllerApps);
		
	}
	
	private void setCommands(ControllerApps controllerApps) {
		button0.setActionCommand(Commands.ADD_CARGA_TABLE.name());
		button0.addActionListener(controllerApps);
		
		button1.setActionCommand(Commands.CANCEL_CARGA.name());
		button1.addActionListener(controllerApps);
		
		button2.setActionCommand(Commands.ADD_TRUCK.name());
		button2.addActionListener(controllerApps);
	}
	public void showMe() {
		this.setVisible(true);
	}
	
	public void hideMe() {
		this.setVisible(false);
	}
	private void setUIManager() {
		UIManager.put("Label.font",new Font("Bahnschrift", 1, 18));
		UIManager.put("Label.opaque", true);
		UIManager.put("Label.foreground", Color.RED);
		UIManager.put("Button.opaque", true);
		UIManager.put("Button.font",new Font("Bahnschrift", 1, 12));
		UIManager.put("Button.background", Color.BLACK);
		UIManager.put("Button.foreground", Color.WHITE);
	}
	
	private void initComponent(ControllerApps controllerApps) {
		panel0=new JPanel();
		gridSystem0=new GridSystem(panel0);
		panel0.setPreferredSize(new Dimension(250,200));
		panel0.setLayout(new GridBagLayout());
		gridSystem0.addExternalBorder(10, 10, 0, 10);
		
		label0=new JLabel();
		label0.setText("AGREGAR INVENTARIO");
		label0.setHorizontalAlignment(JLabel.CENTER);
		gridSystem0.addExternalBorder(15, 50, 15, 50);
		panel0.add(label0,gridSystem0.insertComponent(1, 1, 10, 1));
		
	    typeProduct=new JComboBox<>();
	    typeProduct.setModel(new DefaultComboBoxModel(TypeProduct.values()));
        panel0.add(typeProduct,gridSystem0.insertComponent(2, 1, 10, 1));
        
        text0=new JTextField();
        text0.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"CANTIDAD"));
		panel0.add(text0,gridSystem0.insertComponent(3, 1, 10, 1));
		
		panel2=new JPanel();
		panel2.setLayout(new GridBagLayout());
		gridSystem1=new GridSystem(panel2);
		
		button0 =new JButton("ACEPTAR");
		gridSystem1.addExternalBorder(10, 5, 10, 5);
		panel2.add(button0,gridSystem1.insertComponent(0, 0, 3, 1));
		
		button1 =new JButton("CANCELAR");
		panel2.add(button1,gridSystem1.insertComponent(0, 4, 3, 1));
		
		button2 =new JButton("FINALIZAR");
	    panel2.add(button2,gridSystem1.insertComponent(0, 8, 3, 1));
		panel0.add(panel2,gridSystem0.insertComponent(4, 1, 5, 1));
		this.add(panel0,gridSystem.insertComponent(1, 1, 5, 1));
		
		
		panel1=new JPanel();
		//panel1.setPreferredSize(new Dimension(220,200));
		panel1.setLayout(new BorderLayout());
		dtmElements =new DefaultTableModel();
		String[] headers = {"ID","Type product","Unit","Cantidad"};
		dtmElements.setColumnIdentifiers(headers);
		
		Font fontHeader=new Font ("Franklin Gothic Demi",Font.ITALIC,12);
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setReorderingAllowed(false);//reordenar cabecera
		jtElements.getTableHeader().setBackground(Color.BLACK);
		jtElements.getTableHeader().setForeground(Color.WHITE);
		jtElements.setFont(fontHeader);
		jtElements.setBackground(Color.RED);
		jtElements.setFillsViewportHeight(true);
		jtElements.getColumnModel().getColumn(0).setMaxWidth(200);
		jtElements.getColumnModel().getColumn(1).setMaxWidth(100);
		jtElements.getColumnModel().getColumn(2).setMaxWidth(60);
		//jtElements.getColumnModel().getColumn(3).setMaxWidth(80);
//        jtElements.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//jtElements.setBorder(null);
		
		jsTable =new JScrollPane(jtElements);
		jsTable.setForeground(Color.BLACK);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		gridSystem1.addExternalBorder(10, 0,30, 50);
		panel1.add(jsTable,BorderLayout.CENTER);
			
		this.add(panel1,gridSystem1.insertComponent(1, 6, 5, 1));
	}
	
//	public Carga createInventario(){
//		return modelManager.createInventario((TypeProduct)typeProduct.getSelectedItem(),Integer.parseInt(text0.getText()));
//	    }
	

	public ArrayList<Carga> finishWindow() {
		ArrayList<Carga> temp=this.listaInventario;
		text0.setText("");
		this.cleanTable();
		this.listaInventario=null;
		return temp;
		
	}
	
	public void addCarga() {
		TypeProduct type= (TypeProduct) typeProduct.getSelectedItem();
		int num= Integer.parseInt(text0.getText());
		Carga c=new Carga(type, num);
		System.out.println("carga ingresada \n"+c.toStringCarga()+"\n");
		this.listaInventario.add(c);
		Object[] vector= {type.getId(),type.name(),type.getUnity(),num};
		addElementsToTable(vector);
		text0.setText("");
	}
	

	public void addElementsToTable(Object[] vector) {
		dtmElements.addRow(vector);
	}
	
	public void cleanTable() {
		dtmElements.setRowCount(0);
		listaInventario.clear();
	}
	
//	public void addCargaToTable() {
//		Object[][]matriz=Utilities.arrayInventarioToObjectMatriz(listaInventario);
//		for (int i = 0; i <matriz.length; i++) {
//			dtmElements.addRow(matriz[i]);
//		}
//	}
	
}