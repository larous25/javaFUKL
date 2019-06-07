
import java.time.LocalDate;
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
public class CensoEjecutable {
        static String[] departamentos = {
                "Amazonas", "Antioquia", "Arauca", "Atlántico", "Bolivar", "Boyacá", "Caldas", "Caquetá", "Casanare", "Cauca", "Cesar", "Chocó",
                "Córdoba", "Cundinamarca", "Guainía", "Guajira", "Guaviare", "Huila", "Magdalena", "Meta", "Nariño", "Norte de Santander",
                "Putumayo", "Quindío", "Risaralda", "San Andrés y Providencia", "Santander", "Sucre", "Tolima", "Valle Del Cauca",
                "Vaupés", "Vichada"
        };
        
        static Pais colombia = new Pais("Colombia", departamentos);
        
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("CARGAR DATOS PARA EL CENSO "+ localDate);
        menu();

    }
     
    public static void menu() {
                Scanner lectura = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println();
            System.out.println("1. Agregar un municipio");
            System.out.println("2. Editar la información de un municipio");
            System.out.println("3. Buscar un departamento de un municipio");
            System.out.println("4. Consultar si existen departamentos con un ingreso superior a un valor dado");
            System.out.println("5. Consultar si existen departamentos con una población igual a un valor dado");
            System.out.println("6. Visualizar el total del censo por departamento");
            System.out.println("7. Visualizar el total del censo a nivel nacional");
            System.out.println("8. Salir");

            System.out.println("Por favor ingrese una opcion: ");
            opcion = Integer.parseInt(lectura.next());

            switch (opcion) {
                case 1:
                    System.out.println("Por favor ingrese el numero correspondiente al departamento");
                    System.out.println("Al cual agregara el municipio");
                    colombia.mostrarListaDepartamentos();
                    int indice1 = crearIndice(lectura);
                    colombia.getDepartamento(indice1).agregarMunicipio();
                    break;
                case 2:
                    System.out.println("Porfavor escoja uno de los siguientes departamentos");
                    colombia.mostrarDepartamentosConMunicipios();
                    int indice2 = crearIndice(lectura);
                    colombia.getDepartamento(indice2).editarMunicipio();
                    break;  
                case 3:
                    System.out.println("Por favor ingrese el nombre del municipio");
                    String nombre = lectura.next();
                    colombia.buscarDepartamentoPorMunicipio(nombre);
                    break;
                case 4:
                    System.out.println("Por favor ingrese la el nivel de ingresos ");
                    double ingreso = lectura.nextDouble();
                    colombia.mostrarDepartamentosPor(ingreso);
                    break;
                case 5:
                    System.out.println("Por favor ingrese la poblacion ");
                    int poblacion = lectura.nextInt();
                    colombia.mostrarDepartamentosPor(poblacion);
                    break;
                case 6:
                    colombia.mostrarDepartamentos();
                    break;
                case 7:
                    colombia.mostarDatos();
                    break;
                case 8:
                    System.out.println("Gracias por utilizar nuestro sistema.");
                    System.exit(0); 
                    break;
                default:
                    System.out.println("Ingreso una opcion no disponible.");
            }
        } while (opcion != 8);
    }
      
    public static void mostrarOpciones(String[] nombres) {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("\t" +(i+1) + "  " + nombres[i]);
        }
    }
    
    public static int crearIndice(Scanner lectura) {
        return lectura.nextInt() -1;
    }
}

