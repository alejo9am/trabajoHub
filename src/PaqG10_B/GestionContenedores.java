package PaqG10_B;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionContenedores extends JFrame{
    private JPanel panelPrincipal;
    private JTextField id_field;
    private JTextField peso_field;
    private JTextField origen_field;
    private JTextField destino_field;
    private JComboBox<String> pais_selector;
    private JRadioButton prioridad1;
    private JRadioButton prioridad2;
    private JRadioButton prioridad3;
    private JCheckBox aduanas_bool;
    private JTextArea descripcion_field;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JTextField columna_desapilar;
    private JTextField id_mostrar;
    private JButton MostrarDatosButton;
    private JButton cuant_conten;
    private JComboBox<String> pais_cuantos;
    private JTextField mostrar_nPaises;
    private JLabel logo_empresa;
    private JPanel Operaciones;
    private JTextArea estadoHub;

    public GestionContenedores(){
        setContentPane(panelPrincipal);
        setTitle("Gestion de contenedores");
        setSize(1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Puerto almacen1 = new Puerto();
        Puerto almacen2 = new Puerto();
        Puerto almacen3 = new Puerto();
        estadoHub.setText(almacen1.toString(almacen1));

        MostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoContenedor panelInfo = new InfoContenedor(Integer.parseInt(id_mostrar.getText()),almacen1);
            }
        });

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor apilado = new Contenedor();

                apilado.setId(Integer.parseInt(id_field.getText()));
                apilado.setPeso(Integer.parseInt(peso_field.getText()));
                apilado.setPais((String) pais_selector.getSelectedItem());
                apilado.setAduana(aduanas_bool.isSelected());
                if (prioridad1.isSelected()) apilado.setPrioridad(1);
                if (prioridad2.isSelected()) apilado.setPrioridad(2);
                if (prioridad3.isSelected()) apilado.setPrioridad(3);
                apilado.setDescripcion(descripcion_field.getText());
                apilado.setOrigen(origen_field.getText());
                apilado.setDestino(destino_field.getText());

                if(!almacen1.apilar(apilado, almacen1)){
                    if(!almacen2.apilar(apilado, almacen2)){
                        if(!almacen3.apilar(apilado, almacen3)){
                            VentanaError errorLleno = new VentanaError("No queda espacio en los almacenes para esa prioridad");
                        }
                    }
                }
                estadoHub.setText(almacen1.toString(almacen1));

                id_field.setText("");
                peso_field.setText("");
                destino_field.setText("");
                descripcion_field.setText("");
                origen_field.setText("");
                pais_selector.setSelectedIndex(0);
                aduanas_bool.setSelected(false);
            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int col = Integer.parseInt(String.valueOf(columna_desapilar))-1;
                almacen1.desapilar(col, almacen1);
                estadoHub.setText(almacen1.toString(almacen1));
            }
        });

        cuant_conten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suma=0;
                String Pais = (String) pais_cuantos.getSelectedItem();
                suma = suma + almacen1.cantCont(Pais, almacen1);
                suma = suma + almacen2.cantCont(Pais, almacen2);
                suma = suma + almacen3.cantCont(Pais, almacen3);
                mostrar_nPaises.setText(String.valueOf(suma));

                estadoHub.setText(almacen1.toString(almacen1));
            }
        });
    }

    public static void main(String[] args) {
        GestionContenedores panel = new GestionContenedores();
    }
}
