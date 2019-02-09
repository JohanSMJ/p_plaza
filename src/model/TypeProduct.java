package model;

public enum TypeProduct {
	
	TOMATE("CAJAS",0),PAPA("BULTO",1);

	

	private String unity;
	private int id;
	
	TypeProduct(String unity, int id) {
		this.unity=unity;
		this.id=id;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
