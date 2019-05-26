/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopersonas;

import java.util.Scanner;

/**
 *
 * @author Ingenieria
 */
public class ProyectoPersonas {
    public static Scanner sc = new Scanner(System.in);
    public static Persona pepe= new Persona("pepe",15,"futbolista");

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        pepe.mostrarDatos();
        int opcion = 0;
        

        do {
            System.out.println();
            System.out.println("******");
            System.out.println("*MENU*");
            System.out.println("******");
            System.out.println("1. cumplir edad");
            System.out.println("2. cambiar profesion");
            System.out.println("3. mostrar datos");
            System.out.println("4. Salir");

            System.out.println("Por favor ingrese una opci�n: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cumplirEdad();
                    break;
                case 2:
                    cambiarProfesion();
                    break;
                case 3:
                    mostarDatos();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar nuestro sistema.");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Ingres� una opci�n no disponible.");
            }
        } while (opcion != 4);
        
    }

    
    public static void cumplirEdad() {
        pepe.cumplirEdad(0);
    }

    
    public static void cambiarProfesion() {
        pepe.cambiarProfesion("");
    }
    public static void mostarDatos() {
        pepe.mostrarDatos();
        
    }
}