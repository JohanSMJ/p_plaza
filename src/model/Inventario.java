package model;

import java.util.ArrayList;

public class Inventario {
	private ArrayList<Carga> cargas;
	
	public Inventario(ArrayList<Carga> cargas) {
	this.cargas=cargas;
	}

	public ArrayList<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(ArrayList<Carga> cargas) {
		this.cargas = cargas;
	}
	
	public String toStringInventario() {
		String out="";
		
		for (Carga carga : cargas) {
			out+=carga.toStringCarga();
		}
		
		return out;
	}
	
	
}
