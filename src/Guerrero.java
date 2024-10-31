import javax.swing.*;

public class Guerrero {
    //Atributos
    String nombre;
    int nivelPoder;
    String raza; //Saiyajin, Namekusein, Terrícola;
    String habilidad;//Kamehameha, Cañon Especial, Onda Explosiva

    //Constructor por paramentros
    public Guerrero(String nombre, int nivelPoder, String raza, String habilidad) {
        this.nombre = nombre;
        this.nivelPoder = nivelPoder;
        this.raza = raza;
        this.habilidad = habilidad;
    }
    //constructor por defecto
    public Guerrero() {
        this.nombre = "Guerrero";
        this.nivelPoder = 0;
        this.raza = "";
        this.habilidad = "";
    }

    //Sobreescribimos metodo toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Nivel de Poder: " + nivelPoder + ", Raza: " + raza + ", Habilidad: " + habilidad;
    }


    //R2 Metodo para calcular el nivel de poder
    public void calcularPoder() {
        double poderTotal;

        //Escoger el tipo de raza
        switch (raza.toLowerCase()) {
            case "saiyajin":
                poderTotal = nivelPoder * 1.5;
                break;
            case "namekusein":
                poderTotal = nivelPoder * 1.2;
                break;
            case "terricola":
                poderTotal = nivelPoder;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Raza desconocida");
                return;
        }

        //Formato del mensaje de salida
        String mensaje = String.format(
                "Nombre: %s\nNivel de poder: %d\nRaza: %s\nHabilidad: %s\nNivel de poder total: %.2f",
                nombre, nivelPoder, raza, habilidad, poderTotal);

        JOptionPane.showMessageDialog(null, mensaje);
    }
}