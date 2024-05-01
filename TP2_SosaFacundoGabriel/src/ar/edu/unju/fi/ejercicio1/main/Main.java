package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	
	static ArrayList <Producto> productos = new ArrayList<Producto>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
		
	}
	
	static void menu() {
		
		boolean seguir = true;
		do {
			System.out.println("\n Seleccione una opcion: " 
														+ "\n 1 - Crear Producto"
														+ "\n 2 - Mostrar Productos"
														+ "\n 3 - Modificar Producto"
														+ "\n 4 - Salir");
			int op = validarEntero();
			switch(op) {
			case 1: crearProducto();
				break;
			case 2: mostrarProductos();
				break;
			case 3: modificarProducto();
				break;
			case 4: System.out.println(" PROCESO TERMINADO");
					seguir = false;
				break;
			default: System.out.println("!!!ERROR DESCONOCIDO!!!");
				break;
					
			}
		}while(seguir);
	}
	
	static int validarEntero () {
		do {
			try {
				int entero = Integer.parseInt(scanner.nextLine());
				return entero;
			} catch (Exception e) {
				System.out.println("Debe ingresar un valor valido");
			}
		}while (true);
	}
	
	static double validarDouble () {
		do {
			try {
				double doble = Double.parseDouble(scanner.nextLine());
				return doble;
			} catch (Exception e) {
				System.out.println("Debe ingresar un valor valido");
			}
		}while (true);
	}
	
	static void crearProducto () {
		
		Producto nuevoProducto = new Producto();
		System.out.println("Ingresar el codigo del producto");
		nuevoProducto.setCodigo(scanner.nextLine());
		System.out.println("Ingrese descripcion del producto:");
		nuevoProducto.setDescripcion(scanner.nextLine());
		System.out.println("Ingrese precio unitario");
		nuevoProducto.setPrecioUnitario(scanner.nextDouble());
		scanner.nextLine();
		System.out.println("Seleccionar Pais de Origen: ");
		nuevoProducto.setOrigenFabricacion(elegirOrigen());
		System.out.println("Seleccionar Categoria: ");
		nuevoProducto.setCategoria(elegirCategoria());
		productos.add(nuevoProducto);
		System.out.println("<---PRODUCTO AGREGADO--->");
	}
	
	static OrigenFabricacion elegirOrigen () {
		
		do {
				System.out.println(" ARGENTINA"+"\n CHINA"+"\n BRASIL"+"\n URUGUAY"+"\n Ingrese el pais: ");
			try {
				OrigenFabricacion origen = OrigenFabricacion.valueOf(scanner.nextLine().toUpperCase());
				return origen;
			}catch (Exception e){
				System.out.println("PAIS NO VALIDO. REINTENTAR");
			}
		}while(true);
	}
	
	static Categoria elegirCategoria () {
		
		do {
				System.out.println(" TELEFONIA"+"\n INFORMATICA"+"\n ELECTROHOGAR"+"\n HERRAMIENTAS"+"\n Ingrese el pais: ");
			try {
				Categoria categoria = Categoria.valueOf(scanner.nextLine().toUpperCase());
				return categoria;
			}catch (Exception e){
				System.out.println("CATEGORIA NO VALIDA. REINTENTAR");
			}
		}while(true);
	}
	
	static void mostrarProductos() {
		//System.out.println("HEY");
		for(Producto producto1: productos) {
			System.out.println(producto1.toString());
		}
	}
	
	static void modificarProducto() {
		boolean modificar = false;
		System.out.println("Ingrese el codigo del producto:");
		String nombreProducto = scanner.nextLine();
		
		for(Producto producto2 : productos) {
			if(producto2.getCodigo().equals(nombreProducto)) {
				modificar = true;
				
				do{
					System.out.println("Seleccione que informacion modificar:" 
										+"\n 1 - Descripcion"
										+"\n 2 - Precio"
										+"\n 3 - Origen"
										+"\n 4 - Categoria"
										+"\n 5 - Salir");
					int opcion = validarEntero();
					switch(opcion) {
					case 1:	System.out.println("Ingresar nueva Descripcion: ");
							producto2.setDescripcion(scanner.nextLine());
						break;
					case 2: System.out.println("Ingresar nuevo Precio");
							producto2.setPrecioUnitario(validarDouble());
						break;
					case 3: System.out.println("Ingresar nuevo Origen: ");
							producto2.setOrigenFabricacion(elegirOrigen());
						break;
					case 4: System.out.println("Ingresar nueva Categoria");
							producto2.setCategoria(elegirCategoria());
						break;
					case 5: System.out.println("<---Fuera de Modificar Producto --->");
							modificar = false;
						break;
					default: 
					};
				} while(modificar);	
				
			}else {
				System.out.println("!!PRODUCTO NO ENCONTRADO!!");
			}
			
	}
		
		
		
	}
	
}
