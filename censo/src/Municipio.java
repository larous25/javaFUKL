
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cristian Prieto
 */
public class Municipio extends Lugar {

    private final Scanner sc;
    
    public Municipio(String nombre) {
        this.sc = new Scanner(System.in);
        this.setNombre(nombre);
    }

    @Override
    public void cargarDatos() {    
        System.out.println("ingrese la poblacion: ");
        this.setPoblacion(sc.nextInt());
        System.out.println("ingrese la cantidad de hombres: ");
        this.setCantidadHombres(sc.nextInt());
        this.setCantidadMujeres(this.getPoblacion() - this.getCantidadHombres());        
        System.out.println("ingrese la edad promedio de la poblacion: ");
        this.setPromedioEdad(sc.nextDouble());
        System.out.println("ingrese el promedio de ingreso monetario:");
        this.setPromedioIngreso(sc.nextDouble());
        System.out.println("ingrese el promedio de temperatura:");
        this.setPromedioTemperatura(sc.nextDouble());
    }

    @Override
    public void mostarDatos() {
        System.out.println("Datos en el municipio de " + this.getNombre().toUpperCase() + ": ");
        System.out.println("poblacion de: " + this.getPoblacion());
        System.out.println("cantidad de hombres: " + this.getCantidadHombres());
        System.out.println("cantidad de mujeres: "+ this.getCantidadMujeres());        
        System.out.println("edad promedio: " + this.getPromedioEdad());
        System.out.println("ingreso promedio : " + this.getPromedioIngreso());
        System.out.println("temperatura promedio: " + this.getPromedioTemperatura());
    }
    
    public void editarDatos() {
        this.mostarDatos();
        System.out.println("Ingrese los nuevos datos");
        this.cargarDatos();
    }

    

}
