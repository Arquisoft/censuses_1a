package es.uniovi.asw.logica;

public class User {
	
	private String name;
	private String NIF;
	private String email;
	private String codigoMesa;
	

	public User(String name,String NIF,String email,String codigoMesa){
		this.setName(name);
		this.setNIF(NIF);
		this.email = email;
		this.setCodigoMesa(codigoMesa);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoMesa() {
		return codigoMesa;
	}


	public void setCodigoMesa(String codigoMesa) {
		this.codigoMesa = codigoMesa;
	}
	
	
	

}
