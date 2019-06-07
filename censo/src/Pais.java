/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brian
 */
public class Pais extends Lugar {
    
    private Departamento[] departamentos;
    
    public Pais(String nombre, String[] nombresDepartamentos) {
        this.setNombre(nombre);
        this.departamentos = new Departamento[nombresDepartamentos.length];
        for (int i = 0; i < nombresDepartamentos.length; i++) {
            departamentos[i] = new Departamento(nombresDepartamentos[i]);
        }
       
    }

    @Override
    public void cargarDatos() {
        int totalpoblacion = 0;
        int totalcantidadHombres = 0;
        int totalcantidadMujeres = 0;
        double totaledadPromedio = 0;
        double totalingresoPromedio = 0;
        double totaltemperaturaMedia = 0;
    
        
        for (int i = 0; i < departamentos.length; i++) {
            totalpoblacion += departamentos[i].getPoblacion();
            totalcantidadHombres += departamentos[i].getCantidadHombres();
            totalcantidadMujeres += departamentos[i].getCantidadMujeres();
            totaledadPromedio += departamentos[i].getPromedioEdad();
            totalingresoPromedio += departamentos[i].getPromedioIngreso();
            totaltemperaturaMedia += departamentos[i].getPromedioTemperatura();
        }
        
        this.setPoblacion(totalpoblacion);
        this.setCantidadHombres(totalcantidadHombres);
        this.setCantidadMujeres(totalcantidadMujeres);
        this.setPromedioEdad((totaledadPromedio * departamentos.length)/100);
        this.setPromedioIngreso((totalingresoPromedio * departamentos.length)/100);
        this.setPromedioTemperatura((totaltemperaturaMedia * departamentos.length)/100);
    }

    @Override
    public void mostarDatos() {
        System.out.println("los datos del pais "+ this.getNombre().toUpperCase() + "son: ");
        System.out.println("cantidad de departamentos: " + departamentos.length);
        System.out.println("cantidad de poblacion de: " + this.getPoblacion());
        System.out.println("cantidad de hombres: " + this.getCantidadHombres());
        System.out.println("cantidad de mujeres: "+ this.getCantidadMujeres());        
        System.out.println("edad promedio de la poblacion: " + this.getPromedioEdad());
        System.out.println("promedio de ingresos de la poblacion: " + this.getPromedioIngreso());
        System.out.println("la temperatura promedio: " + this.getPromedioTemperatura());
    }
    
    public void buscarDepartamentoPorMunicipio(String municipio) {
        boolean f = false;
        for (int i = 0; i < departamentos.length; i++) {
            if(departamentos[i].tieneMunicipio(municipio)) {
                f = true;
                System.out.println("\t" + (i+1) + "  " + departamentos[i].getNombre());
                break;
            }
        }
        
        if(!f) {
            System.out.println("No existe ningun departamento con el municipio: "+ municipio);
        }
    }
    
    public void mostrarDepartamentos() {
        for (int i = 0; i < departamentos.length; i++) {
            departamentos[i].mostarDatos();
        }
    }

    public void mostrarListaDepartamentos() {
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println((i+1) +")" + departamentos[i].getNombre().toUpperCase() + ": ");
        }
    }
    
    public void mostrarDepartamentosConMunicipios() {
        for (int i = 0; i < departamentos.length; i++) {
            if(departamentos[i].tieneMunicipios()) {
                System.out.println("\t" +(i+1) + "  " + departamentos[i].getNombre());
            }
        }
    }

    public void mostrarDepartamentosPor(int poblacion) {
        for (int i = 0; i < departamentos.length; i++) {
            if(departamentos[i].getPoblacion() > poblacion) {
                System.out.println("\t" + (i+1) + "  " + departamentos[i].getNombre());
                System.out.println("\t" + departamentos[i].getPoblacion());
            }
        }
    }

    public void mostrarDepartamentosPor(double ingreso) {
        for (int i = 0; i < departamentos.length; i++) {
            if(departamentos[i].getPromedioIngreso() > ingreso) {
                System.out.println("\t" + (i+1) + "  " + departamentos[i].getNombre());
                System.out.println("\t" + departamentos[i].getPromedioIngreso());
            }
        }
    }

    
    public Departamento getDepartamento(int index) {
        return departamentos[index];
    }
    
}
