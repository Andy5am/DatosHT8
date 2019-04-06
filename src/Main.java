import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * @author Andy Castillo 18040
 * @author Cristina Bautista 161260
 * @version 03/04/2019
 * Esta es la clase main
 */
public class Main {
    public static void main(String[]args){

        Vector lista = new Vector();

        //Leer archivo
        ArrayList<String> archivo = new ArrayList<String>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(System.getProperty("user.dir")+"/src/pacientes.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> archivo.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }

        //Agregar a una lista
        for (int i =0; i<archivo.size();i++){
            String [] pacientes= archivo.get(i).split(", ");
            //Se agregan los pacientes al vector
            Paciente paciente = new Paciente(pacientes[0],pacientes[1],pacientes[2]);
            lista.add(paciente);
        }
        Scanner input = new Scanner(System.in);

        System.out.println("Que desea utilizar?");
        System.out.println("1. VectorHeap");
        System.out.println("2. PriorityQueue");

        String opcion = input.nextLine();
        if (opcion.equals("1")){

            VectorHeap listaPacientes = new VectorHeap(lista);
            boolean continuar = true;

            //El menu
            while (continuar){

                System.out.println("\nBienvenido a su lista de espera de pacientes");
                System.out.println("Sus opciones son: ");
                System.out.println("1. Siguiente paciente");
                System.out.println("2. Salir");
                System.out.println("Que desea hacer doctor?");
                String respuesta = input.nextLine();

                if (respuesta.equals("1")){

                    if (!listaPacientes.isEmpty()) {
                        //Para que imprima los pacientes que necesiten de atencion de acuerdo a prioridad
                        System.out.println(listaPacientes.remove());
                    }else {
                        //Dice cuando ya no hayan mas pacientes
                        System.out.println("No hay mas pacientes Doc");
                    }
                    //opcion para que salga
                } else if (respuesta.equals("2")) {
                    continuar = false;
                    System.out.println("Gran trabajo doc");
                } else {
                    //Por si no escribe una de las opciones habiles
                    System.out.println("Opcion invalida");
                }
            }

        }
        else if (opcion.equals("2")) {

            //Se crea la PriorityQueue
            PriorityQueue listaPacientes = new PriorityQueue(lista);
            boolean continuar = true;

            //El menu
            while (continuar) {

                System.out.println("\nBienvenido a su lista de espera de pacientes");
                System.out.println("Sus opciones son: ");
                System.out.println("1. Siguiente paciente");
                System.out.println("2. Salir");
                System.out.println("Que desea hacer doctor?");
                String respuesta = input.nextLine();

                if (respuesta.equals("1")) {

                    if (!listaPacientes.isEmpty()) {
                        //Para que imprima los pacientes que necesiten de atencion de acuerdo a prioridad
                        System.out.println(listaPacientes.remove());
                    } else {
                        //Dice cuando ya no hayan mas pacientes
                        System.out.println("No hay mas pacientes Doc");
                    }
                    //opcion para que salga
                } else if (respuesta.equals("2")) {
                    continuar = false;
                    System.out.println("Gran trabajo doc");
                } else {
                    //Por si no escribe una de las opciones habiles
                    System.out.println("Opcion invalida");
                }
            }
        }else {
            System.out.println("Opcion invalida");
        }
    }
}
