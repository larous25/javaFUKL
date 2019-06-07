/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.util.Scanner;

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

        Scanner lectura = new Scanner(System.in);
        Juego ahorcado = new Juego(6);
        do {
            // salida de pantalla de estados del juego
            ahorcado.mostrarValores();
            
            System.out.println("Ingrese una letra");
             // pide ingresasr una letra (funciona para todo exepto enter)
            String ingreso = lectura.next();
            char letra = ingreso.charAt(0);
            ahorcado.intento(letra);
        } while (ahorcado.existenIntentos());
        
        ahorcado.esfinal();
        
    }
  
}