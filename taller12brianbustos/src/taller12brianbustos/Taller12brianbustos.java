/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller12brianbustos;

import java.util.Scanner;

/**
 *
 * @author brian
 */
public class Taller12brianbustos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        int opcion = 0;
        int[][] matriz1 = new int[3][3];
        int[][] matriz2 = new int[3][3];

        do {
            System.out.println();
            System.out.println("1.Ingresar el tamaño de las matrices\n" +
                                "2.Mostrar las matrices en cero\n" +
                                "3.Insertar valores a las matrices\n" +
                                "4.Actualizar valores de las matrices\n" +
                                "5.Sumar matrices6.Restar matrices\n" +
                                "7.Salir");
            
            System.out.println("Por favor ingrese una opci�n: ");
            opcion = Integer.parseInt(lectura.next());
            System.out.print("Usted ha seleccionado la opción "+opcion+".");
            
            switch (opcion) {
                case 1:
                    System.out.println("Por favor digite el tamaño de la matriz 1:");
                    int longitud = lectura.nextInt();
                    int longitud2 = lectura.nextInt();
                    matriz1 = inicializarConTamanio(longitud, longitud2);
                    
                    System.out.println("Digite el tamaño de la matriz 2:");
                    longitud = lectura.nextInt();
                    longitud2 = lectura.nextInt();
                    matriz2 = inicializarConTamanio(longitud, longitud2);
                    
                    break;
                case 2:
                    System.out.println("Matriz 1: ");
                    recorrerMatriz(matriz1);
                    
                    System.out.println("Matriz 2: ");
                    recorrerMatriz(matriz2);
                    
                    break;
                case 3:
                    System.out.println("Digite los valores a agregar en la matriz 1:");
                    matriz1 = llenarMatriz(matriz1, lectura);
                    
                    System.out.println("Digite los valores para la matriz 2:");
                    matriz2 = llenarMatriz(matriz2, lectura);
                    
                    break;
                case 4:
                    System.out.println("Digite la posición en la cual quiere actualizar el dato:");
                    int indice1 = lectura.nextInt();
                    int indice2 = lectura.nextInt();
                    
                    System.out.println("Digite cual matriz quiere actualizar:");
                    int matrizNumero = lectura.nextInt();
                    
                    if(certificar(matriz1, matriz2, matrizNumero, indice1, indice2)){
                        break;
                    }
                    
                    System.out.println("Digite el número a ingresar en la posición ["+indice1+"]["+indice2+"]");
                    int numero = lectura.nextInt();
                    if(matrizNumero == 1) {
                        matriz1[indice1][indice2] = numero;
                        recorrerMatriz(matriz1);
                    }else {
                        matriz2[indice1][indice2] = numero;
                        recorrerMatriz(matriz2);
                    
                    }
                    break;
                case 5:
                    System.out.println("La suma de la matriz 1 y la matriz 2 es: ");
                    for (int i = 0; i < retornarMayor(matriz1.length, matriz2.length ); i++) {
                        for (int j = 0; j <retornarMayor(matriz1[0].length, matriz2[0].length ); j++) {
                            System.out.print("[");
                            int suma = 0;
                            if(i < matriz1.length && j < matriz1[0].length) {
                                suma += matriz1[i][j];
                            }
                            if(i < matriz2.length && j < matriz2[0].length) {
                                suma += matriz2[i][j];
                            }
                            System.out.print(suma);
                            System.out.print("]");
                            
                        }
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("Digite 1 si desea restar la matriz 1 con la dos o digite 2 si desea restar la matriz 2 con la 1:");
                    int opcionResta = lectura.nextInt();
                    for (int i = 0; i < retornarMayor(matriz1.length, matriz2.length ); i++) {
                        for (int j = 0; j <retornarMayor(matriz1[0].length, matriz2[0].length ); j++) {
                            System.out.print("[");
                            if(opcionResta == 1) {
                                int resta = 0;
                                if(i < matriz1.length && j < matriz1[0].length) {
                                    resta = matriz1[i][j];
                                }
                                if(i < matriz2.length && j < matriz2[0].length) {
                                    resta -= matriz2[i][j];
                                }
                                System.out.print(resta);
                            } else {
                                int resta = 0;
                                if(i < matriz2.length && j < matriz2[0].length) {
                                    resta = matriz2[i][j];
                                }
                                if(i < matriz1.length && j < matriz1[0].length) {
                                    resta -= matriz1[i][j];
                                }
                                
                                System.out.print(resta);
                            }
                            System.out.print("]");
                            
                        }
                        System.out.println("");
                    }
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro sistema.");
                    System.exit(0); //con esta l�nea forzamos a que el programa se termine
                    break;
                default:
                    System.out.println("Ingres� una opci�n no disponible.");
            }//cierra switch
        } while (opcion != 7);
        // el ciclo se ejecuta (hace algo) hasta que "opcion" sea diferente del 
        //caso que se utiliza para salir o terminar el programa, en este ejemplo es el 3.
    }//cierra main


    public static int[][] inicializarConTamanio(int longitud, int lognitud2) {
        int[][] m1 = new int[longitud][lognitud2];
        return m1;
    }

    /**
     * Declaraci�n del m�todo felicitar()
     */
    public static void recorrerMatriz(int[][] m1) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j <m1[0].length; j++) {
                System.out.print("["+m1[i][j]+"]");
            }
            System.out.println("");
        }
    }//cierra m�todo felicitar
    
    public static int[][] llenarMatriz(int[][] m1, Scanner lectura) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j <m1[0].length; j++) {
                System.out.print("Posición["+i+","+j+"]");
                m1[i][j]  = lectura.nextInt();
            }  
        }
        return m1;
    
    }
    
    public static boolean certificar(int[][] m1,int[][] m2,int opcion,int indice1,int indice2) {       
        if(opcion > 2) {
            System.out.println("Solo exiten dos");
            return true;
        } else  if(opcion == 1) {
            if (indice1 > m1.length) {
                System.out.println("El indice uno no es accesible");
                return true;
            } else if (indice2 > m1[0].length) {
                System.out.println("El indice dos no es accesible");
                return true;
            }
        } else {
            if (indice1 > m2.length) {
                System.out.println("El indice uno no es accesible");
                return true;
            } else if (indice2 > m2[0].length) {
                System.out.println("El indice dos no es accesible");
                return true;
            }
        }
        
        return false;
    }
    
    public static int retornarMayor (int m1, int m2) {
        return m1 > m2 ? m1 : m2;
    }

}
