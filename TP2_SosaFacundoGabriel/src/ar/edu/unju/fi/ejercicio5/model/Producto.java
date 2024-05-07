package ar.edu.unju.fi.ejercicio5.model;

public class Producto {

	private Integer codigo;
	private String descripcion;
	private Double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	private boolean disponibilidad;
	
	public enum OrigenFabricacion {
		ARGENTINA,
		CHINA,
		BRASIL,
		URUGUAY
	}
	
	public enum Categoria {
		TELEFONIA,
		INFORMATICA,
		ELECTROHOGAR,
		HERRAMIENTAS
	}
	
	public Producto() {}
	
	
	
	
	public Producto(Integer codigo, String descripcion, Double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria, boolean disponibilidad) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.disponibilidad = disponibilidad;
	}


	public Integer getCodigo() {
		return codigo;
	}




	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Double getPrecioUnitario() {
		return precioUnitario;
	}




	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}




	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}




	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}




	public Categoria getCategoria() {
		return categoria;
	}




	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	public boolean isDisponibilidad() {
		return disponibilidad;
	}




	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}




	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + ", disponibilidad="
				+ disponibilidad + "]";
	}



}
