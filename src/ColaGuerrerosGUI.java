import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaGuerrerosGUI {
    private JPanel pGeneral;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;
    private JButton nivelButton;
    private JTextArea txtComparar;
    private JComboBox comboBox1;
    private JButton copiarButton;
    public ColaGuerreros c = new ColaGuerreros();

    private JTextArea textArea;

    public ColaGuerrerosGUI() {

        //Vamos a encolar primero los predefinidos
        c.encolarPredefinidos();
        c.actualizarCola(txtResultado);
        actualizarComboBox();

        //Boton desencolar
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.desencolar(txtResultado);
                actualizarComboBox();

            }
        });

        //Boton encolar
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {//Nombre
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del guerrero");
                    if (nombre == null || nombre.trim().isEmpty()) {
                        throw new IllegalArgumentException("El nombre no puede estar vacío");
                    }
                    //Nivel
                    int nivel = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nivel del guerrero"));
                    if (nivel <= 0) {
                        throw new IllegalArgumentException("El nivel debe ser un número positivo");
                    }
                    //Raza
                    String raza = JOptionPane.showInputDialog(null, "Ingrese la raza del guerrero: \nSaiyajin\nNamekusein\nTerricola");
                    if (raza == null || raza.trim().isEmpty()) {
                        throw new IllegalArgumentException("La raza no puede estar vacía");
                    }

                    // Habilidad
                    JComboBox<String> habilidadComboBox = new JComboBox<>(new String[]{"Kamehameha", "Cañon Especial", "Onda Explosiva"});
                    int result = JOptionPane.showConfirmDialog(null, habilidadComboBox, "Seleccione la habilidad", JOptionPane.OK_CANCEL_OPTION);
                    if (result != JOptionPane.OK_OPTION) {
                        throw new IllegalArgumentException("Debe seleccionar una habilidad");
                    }
                    String habilidad = (String) habilidadComboBox.getSelectedItem();
                    if (habilidad == null || habilidad.trim().isEmpty()) {
                        throw new IllegalArgumentException("La habilidad no puede estar vacía");
                    }

                    //Creamos objeto a encolar
                    Guerrero nuevo = new Guerrero(nombre, nivel, raza, habilidad);
                    c.encolar(nuevo, txtResultado);//encolamos
                    actualizarComboBox();//actualizamos ComboBox

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El nivel debe ser un número válido");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Eror inesperado: " + ex.getMessage());
                }
            }
        });

        //Boton para calcular el nivel total de poder
        nivelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //La seleccion es a partir de un ComboBox
                Guerrero seleccionado = (Guerrero) comboBox1.getSelectedItem();
                if (seleccionado != null) {
                    seleccionado.calcularPoder();//Ejecutamos el metodo
                }
            }
        });

        //Boton copiar guerreros por habilidad
        copiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Seleccion de habilidad a partir de un comboBox
                JComboBox<String> habilidadComboBox = new JComboBox<>(new String[]{"Kamehameha", "Cañon Especial", "Onda Explosiva"});
                int result = JOptionPane.showConfirmDialog(null, habilidadComboBox, "Seleccione la habilidad para copiar", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String habilidad = (String) habilidadComboBox.getSelectedItem();
                    if (habilidad != null && !habilidad.trim().isEmpty()) {
                        c.copiarColaHabilidad(habilidad, txtResultado, txtComparar);//Ejecutamos el metodo copiarColaHabilidad
                    } else {
                        JOptionPane.showMessageDialog(null, "La habilidad no puede estar vacía");
                    }
                }
            }
        });
    }

    //Metodo actualizarComboBox
    private void actualizarComboBox() {
        comboBox1.removeAllItems();
        Nodo actual = c.frente;
        while (actual != null) {
            comboBox1.addItem(actual.guerrero);
            actual = actual.siguiente;
        }
    }


    //MAIN :D
    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaGuerrerosGUI");
        frame.setContentPane(new ColaGuerrerosGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
