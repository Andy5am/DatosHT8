/**
 * @author Andy Castillo 18040
 * @author Cristina Bautista 161260
 * @version 03/04/2019
 * Esta clase es la que va a contener la informacion de los pacientes como sus nombres, los sintomas y prioridad
 */
public class Paciente implements Comparable<Paciente>{
    String nombre;
    String sintoma;
    String prioridad;

    public Paciente(String nombre,String sintoma, String prioridad){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
    }

    public String getNombre() {

        return nombre;
    }

    public String getSintoma() {

        return sintoma;
    }

    public String getPrioridad() {

        return prioridad;
    }

    @Override
    public String toString() {

        return this.nombre+", "+this.sintoma+", "+this.prioridad;
    }

    @Override
    public int compareTo(Paciente paciente) {

        return prioridad.compareToIgnoreCase(paciente.getPrioridad());
    }
}
