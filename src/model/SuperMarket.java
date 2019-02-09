package model;

import java.util.ArrayList;

public class SuperMarket {

	private ArrayList<Truck>trucks;
	
	public SuperMarket() {

	trucks=new ArrayList<>();
	}

	public ArrayList<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(ArrayList<Truck> trucks) {
		this.trucks = trucks;
	}
	
	public void addTruck(String plate, String nameDriver,Inventario inventario) {
		Truck truck= new Truck(plate, nameDriver, inventario);
		trucks.add(truck);
	}
	
	
	
	public Object[][] getInventarioTotal() {
		@SuppressWarnings("unused")
		int auxPapa=-1;
		@SuppressWarnings("unused")
		int auxTomate=-1;
		if (this.trucks.size()>0) {
			auxPapa=0;
			auxTomate=0;
			for (int i = 0; i < this.trucks.size(); i++) {
				for (int j = 0; j < this.trucks.get(i).getTruckInventario().getCargas().size(); j++) {
					switch (TypeProduct.valueOf(this.trucks.get(i).getTruckInventario().getCargas().get(j).getTypeProduct().name())) {
					case PAPA:
						auxPapa+=this.trucks.get(i).getTruckInventario().getCargas().get(j).getCantidad();
						break;
					case TOMATE:
						auxTomate+=this.trucks.get(i).getTruckInventario().getCargas().get(j).getCantidad();
						break;

					default:
						break;
					}
				}
			}
			
			
		}
		Object [][]matriz= {{TypeProduct.TOMATE.getId(),TypeProduct.TOMATE.name(),TypeProduct.TOMATE.getUnity(),auxTomate},{TypeProduct.PAPA.getId(),TypeProduct.PAPA.name(),TypeProduct.PAPA.getUnity(),auxPapa}};
		
		return matriz;
	}
	
	public String toString() {
		String message="__________________________________\n";
		for (Truck truck : trucks) {
			message+=truck.toString()+"\n";
		}
		return message;
	}
	
	
}

