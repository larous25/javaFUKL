/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

/**
 *
 * @author brian
 */
public class Juego {
    String palabraOriginal = "pala";
    int tamanio = palabraOriginal.length();
    
    char[] falsaPalabra = new char[tamanio];
    char[] palabra = palabraOriginal.toCharArray();
    char[] ahorcado = "ahorcado".toCharArray();
    char[] falsoAhorcado = new char[ahorcado.length];
    
    int intentos = 0;
    int contador = 0;
    int contadorAhorcado = 0;
    char[] ingresos = new char[intentos];
    boolean terminar = false;
    
    public Juego (int intentos) {
        this.intentos = intentos;
        for (int i = 0; i < tamanio; i++) {
            falsaPalabra[i] = '_';
        }
        System.out.println("Cantidad de letras en la palabra: "+ tamanio);
    }
    
    public void intento (char letra) {
            
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
                if (pasarAString(palabra).equals(pasarAString(falsaPalabra))) {
                    terminar = true;
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
     
    }
    
    public void mostrarValores () {
        System.out.println("Estado: " + pasarAString(falsoAhorcado));
        System.out.println("Intentos: " + (intentos - contador));
        System.out.println(pasarAString(falsaPalabra));
        System.out.println("");            
    }
    
    public String pasarAString (char[] c) {
        return String.valueOf(c);
    }
    /**
     * @param 
     * @param args arreglo de tipo caracter
     * @param letra valor ingresado de tipo caracterr
     * @return -1 si no encuentra nada y el indice si encuentra algo
     */
    public int buscar(char[] args, char letra) {
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
    public char[] agregar(char[] args, char letra) {
        
        for (int i = 0; i < args.length; i++) {
            if(args[i] == 0) {
                args[i] = letra;
                break;
            }
        }
        return args;
    }

    public boolean existenIntentos () {
        return intentos > contador && !terminar;
    }
    
    // salida por pantalla de gano o perdio segun 
    // el valor 
    public void esfinal () {
        if (intentos <= contador)  {
            System.out.println("Perdio");
            System.out.println("Estado: " + String.valueOf(ahorcado));
        } else {
            System.out.println("Gano!");
        }
    }
}
