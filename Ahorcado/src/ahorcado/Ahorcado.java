/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author brian
 */
public class Ahorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inicializamos las variables
        String palabraOriginal = "pala";
        int tamanio = palabraOriginal.length();
        char[] falsaPalabra = new char[tamanio], palabra = palabraOriginal.toCharArray();
        char[] ahorcado = "ahorcado".toCharArray(), falsoAhorcado = new char[ahorcado.length];
        Scanner lectura = new Scanner(System.in);
        for (int i = 0; i < tamanio; i++) {
            falsaPalabra[i] = '_';
        }
        int intentos = 6, contador = 0, contadorAhorcado = 0;
        char[] ingresos = new char[intentos];
        
        System.out.println("Cantidad de letras en la palabra: "+ tamanio);
        do {
            // salida de pantalla de estados del juego
            System.out.println("Estado: " + String.valueOf(falsoAhorcado));
            System.out.println("Intentos: " + (intentos - contador));
            System.out.println(String.valueOf(falsaPalabra));
            System.out.println("");
            
            // pide ingresasr una letra (funciona para todo exepto enter)
            System.out.println("Ingrese una letra");
            String ingreso = lectura.next();
            char letra = ingreso.charAt(0);
            // mira si ya ingreso la letra
            if(buscar(ingresos, letra) > 0) {
                System.out.println("Letra ya ingresada");
            } else {
                // mira si la letra esta en la palabra
                if(buscar(palabra, letra) >= 0) {
                    for (int i = 0; i < tamanio; i++) {
                        if (palabra[i] == letra) {
                            falsaPalabra[i] = letra;
                        }
                    }
                    
                    // si se encontro la palabra entonces termina el ciclo
                    if (Arrays.equals(palabra, falsaPalabra)) {
                        break;
                    }
                } else {
                    // va agregando letras al titulo de ahorcado
                    falsoAhorcado[contadorAhorcado] = ahorcado[contadorAhorcado];
                    contadorAhorcado++;
                }
            }
            // agrega las letras utilizadas
            agregar(ingresos, letra);
            
            contador++;
        } while(intentos > contador);

        // salida por pantalla de gano o perdio segun 
        // el valor 
        if (intentos <= contador)  {
            System.out.println("Perdio");
            System.out.println("Estado: " + String.valueOf(ahorcado));
        } else {
            System.out.println("Gano!");
        }
    }
    
    /**
     * @param 
     * @param args arreglo de tipo caracter
     * @param letra valor ingresado de tipo caracterr
     * @return -1 si no encuentra nada y el indice si encuentra algo
     */
    public static int buscar(char[] args, char letra) {
        int resultado = -1;
        // rrecore el vector para ver si existe la letra
        for (int i = 0; i < args.length; i++) {
            if(args[i] == letra) {
                resultado = i;
            }
        }
        return resultado;
    }

    // donde sea cero agrega asi va en aumento, en teoria
    public static char[] agregar(char[] args, char letra) {
        
        for (int i = 0; i < args.length; i++) {
            if(args[i] == 0) {
                args[i] = letra;
                break;
            }
        }
        return args;
    }    
}
