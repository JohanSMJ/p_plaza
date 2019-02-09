package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Inventario;
import model.ModelManager;
import view.IoManager;

public class ControllerApps implements ActionListener{

	IoManager ioManagerObj;
	ModelManager modelManagerObj;
	
	public ControllerApps() {
		ioManagerObj=new IoManager(this);
		modelManagerObj=new ModelManager();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case ADD_TRUCK_SHOW:
			this.showAddTruckWindows();
			break;
		case ADD_INVENTARIO_SHOW:
			this.showAddInventarioWindow();
			break;
		case VIEW_REPORT_ACTUAL:
			this.showViewReportWindows();
			break;
		case CANCEL_CARGA:
			this.cancelWindow();
			break;
		case ADD_CARGA_TABLE:
			this.cargaTable();
			break;
		case ADD_TRUCK:
			this.AddTruck();
			break;
			
		default:
			break;
		}
		
	}

	public void AddTruck() {
		String[] temp=ioManagerObj.getTempAddtruck();
		Inventario inventario=ioManagerObj.finishInventarioWindow();
		
		modelManagerObj.getSuperMarketObj().addTruck(temp[0], temp[1], inventario);
		System.out.println(""+modelManagerObj.getSuperMarketObj().getTrucks().get(0).getTruckInventario().getCargas().get(0).toStringCarga());
	}
	
	public void showAddInventarioWindow() {
		ioManagerObj.showAddInventarioWindow();
	}
	public void showAddTruckWindows() {
		ioManagerObj.showAddTruckWindow();
	}
	public void showViewReportWindows() {
		ioManagerObj.showViewReportWindow();
	
	}
	public void cargaTable() {
    ioManagerObj.cargaTable();
	}
	
    public void cancelWindow() {
    ioManagerObj.cancelWindow();
	}
	
}
