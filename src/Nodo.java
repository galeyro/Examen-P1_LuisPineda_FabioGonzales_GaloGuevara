public class Nodo {
    //Atributos
    public Nodo siguiente;
    public Guerrero guerrero;

    //Constructor
    public Nodo(Guerrero guerrero) {
        this.siguiente = null; //Reservar el espacio de memoria
        this.guerrero = guerrero;
    }
}
