package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Double montoPago;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		this.fechaPago = LocalDate.now();
		this.montoPago = 0d;
	}

	

	public Double getMontoPago() {
		return montoPago;
	}



	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}



	public LocalDate getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}



	@Override
	public void realizarPago(double monto) {
		this.montoPago = this.montoPago - (this.montoPago * 0.10);
		
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nFecha de Pago: "+this.fechaPago.format(FORMATTER)
				+ "\nMonto pagado: "+this.montoPago);
		
	}
}
