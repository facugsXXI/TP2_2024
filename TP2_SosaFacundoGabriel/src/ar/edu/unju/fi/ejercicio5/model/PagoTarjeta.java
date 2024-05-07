package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPago;
	
	public PagoTarjeta() {
		this.fechaPago = LocalDate.now();
		
	}

	

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	public Double getMontoPago() {
		return montoPago;
	}



	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}



	@Override
	public void realizarPago(double monto) {
		this.montoPago = this.montoPago + (this.montoPago * 0.15d);
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nNumero de tarjeta: "+this.numeroTarjeta
				+ "\nFecha de pago: "+this.fechaPago.format(FORMATTER)
				+ "\nMonto pagado: "+this.montoPago);
	}
}
