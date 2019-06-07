
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
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
public class Departamento extends Lugar {
    
    private final Scanner sc;
    private ArrayList<Municipio> municipios = new ArrayList<Municipio>();
    
    public Departamento(String nombre) {
        this.sc = new Scanner(System.in);
        this.setNombre(nombre);
    }

    
    public void agregarMunicipio() {
        System.out.println("Ingrese el nombre el municipio de " + this.getNombre().toUpperCase() + ": ");
        String nombreMunicipio = sc.nextLine();
        Municipio nuevoMunicipio = new Municipio(nombreMunicipio);
        nuevoMunicipio.cargarDatos();
        municipios.add(nuevoMunicipio);
        this.cargarDatos();

    }

    public void editarMunicipio() {
        System.out.println("Selecione uno de los siguientes municipios de " + this.getNombre().toUpperCase() + ": ");
        mostarMunicipios();
        int indice = sc.nextInt() - 1;
        if (indice >= 0 && indice < municipios.size()) {
            municipios.get(indice).editarDatos();
            this.cargarDatos();
        } else {
            System.out.println("Solo son validos los numeros mayores a cero y menores a "+ municipios.size());
        }
    }
    
    public void mostarMunicipios() {
        Iterator<Municipio> municiopioIterador = municipios.iterator(); 
        int contador = 0;
        while (municiopioIterador.hasNext()) {
            Municipio municipio = municiopioIterador.next();
            contador++;
            System.out.println(contador+") " + municipio.getNombre());   
        }
        
    }    
    
    public boolean tieneMunicipios () {
        return municipios.size() > 0;
    }
    
    public boolean tieneMunicipio (String municipio) {
        return municipios.stream().filter(m -> m.getNombre().equals(municipio)).findFirst().isPresent();
    }

    @Override
    public void cargarDatos() {
     
        int totalpoblacion = 0;
        int totalcantidadHombres = 0;
        int totalcantidadMujeres = 0;
        double totaledadPromedio = 0;
        double totalingresoPromedio = 0;
        double totaltemperaturaMedia = 0;

        Iterator<Municipio> municiopioIterador = municipios.iterator();
        while (municiopioIterador.hasNext()) {
            Municipio municipio = municiopioIterador.next();
            totalpoblacion += municipio.getPoblacion();
            totalcantidadHombres += municipio.getCantidadHombres();
            totalcantidadMujeres += municipio.getCantidadMujeres();
            totaledadPromedio += municipio.getPromedioEdad();
            totalingresoPromedio += municipio.getPromedioIngreso();
            totaltemperaturaMedia += municipio.getPromedioTemperatura();
      
        }

        this.setPoblacion(totalpoblacion);
        this.setCantidadHombres(totalcantidadHombres);
        this.setCantidadMujeres(totalcantidadMujeres);
        this.setPromedioEdad((totaledadPromedio*this.municipios.size())/100);
        this.setPromedioIngreso((totalingresoPromedio*this.municipios.size())/100);
        this.setPromedioTemperatura((totaltemperaturaMedia*this.municipios.size())/100);
    }

    @Override
    public void mostarDatos() {
        System.out.println("Datos del Departamento " + this.getNombre().toUpperCase() + ": ");
        System.out.println("cantidad de municipios: " + this.municipios.size());
        System.out.println("cantidad de poblacion de: " + this.getPoblacion());
        System.out.println("cantidad de hombres: " + this.getCantidadHombres());
        System.out.println("cantidad de mujeres: "+ this.getCantidadMujeres());        
        System.out.println("edad promedio de la poblacion: " + this.getPromedioEdad());
        System.out.println("promedio de ingresos de la poblacion: " + this.getPromedioIngreso());
        System.out.println("la temperatura promedio: " + this.getPromedioTemperatura());
    }
}
    