import javax.swing.*;

public class ColaGuerreros {
    //Nodo que actue como frente, final cola y tamaño
    public Nodo frente;
    public Nodo finalCola;
    public int tamano;

    //Inicializar con varios nodos
    public ColaGuerreros() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    //Comprobar si esta vacia
    public boolean estaVacia(){
        return  frente == null;
    }

    //Mostrar la cola
    public void mostrarCola(JTextArea textArea) {

        if (estaVacia()) {
            textArea.setText("La cola esta vacia");

        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null) {
                colaStr.append(actual.guerrero).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    //Actualizar pantalla
    public void actualizarCola(JTextArea textArea) {
        mostrarCola(textArea);
    }

    //Metodo para encolar
    public void encolar(Guerrero guerrero, JTextArea textArea) {
        Nodo guerreroNuevo = new Nodo(guerrero);
        if (estaVacia()){
            frente = guerreroNuevo;
            finalCola = guerreroNuevo;
        }else {
            finalCola.siguiente = guerreroNuevo;
            finalCola = guerreroNuevo;
        }
        tamano++;
        actualizarCola(textArea);
    }

    //Metodo para desencolar
    public String desencolar(JTextArea textArea){
        if (estaVacia()){
            JOptionPane.showMessageDialog(null, "La cola se encuentra vacia");
            return "";
        }
        String nombreSale = frente.guerrero.nombre;
        frente = frente.siguiente;
        tamano--;

        //Debo verificar si verdaderamente esta vacio
        if (frente == null){
            finalCola=null;
        }
        actualizarCola(textArea);

        return nombreSale + " Es el guerrero";
    }

    //R1 Metodo para encolar 5 objetos, 1 por defecto y 4 predefinidos
    public void encolarPredefinidos() {
        JTextArea textArea = new JTextArea();

        //Datos predefinidos

        Guerrero g1 = new Guerrero("Goku", 20, "Saiyajin", "Kamehameha");
        Guerrero g2 = new Guerrero("Luis", 30, "Namekusein", "Onda Explosiva");
        Guerrero g3 = new Guerrero("Galo", 10, "Terricola", "Kamehameha");
        Guerrero g4 = new Guerrero("Fabio", 40, "Saiyajin", "Cañon Especial");
        Guerrero g5 = new Guerrero();

        //Encolar los datos
        encolar(g1, textArea);
        encolar(g2, textArea);
        encolar(g3, textArea);
        encolar(g4, textArea);
        encolar(g5, textArea);
    }

    //R2 Metodo en clase ColaGuerreros

    //R3 Metodo copiar en nueva cola
    public void copiarColaHabilidad(String habilidad, JTextArea textAreaOriginal, JTextArea textAreaNueva){

        ColaGuerreros nuevaCola = new ColaGuerreros(); // Create a new queue

        // Recorrer la cola de guerreros originales y copiar en la nueva
        Nodo actual = frente;
        while (actual != null) {
            if (actual.guerrero.habilidad.equalsIgnoreCase(habilidad)) {
                nuevaCola.encolar(new Guerrero(actual.guerrero.nombre, actual.guerrero.nivelPoder, actual.guerrero.raza, actual.guerrero.habilidad), textAreaNueva);//Guardamos en la nueva textArea
            }
            actual = actual.siguiente;
        }

        mostrarCola(textAreaOriginal);
        nuevaCola.mostrarCola(textAreaNueva);
    }
}
