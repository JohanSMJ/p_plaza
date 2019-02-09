package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import controller.ControllerApps;
import model.Carga;
import model.Inventario;
import model.Truck;
import utilities.Utilities;

public class IoManager {

	PrincipalWindow principalWindow;
	AddTruckWindow addTruckWindow;
	AddInventarioWindow addInventarioWindow;
	ViewReport viewReportWindow;
	String[] tempAddtruck;
	
	public IoManager(ControllerApps controllerApps) {
	principalWindow=new PrincipalWindow(controllerApps);
	addTruckWindow=new AddTruckWindow(controllerApps,principalWindow);
	addInventarioWindow =new AddInventarioWindow(controllerApps);
	viewReportWindow=new ViewReport();
	}
	
	
	
	public String[] getTempAddtruck() {
		this.setTempAddtruck();
		return tempAddtruck;
	}



	public void setTempAddtruck() {
		
		this.tempAddtruck = addTruckWindow.getTextComponets();
	}



	public void showAddTruckWindow() {
		addTruckWindow.showMe();
	}
	
	public Inventario finishInventarioWindow() {
		ArrayList<Carga>cargas= addInventarioWindow.finishWindow();
		addInventarioWindow.hideMe();
		return new Inventario(cargas);
	}
	
	public void showAddInventarioWindow() {
		if(addTruckWindow.validateText()) {
			tempAddtruck= addTruckWindow.getTextComponets();
			addInventarioWindow.showMe();
			addTruckWindow.hideMe();
		}else {
			addTruckWindow.cleanWindow();
			JOptionPane.showMessageDialog(null, "INGRESE UN NOMBRE Y UNA PLACA");
		}
	}
	
	public void showViewReportWindow() {
		viewReportWindow.showMe();
	}
	
	public void cancelWindow() {
       addInventarioWindow.cleanTable();
       addInventarioWindow.hideMe();
	}
	 public void cargaTable() {
     addInventarioWindow.addCarga();
	}
	
}
