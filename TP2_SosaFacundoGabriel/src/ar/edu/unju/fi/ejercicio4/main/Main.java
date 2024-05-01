package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	static ArrayList <Jugador> jugadores = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		menu();
	}

	static void menu() {
		
		boolean seguir = true;
		do {
			System.out.println("\n Seleccione una opcion: " 
														+ "\n 1 - Alta de Jugador"
														+ "\n 2 - Mostrar todos los jugadores"
														+ "\n 3 - Modificar la posición de un jugador"
														+ "\n 4 - Eliminar un jugador"
														+ "\n 5 - Salir");
			int op = validarEntero();
			switch(op) {
			case 1: crearJugador();
				break;
			case 2: mostrarJugador();
				break;
			case 3: modificarPosicion();
				break;
			case 4: eliminarJugador();
				break;
			case 5: System.out.println(" PROCESO TERMINADO");
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
	
	static void crearJugador () {
		
		Jugador nuevoJugador = new Jugador();
		System.out.println("Ingresar Nombre: ");
		nuevoJugador.setNombre(scanner.nextLine().toUpperCase());
		System.out.println("Ingresar Apellido: ");
		nuevoJugador.setApellido(scanner.nextLine().toUpperCase());
		System.out.println("");
		
		System.out.println("Ingresar nacionalidad: ");
		nuevoJugador.setNacionalidad(scanner.nextLine().toUpperCase());
		System.out.println("Ingresar estatura: ");
		nuevoJugador.setEstatura(validarDouble());
		System.out.println("Ingresar peso: ");
		nuevoJugador.setPeso(validarDouble());
		System.out.println("Ingresar posicion: ");
		nuevoJugador.setPosicion(elegirPosicion());
		System.out.println("Ingresar fecha de nacimiento: ");
		nuevoJugador.setFechaNacimiento(fechaNacimiento());
		
		System.out.println("<---JUGADOR AGREGADO--->");
	}	
	
	static Posicion elegirPosicion () {
		int opcion;
		do {
				System.out.println(" 1 - DELANTERO"+"\n 2 - MEDIO"
									+"\n 3 - DEFENSA"+"\n 4 - ARQUERO"
									+"\n Ingrese la posicion: ");
				opcion = validarEntero();
		}while(opcion > 4 || opcion < 1);
		
		
		return Posicion.values()[opcion];
	}
	
	static LocalDate fechaNacimiento () {
		LocalDate fecha;
		do {
			try {
				System.out.println("Ingresar dia de nacimiento [1-31]: ");
				int dia = scanner.nextInt();
				System.out.println("Ingresar mes de nacimiento [1-12]: ");
				int mes = scanner.nextInt();
				System.out.println("Ingresar año de nacimiento [yyyy]: ");
				int year = scanner.nextInt();
				fecha = LocalDate.of(year, mes, dia);
				return fecha;
			}catch(Exception e) {
				System.out.println("Error al ingresar la fecha" + e);
			}
		}while(true);
	}
	
	static void mostrarJugador() {
		for(Jugador jugador : jugadores) {
			System.out.println(jugador.toString());
		}
	}
	
	static void modificarPosicion() {
		System.out.println("Ingresar nombre del jugador: ");
		String nombre = scanner.nextLine().toUpperCase();
		System.out.println("Ingresar apellido: ");
		String apellido = scanner.nextLine().toUpperCase();
		boolean encontrado = false;
		for(Jugador jugador : jugadores) {
			if(jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido) ) {
				jugador.setPosicion(elegirPosicion());
				encontrado = true;
			}
		}
		if(encontrado == true) {
			System.out.println("<<Jugador Modificado>>");
		}else {
			System.out.println("!!Jugador NO Encontrado!!");
		}
	}
	
	static void eliminarJugador() {

		System.out.println("Ingresar nombre del jugador: ");
		String nombre = scanner.nextLine().toUpperCase();
		System.out.println("Ingresar apellido: ");
		String apellido = scanner.nextLine().toUpperCase();
		
		Iterator<Jugador> iterator = jugadores.iterator();
		while(iterator.hasNext()) {
			Jugador j = (Jugador) iterator.next();
			if(j.getNombre().equals(nombre) && j.getApellido().equals(apellido)) {
				iterator.remove();
			}
		}
		
	}
	
}
