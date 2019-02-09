package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.GrayFilter;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

	public class ViewReport extends JDialog{
		private static final long serialVersionUID=1L;
		private DefaultTableModel dtmElements; //plantilla de la tabla filas cabecera
		private JTable jtElements;
		private JScrollPane jsTable;
		GridSystem gridSystem;
	
		JLabel label0;
		public ViewReport() {
			setLayout(new GridBagLayout());
			gridSystem=new GridSystem(this);
			this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setResizable(false);
			this.setSize(500, 300);
			this.setLocationRelativeTo(null);
			this.setUIManager();
			this.initComponent();
		}
		private void setUIManager() {
			UIManager.put("Label.font",new Font("Bahnschrift", 1, 25));
			UIManager.put("Label.opaque", true);
			UIManager.put("Label.foreground", Color.RED);
		}
		
		
	private void initComponent() {
		
		label0=new JLabel();
		label0.setText("REPORTE ACTUAL");
		label0.setHorizontalAlignment(JLabel.CENTER);
		this.add(label0,gridSystem.insertComponent(1, 1, 10, 1));
		
		dtmElements =new DefaultTableModel();
		String[] headers = {"ID","Name","Unit","Cantidad"};
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
//		jtElements.getColumnModel().getColumn(0).setMaxWidth(60);
//		jtElements.getColumnModel().getColumn(1).setMaxWidth(100);
//		jtElements.getColumnModel().getColumn(2).setMaxWidth(60);
//		jtElements.getColumnModel().getColumn(3).setMaxWidth(60);
		
		jsTable =new JScrollPane(jtElements);
		jsTable.setForeground(Color.BLACK);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		gridSystem.addExternalBorder(0, 0, 10, 0);
		this.add(jsTable,gridSystem.insertComponent(2, 1, 10, 1));
	
	}
	
	public void showMe() {
		this.setVisible(true);
	}
	
	public void hideMe() {
		this.setVisible(false);
	}

}
