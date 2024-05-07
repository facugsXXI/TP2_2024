package ar.edu.unju.fi.ejercicio7.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio7.utils.ProductosArrayList;

public class Main {

	static List<Producto> productos = ProductosArrayList.productsArray();
	
	static List<Producto> productosIncrementados;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		boolean sessionOpen = true;
		do {
			System.out.println("\n**MENU**"
					+ "\n1 – Mostrar productos "
					+ "\n2 – Mostrar los productos faltantes"
					+ "\n3 – Incrementar los precios de los productos en un 20%"
					+ "\n4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta"
					+ "\n5 – Ordenar los productos por precio de forma descendente."
					+ "\n6 - Mostrar los productos con los nombres en mayúsculas. "
					+ "\n7 Salir...");
			int option = validarEntero();
			switch (option) {
				case 1:{
					mostrarProductos();
					break;
				}
				case 2:{
					mostrarProductosFaltantes();
					break;
				}	
				case 3:{
					incrementarPorcentajeProducto();
					break;
				}	
				case 4:{
					mostrarElectroHogar();
					break;
				}
				case 5:{
					ordenarPorPrecio();
					break;
				}
				case 6:{
					mostrarProcutosMayusculas();
					break;
				}
				case 7:{
					sessionOpen = false;
					System.out.println("sesion terminada...");
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
	
	static void mostrarProductos() {
		
		Consumer<Producto> consumerProductos = (producto) -> {
			if (producto.isDisponibilidad()) {
            System.out.println(producto.toString());
			}
		};
		productos.forEach(consumerProductos);
	}

	static void mostrarProductosFaltantes() {
		
		Predicate<Producto> predicateProductos = (producto) -> producto.isDisponibilidad()==false;
			productos.stream()
			.filter(predicateProductos)
			.collect(Collectors.toList())
			.forEach(producto -> System.out.println(producto));
	}
	
	
	static void incrementarPorcentajeProducto() {
	
		Function<Producto, Producto> incrementoPorcentual = (producto) -> {
			producto.setPrecioUnitario(producto.getPrecioUnitario()+(producto.getPrecioUnitario()*0.20d));
			return producto;
		};
		productosIncrementados = productos.stream()
				.map(incrementoPorcentual)
				.collect(Collectors.toList());
		
		productosIncrementados.forEach(producto -> System.out.println(producto));
	}
	
	static void mostrarElectroHogar() {
		
		Predicate<Producto> electroHogarVenta = (producto) -> {
			if(producto.getCategoria().equals(Categoria.ELECTROHOGAR) && producto.isDisponibilidad())
				return true;
			return false;
		};
		productos.stream()
		.filter(electroHogarVenta)
		.collect(Collectors.toList())
		.forEach(producto -> System.out.println(producto));
		
	}
	
	static void ordenarPorPrecio() {
		Collections.sort(productos, Comparator.comparing(Producto::getPrecioUnitario).reversed());
		productos.forEach(producto -> System.out.println(producto));
	}
	
	static void mostrarProcutosMayusculas() {
		Function<Producto,Producto> upperCaseProductos = (producto) -> {
			producto.setDescripcion(producto.getDescripcion().toUpperCase());
			return producto;
		};
		
		(productos.stream()
				.map(upperCaseProductos)
				.collect(Collectors.toList()))
				.forEach(producto -> System.out.println(producto));
	}
	
}