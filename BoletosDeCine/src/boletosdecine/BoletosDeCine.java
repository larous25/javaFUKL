
package boletosdecine;

import java.util.Scanner;
import java.util.Arrays;

public class BoletosDeCine {
    
    static Scanner lectura = new Scanner(System.in);
    static char[][] sala = new char[8][20];
    static char[] nombreFila = {'A', 'B', 'C','D', 'E', 'F', 'G', 'H'};
    static int costoVentas = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 0;
        
        for (char[] sala1 : sala) {
            Arrays.fill(sala1, '-');
        }
        
        do {
            System.out.println();
            System.out.println("Menú de opciones");
            System.out.println("");
            System.out.println("1. Mostrar plano de la sala");
            System.out.println("2. Vender un boleto");
            System.out.println("3. Cambiar silla");
            System.out.println("4. Mostrar ingresos por ventas");
            System.out.println("5. Consultar la cantidad de sillas ocupadas de toda la sala");
            System.out.println("6. Salir");

            opcion = Integer.parseInt(lectura.next());
            System.out.print("Seleccionó la opción "+ opcion + ", ");
            switch (opcion) {
                case 1:
                   mostrarPlano();
                    break;
                case 2:
                    venderBoleto();
                    break;
                case 3:
                   cambiarSilla();
                    break;
                case 4:
                   mostrarIngresos();
                    break;
                case 5:
                 consultarSillasOcupadas();
                    break;
                case 6:
                    System.out.println("Gracias por utilizar nuestro sistema.");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Ingresó una opción no disponible.");
            }
        } while (opcion != 6);   
    }
    
    
    /**
     * Declaracion del metodo mostrarPlano()
     * * Opción 1
     * @param x
     */
    public static void mostrarPlano() {
        System.out.print("Mostrar plano de la sala.");
       
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < sala[0].length; i++) {
            System.out.print((i+1)+"\t");
        }
        
        System.out.println("");
        for (int i = 0; i < sala.length; i++) {
               System.out.print(nombreFila[i] + "\t");
            for (int j = 0; j < sala[i].length; j++) {
                System.out.print(sala[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.print("****************************************************");
        System.out.print("********************PANTALLA************************");
        System.out.print("****************************************************");
        System.out.println("");
    }//cierra metodo mostrarPlano()
 
    /**
     * Declaracion del metodo venderBoleto()
     * * Opción 2
     */
    public static void venderBoleto () {
        System.out.print("Vender un boleto");
        System.out.println("");
        System.out.println("Ingrese la silla");
   
        int[] cord = optenerFilaYColumna();
        int fila = cord[0];
        int columna = cord[1];
   
        if(sala[fila][columna] != '0') {
            sala[fila][columna] = '0';
            int costo = calcularCosto(fila);
            costoVentas += costo;
            System.out.println("El boleto tiene un costo de: $"+costo+".");
        } else {
            System.out.println("La silla seleccionada se encuentra ocupada");
        }
        
        
        
    }//cierra metodo venderBoleto

    /**
     * Declaracion del metodo cambiarSilla()
     * * Opción 3
     */
    public static void cambiarSilla () {
        System.out.print("Cambiar silla");
        System.out.println("");
        System.out.println("Ingrese silla actual");

        
        int[] cord = optenerFilaYColumna();
        int fila = cord[0];
        int columna = cord[1];
        
        if(sala[fila][columna] == '0') {

            System.out.println("Ingrese nueva silla:");

            int[] cord2 = optenerFilaYColumna();
            int fila2 = cord2[0];
            int columna2 = cord2[1];

            if(sala[fila2][columna2] == '0') {
                System.out.println("La silla seleccionada se encuentra ocupada");
            } else 
                sala[fila][columna] = '-';
                sala[fila2][columna2] = '0';
                int costoAnterior = calcularCosto(fila);
                int costoNueva = calcularCosto(fila2);
                System.out.println("La silla se cambió correctamente");
                if (costoAnterior > costoNueva) {
                    int diferencia = costoAnterior - costoNueva;
                    System.out.println("La nueva silla cuesta "+diferencia+" pesos menos.");
                    costoVentas -= diferencia;
                }
                if (costoAnterior < costoNueva) {
                    int diferencia = costoNueva -costoAnterior;
                    System.out.println("La nueva silla cuesta "+diferencia+" pesos mas.");
                    costoVentas += diferencia;
                }

        }
    }//cierra metodo cambiarSilla()

    
    
    /**
     * Declaracion del metodo mostrarIngresos()
     * * Opción 4
     */
    public static void mostrarIngresos () {
        System.out.print("Mostrar ingresos por ventas");
        System.out.println("De acuerdo a la boletería vendida, los ingresos por ventas son:"+ costoVentas);
    }//cierra metodo mostrarIngresos()
    
    
    
    /**
     * Declaracion del metodo consultarSillasOcupadas()
     * * Opción 5
     */
    public static void consultarSillasOcupadas () {
        System.out.print("Consultar la cantidad de sillas ocupadas de toda la sala.");
        System.out.println("Cantidad de sillas ocupadas:");

        System.out.println("Categoría 1: "+ consultarDesdeHasta(5,7));
        System.out.println("Categoría 2: "+ consultarDesdeHasta(2,5));
        System.out.println("Categoría 3: "+ consultarDesdeHasta(0,2));
    }//cierra metodo consultarSillasOcupadas()

    // cuenta cuantas sillas ocupadas desde un punto a otro
    public static int consultarDesdeHasta (int desde, int hasta) {
        int cantidad = 0;
        
        for (int i = desde; i < hasta; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if(sala[i][j] == '0') {
                    cantidad++;
                }
            }
        }
        return cantidad;
    }
    
    // espera una cadena y luego la divide
    public static int[] optenerFilaYColumna () {
        String silla = lectura.next();
        String[] arreglo = silla.split("&");
        int fila = 0;     
        for (int i = 0; i < nombreFila.length; i++) {
            if (nombreFila[i] == arreglo[0].toUpperCase().charAt(0)) {
                fila = i;
                break;
            }
        }
                
        int columna = Integer.parseInt(arreglo[1]);
        if(columna > 0) {
            columna--;
        }
        int[] x = { fila, columna };
        return x;
    }
    
    public static int calcularCosto (int fila) {
        int costo = 0;

        if(fila >= 0 && fila < 2) { costo = 4000;   }
        else if(fila < 5 && fila >= 2) {    costo = 5300;   }
        else if(fila >= 5 && fila <= 7) {   costo = 8800;   }
            
        return costo;
    }
    
}//Cierra clase
