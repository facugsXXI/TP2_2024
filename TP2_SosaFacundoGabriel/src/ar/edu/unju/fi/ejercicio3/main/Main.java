package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	static Provincia[] listaProvincias;
	
	public static void main(String[] args) {
		
		listaProvincias = Provincia.values();
		mostrarProvincias();
		
	}

	
	static void mostrarProvincias () {
		for(Provincia provincia : listaProvincias) {
			System.out.println("Provincia: " + provincia 
								+"\n Poblacion: " + provincia.getCantidadPoblacion() + " personas"
								+"\n Superficie: " + provincia.getSuperficie() + "km2"
								+"\n Densidad de Poblacion: " + provincia.calcularDensidadPoblacional() + " personas/km2");
		}
	}
}
