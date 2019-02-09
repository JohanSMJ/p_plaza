package utilities;

import java.util.ArrayList;

import model.Carga;
import model.Inventario;
import model.Truck;
import model.TypeProduct;

public class Utilities {

	public static Inventario objectMatrizToInventario(Object[][] matriz) {
		ArrayList<Carga>aux=new ArrayList<>();
		for (int i = 0; i < matriz.length; i++) {
			aux.add(objectToCarga(matriz[i]));
		}
		
		return new Inventario(aux);
	}
	
	public static Inventario createInventario(ArrayList<Carga> cargas) {
		return new Inventario(cargas);
	}
	
	@SuppressWarnings("null")
	public static Object[][] arrayTrucksToObjectTable(ArrayList<Truck> vector) {
		Object[][] matriz=null;
		for (int i = 0; i < vector.size(); i++) {
			matriz[i]= truckToObjectVectorTable(vector.get(i));
		}
		return matriz;
		
	}
	
	public static Object[] truckToObjectVectorTable(Truck truck) {
		Object[] vector= {truck.getPlate(),truck.getNameDriver()};
		return vector;
	}
	
	public static ArrayList<Carga> objectToCargaArray(Object[][]matriz) {
		ArrayList<Carga>temp= new ArrayList<>();
		
		for (int i = 0; i < matriz.length; i++) {
			temp.add(objectToCarga(matriz[i]));
			
		}
		
		return temp;
		
	}
	
	public static Carga objectToCarga(Object[] vector) {
		
		return new Carga(TypeProduct.valueOf(vector[1].toString()),Integer.parseInt(vector[3].toString()));
		
	}
}
