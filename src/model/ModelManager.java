package model;

import java.util.ArrayList;

public class ModelManager {
	private ArrayList<Register>registers;
	SuperMarket superMarketObj;
	
	public ModelManager() {
		superMarketObj=new SuperMarket();
	}
	
	public ArrayList<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(ArrayList<Register> registers) {
		this.registers = registers;
	}
	public SuperMarket getSuperMarketObj() {
		return superMarketObj;
	}
	public void setSuperMarketObj(SuperMarket superMarketObj) {
		this.superMarketObj = superMarketObj;
	}
	
	public void name(String plate, String nameDriver, Inventario inventario) {
		superMarketObj.addTruck(plate, nameDriver, inventario);
	}
	
}
