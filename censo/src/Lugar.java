/**
 *
 * @author brian
 */
public abstract class Lugar {
    
    private String nombre;
    private int poblacion;
    private int cantidadHombres;
    private int cantidadMujeres;
    private double promedioEdad;
    private double promedioIngreso;
    private double promedioTemperatura;

    public abstract void cargarDatos ();

    public abstract void mostarDatos ();

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getCantidadHombres() {
        return cantidadHombres;
    }

    public void setCantidadHombres(int cantidadHombres) {
        this.cantidadHombres = cantidadHombres;
    }

    public int getCantidadMujeres() {
        return cantidadMujeres;
    }

    public void setCantidadMujeres(int cantidadMujeres) {
        this.cantidadMujeres = cantidadMujeres;
    }

    public double getPromedioEdad() {
        return promedioEdad;
    }

    public void setPromedioEdad(double promedioEdad) {
        this.promedioEdad = promedioEdad;
    }

    public double getPromedioIngreso() {
        return promedioIngreso;
    }

    public void setPromedioIngreso(double promedioIngreso) {
        this.promedioIngreso = promedioIngreso;
    }

    public double getPromedioTemperatura() {
        return promedioTemperatura;
    }

    public void setPromedioTemperatura(double promedioTemperatura) {
        this.promedioTemperatura = promedioTemperatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
