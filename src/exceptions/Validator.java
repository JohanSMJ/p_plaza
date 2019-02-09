package exceptions;

import model.TypeProduct;

public class Validator extends Exception{

	
	public boolean validateInventario(Object[] vector) throws Exception {
		 boolean validator=false;
		 
		 if (validateTypeProduct(vector[0])&&validateCantidad(vector[1])) {
			validator=true;
		}
		 return validator;
	}
	
	private boolean validateTypeProduct(Object object) {
		boolean validate= false;
		TypeProduct typeProduct=(TypeProduct)object;
		switch (typeProduct.name()) {
		case "TOMATE":
			validate=true;
			break;
		case "PAPA":
			validate=true;
			break;

		default:
			break;
		}
		
		return validate;
	}
	
	private boolean validateCantidad(Object object) {
		boolean validate=false;
		String aux=""+object;
		if (Integer.parseInt(aux)>=0) {
			validate=true;
		}
		return validate;
	}
}
