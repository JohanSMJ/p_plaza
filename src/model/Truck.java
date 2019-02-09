package model;

import java.util.ArrayList;

public class Truck {

	private String plate;
	private String nameDriver;
	private Inventario truckInventario;
	
	public Truck(String plate,String nameDriver,Inventario inventario) {
	
		this.plate=plate;
		this.nameDriver=nameDriver;
		this.truckInventario=inventario;
		
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getNameDriver() {
		return nameDriver;
	}
	public void setNameDriver(String nameDriver) {
		this.nameDriver = nameDriver;
	}
	public Inventario getTruckInventario() {
		return truckInventario;
	}
	public void setTruckInventario(Inventario truckInventario) {
		this.truckInventario = truckInventario;
	}
	
	public String toString() {

		return "plate: "+this.plate+" name:"+this.nameDriver+" Inventario[ "+this.truckInventario.toStringInventario()+" ]";
	}
	
	
}
