package com.ecodeup.articulos.model;


public class Articulo {
	private int id;
	private String origen;
	private String destino;
	private String paquete;
	private String fechallegada;
	private String remitente;
	private String transportista;
	private double precio;
	

	public Articulo(int id, String origen, String destino, String paquete, String fechallegada, String remitente,
			String transportista, double precio) {
		super();
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.paquete = paquete;
		this.fechallegada = fechallegada;
		this.remitente = remitente;
		this.transportista = transportista;
		this.precio = precio;
	}
	
	

	//getters y setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getPaquete() {
		return paquete;
	}


	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}


	public String getFechallegada() {
		return fechallegada;
	}


	public void setFechallegada(String fechallegada) {
		this.fechallegada = fechallegada;
	}


	public String getRemitente() {
		return remitente;
	}


	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}


	public String getTransportista() {
		return transportista;
	}


	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}




	
}