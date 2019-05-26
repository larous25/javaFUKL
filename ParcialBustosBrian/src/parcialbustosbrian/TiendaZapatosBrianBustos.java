/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialbustosbrian;

import java.util.Scanner;

/**
 *
 * @author brian
 */
public class TiendaZapatosBrianBustos {

    /*
    * @param Scanner lectura
    * genera el costo de los zapatos dependiendo la cantidad
    * de zapatos, tambien genera el iva y lo imprime
    */
    public static void calcularCostoPar (Scanner lectura) {
        boolean cantidadMenorACero;
        int cantidadDeParesZapatos;
        int costoPorPar = 0;
        do {
            System.out.println("Por favor ingrese la cantidad de pares de zapatos");
            cantidadDeParesZapatos = lectura.nextInt();
            cantidadMenorACero = cantidadDeParesZapatos < 0;
            
            if(cantidadMenorACero) {
                System.out.println("Cantidad invalida!");
                System.out.println("Reiniciando opcion 1");
            } else {
            
                if((cantidadDeParesZapatos > 1) && (cantidadDeParesZapatos < 20)) {
                    costoPorPar = (cantidadDeParesZapatos * 90000);
                } else if (cantidadDeParesZapatos > 20) {
                    costoPorPar = (cantidadDeParesZapatos * 70000);
                }

                int iva = (costoPorPar * 19)/100;
                System.out.println("El iva es:...................." + iva);
                System.out.println("El costo por par es:.........." + costoPorPar);
                System.out.println("El total:....................." + (iva+costoPorPar));
            }
        } while (cantidadMenorACero);
    }
    
    public static void calcularDomicilio (Scanner lectura) {
        System.out.println("Ingrese para responder la pregunta si o no");
        System.out.println("Se realizara domicilio?");
        String respuesta = lectura.next();
        if ("si".equals(respuesta) || "Si".equals(respuesta) || "SI".equals(respuesta)) {
            
            System.out.println("Por favor ingrese la cantidad de pares de zapatos en el envio");
            int cantidad = lectura.nextInt();

            if(cantidad > 10) {
                System.out.println("Su envio es gratuito");
            } else {
                int domicilio = cantidad * 2000;
                System.out.println("Su envio tiene un costo de:..."+ domicilio);
            }   
        }   
    }
    
    public static void calcularSalarioVendedor (Scanner lectura) {
        System.out.println("Por favor ingrese las horas trabajadas al mes:");
        int horas = lectura.nextInt();
        System.out.println("Por favor ingrese el valor de las ventas realizadas:");
        int ventas = lectura.nextInt();

        int valorHora = 20000;
        int salarioBase = horas * valorHora;
        int bonificacion = (ventas *  10) / 100;
        int salarioTotal = salarioBase + bonificacion;
        
        System.out.println("Su salario base es de:.................................."+salarioBase);
        System.out.println("Su bonificacion por el total de ventas realizadas es:..."+bonificacion);
        System.out.println("Su salario total es de:................................."+salarioTotal);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        
        System.out.println("Por favor ingrese el numero de una de las siguientes opciones");
        System.out.println("1) valor de una venta");
        System.out.println("2) valor de un domicilio");
        System.out.println("3) salario de un vendedor");
        int opcion = lectura.nextInt();
        
        switch (opcion) {
            case 1: {
                calcularCostoPar(lectura);
                break;
            }
            case 2: {
                calcularDomicilio(lectura);
                break;
            }
            case 3: {
                calcularSalarioVendedor(lectura);
                break;
            }
            default: {
                System.out.println("Gracias por utilizar nuestro sistema");
                break;
            }
        }
    }
    
}
