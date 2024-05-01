package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;


public class Main {
	
		static ArrayList <Efemeride> efemerides = new ArrayList<>();
		static Scanner scanner = new Scanner(System.in);
		
		public static void main(String[] args) {
			menu();
			
	}

		static void menu() {
			
			boolean seguir = true;
			do {
				System.out.println("\n Seleccione una opcion: " 
															+ "\n 1 - Crear Efemeride"
															+ "\n 2 - Mostrar Efemerides"
															+ "\n 3 - Eliminar Efemeride"
															+ "\n 4 - Modificar efemeride"
															+ "\n 5 - Salir");
				int op = validarEntero();
				switch(op) {
				case 1: crearEfemeride() ;
					break;
				case 2: mostrarEfemerides();
					break;
				case 3: eliminarEfemeride();
					break;
				case 4: modificarEfemeride();
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
		
		static void crearEfemeride () {
			
			Efemeride nuevaEfemeride = new Efemeride();
			System.out.println("Ingresar el codigo de la Efemeride");
			nuevaEfemeride.setCodigo(scanner.nextLine());
			System.out.println("Ingrese mes:");
			nuevaEfemeride.setMes(elegirMes());
			System.out.println("Ingresar numero dia: ");
			nuevaEfemeride.setDia(validarEntero());
			System.out.println("Ingresar detalle: ");
			nuevaEfemeride.setDetalle(scanner.nextLine());
			efemerides.add(nuevaEfemeride);
			
			System.out.println("<---EFEMERIDE AGREGADA--->");
		}
		
		static Mes elegirMes () {
			int opcion;
			do {
					System.out.println(" 1 - ENERO"+"\n 2 - FEBRERO"
										+"\n 3 - MARZO"+"\n 4 - ABRIL"
										+"\n 5 - MAYO" + "\n 6 - JUNIO"
										+"\n 7 - JULIO" + "\n 8 - AGOSTO"
										+"\n 9 - SEPTIEMBRE" + "\n 10 - OCTUBRE"
										+"\n 11 - NOVIEMBRE" + "\n 12 - DICIEMBRE"
										+"\n Ingrese el mes: ");
					opcion = validarEntero();
			}while(opcion > 12 || opcion < 1);
			Mes mes = null;
			for(Mes mesNumerico : Mes.values()) {
				if(mes.getNumeroMes() == opcion) {
					mes = mesNumerico;
				}
			}
			return mes;
		}
		
		static void mostrarEfemerides() {
			for(Efemeride efemeride : efemerides) {
				System.out.println(efemeride.toString());
			}
		}
		
		static void eliminarEfemeride() {
			String codigo;
			int valores = efemerides.size();
			System.out.println("Ingresar codigo de la Efemeride: ");
			codigo = scanner.nextLine();
			
			efemerides.removeIf(efe->efe.getCodigo().equals(codigo));
			if(valores != efemerides.size()) {
				System.out.println("...Efemeride Borrada...");
			}else {
				System.out.println("!!CODIGO NO EXISTENTE");
			}
		}
		
		static void modificarEfemeride() {
			boolean modificar = false;
			System.out.println("Ingrese el codigo del producto:");
			String codigo = scanner.nextLine();
			
			for(Efemeride efemeride : efemerides) {
				if(efemeride.getCodigo().equals(codigo)) {
					modificar = true;
					
					do{
						System.out.println("Seleccione que informacion modificar:" 
											+"\n 1 - Mes"
											+"\n 2 - Dia"
											+"\n 3 - Detalle"
											+"\n 4 - Salir");
						int opcion = validarEntero();
						switch(opcion) {
						case 1:	System.out.println("Ingresar nuevo Mes: ");
								efemeride.setMes(elegirMes());
							break;
						case 2: System.out.println("Ingresar nuevo Dia");
								efemeride.setDia(validarEntero());
							break;
						case 3: System.out.println("Ingresar nuevo Detalle: ");
								efemeride.setDetalle(scanner.nextLine());;
							break;
						case 4: System.out.println("<---Fuera de Modificar Efemeride --->");
								modificar = false;
							break;
						default: System.out.println("!!!ERROR DESCONOCIDO!!!");
						};
					} while(modificar);	
					
				}else {
					System.out.println("!!EFEMERIDE NO ENCONTRADA!!");
				}
			}
		}
}
