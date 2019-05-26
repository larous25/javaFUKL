/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopersonas;

/**
 *
 * @author Ingenieria
 */
public class Persona {
    private String nombre;
    private int edad;
    private String prefesion;
    
    public Persona(String nombre,int edad, String profesion){
        this.edad=edad;
        this.nombre=nombre;
        this.prefesion=profesion;
    }
    public void cumplirEdad(int edad){
        this.edad=edad;
    }
    public void cambiarProfesion(String profesion){
        this.prefesion=profesion;
    }
    public void mostrarDatos(){
        System.out.println(this.edad+"  "+this.nombre+" "+this.prefesion);
    }
}
