package model;

public class Carga {
	private TypeProduct typeProduct;
	private int cantidad;
	
	public Carga(TypeProduct typeProduct,int cantidad) {

		this.typeProduct=typeProduct;
		this.cantidad=cantidad;
		
	}
	

	
	
	public TypeProduct getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String toStringCarga() {
		// TODO Auto-generated method stub
		return "Product: "+this.typeProduct.name()+" Unity:"+this.typeProduct.getUnity()+" # "+this.cantidad;
	}
	
}
