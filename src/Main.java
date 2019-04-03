import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[]args){

        Vector lista = new Vector();

        ArrayList<String> archivo = new ArrayList<String>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(System.getProperty("user.dir")+"/pacientes.txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(a -> archivo.add(a));
        }catch (IOException e ){
            System.out.println("Error!");
        }

        for (int i =0; i<archivo.size();i++){
            String [] pacientes= archivo.get(i).split(", ");
            Paciente paciente = new Paciente(pacientes[0],pacientes[1],pacientes[2]);
            lista.add(paciente);
        }

        PriorityQueue listaPacientes = new PriorityQueue(lista);
        boolean continuar = true;
        while (continuar){

            System.out.println("\nBienvenido a su lista de espera de pacientes");
            System.out.println("Sus opciones son: ");
            System.out.println("1. Siguiente paciente");
            System.out.println("2. Salir");
            System.out.println("Que desea hacer doctor?");
            Scanner input = new Scanner(System.in);
            String respuesta = input.nextLine();

            if (respuesta.equals("1")){

                if (!listaPacientes.isEmpty()) {
                    System.out.println(listaPacientes.remove());
                }else {
                    System.out.println("No hay mas pacientes Doc");
                }
            } else if (respuesta.equals("2")) {
                continuar = false;
                System.out.println("Gran trabajo doc");
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }
}
