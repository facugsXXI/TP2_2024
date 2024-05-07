package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	static List<Producto> listaProductos = new ArrayList<>();
	
	static List<Producto> listaChanguito = new ArrayList<>();
	
	public static void main(String[] args) {
		crearProductos();
		menu();
	}
	
	static void menu() {
		
		boolean sessionOpen = true;
		do {
			System.out.println("\n**MENU**"
					+ "\n 1 - Mostrar Productos"
					+ "\n 2 - Realizar Compra"
					+ "\n 3 - Salir");
			int option = validarEntero();
			switch (option) {
				case 1:{
					mostrarProductos();
					break;
				}
				case 2:{
					comprarProductos();
					break;
				}
				case 3:{
					System.out.println("\nSesion terminada...");
					sessionOpen = false;
					break;
				}
				default:
					break;
			}
			
			
		} while (sessionOpen);
		
	}
	
	static int validarEntero() {
		do {
			
			try {
				int valor = Integer.parseInt(scanner.next());
				return valor;
			} catch (Exception e) {
				System.out.println("\nIngrese un valor entero valido");
			}
			
		} while (true);
		
	}
	
	static void pagoTarjetaCredito(Double monto) {
		
		PagoTarjeta pagoTarjeta = new PagoTarjeta();
		System.out.println("\nIngrese numero de tarjeta");
		pagoTarjeta.setNumeroTarjeta(scanner.nextLine());
		pagoTarjeta.setMontoPago(monto);
		pagoTarjeta.realizarPago(monto);
		pagoTarjeta.imprimirRecibo();
	}
	
	static void pagoEfectivo(Double monto) {
		PagoEfectivo pagoEfectivo = new PagoEfectivo();
		pagoEfectivo.setMontoPago(monto);
		pagoEfectivo.realizarPago(monto);
		pagoEfectivo.imprimirRecibo();
	}
	
	
	static void mostrarProductos() {
		System.out.println("\n**PRODUCTOS**");
		listaProductos.forEach(product -> System.out.println(product));
	}
	
	static void comprarProductos() {
		boolean seguirComprando = true;
		do {
			System.out.println("\n**ELEGIR PRODUCTOS**");
			listaProductos.forEach(producto -> System.out.println("Codigo: " + producto.getCodigo() + ", Producto: " + producto.getDescripcion() + ", HAY STOCK?: " + (producto.isDisponibilidad() ? "SI" : "NO")));					
			System.out.println("\n\n Seleccione el codigo del producto que desea comprar");
			int codigoCompra = validarEntero();
			for (Producto producto : listaProductos) {
				if(producto.getCodigo() == codigoCompra && producto.isDisponibilidad()) {
					producto.setDisponibilidad(false);
					listaChanguito.add(producto);
				}
			}
			System.out.println("\nTerminar Compra? (S/n)");
			String answer = scanner.next().toUpperCase();
			if(answer.equals("S"))
				seguirComprando = false;
			
		} while (seguirComprando);
		
		payoutMenu();
		
	}
	
	static void payoutMenu() {
		boolean elegirMetodoPago = true;
		do {
			System.out.println("\n\n**CARRITO DE COMPRA**");
			listaChanguito.forEach(producto -> System.out.println(producto.getDescripcion() + " precio: "+producto.getPrecioUnitario()));
			double total = 0d;
			for (Producto producto : listaChanguito) {
				total+=producto.getPrecioUnitario();
			}
			System.out.println("\nTOTAL: "+ total);
			System.out.println("\n*Elegir metodo de pago*"
					+ "\n1 - Pago Efectivo"
					+ "\n2 - Pago con Tarjeta");
			int option = validarEntero();
			switch (option) {
				case 1:{
					pagoEfectivo(total);
					elegirMetodoPago = false;
					break;
				}
				case 2:{
					pagoTarjetaCredito(total);
					elegirMetodoPago = false;
				}
				default:
					break;
			}
			
			
		} while (elegirMetodoPago);
		
		listaChanguito.clear();
		
	}
	
	
	static void crearProductos() {
		 	listaProductos.add(new Producto(1, "Teléfono móvil inteligente", 599.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
		 	listaProductos.add(new Producto(2, "Portátil ultradelgado", 999.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
		 	listaProductos.add(new Producto(3, "Aspiradora robotizada", 349.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
		 	listaProductos.add(new Producto(4, "Taladro percutor inalámbrico", 129.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
		 	listaProductos.add(new Producto(5, "Auriculares inalámbricos con cancelación de ruido", 149.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
		 	listaProductos.add(new Producto(6, "Procesador de alimentos multifunción", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
		 	listaProductos.add(new Producto(7, "Cámara de seguridad inteligente para el hogar", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
		 	listaProductos.add(new Producto(8, "Impresora láser a color", 299.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
		 	listaProductos.add(new Producto(9, "Plancha de vapor de alta potencia", 49.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
		 	listaProductos.add(new Producto(10, "Mochila para portátil resistente al agua", 39.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
		 	listaProductos.add(new Producto(11, "Monitor de computadora de alta definición", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	}
	

}