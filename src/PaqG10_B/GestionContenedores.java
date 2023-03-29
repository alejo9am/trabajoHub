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
    private JTextArea estadoHub1;
    private JTextArea estadoHub2;
    private JTextArea estadoHub3;

    public GestionContenedores(){
        setContentPane(panelPrincipal);
        setTitle("Gestion de contenedores");
        setSize(1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Puerto almacen1 = new Puerto();
        Puerto almacen2 = new Puerto();
        Puerto almacen3 = new Puerto();
        estadoHub1.setText(almacen1.toString());
        estadoHub2.setText(almacen2.toString());
        estadoHub3.setText(almacen3.toString());

        MostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoContenedor panelInfo = new InfoContenedor(Integer.parseInt(id_mostrar.getText()),almacen1);
            }
        });

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor c_apilar = new Contenedor();

                c_apilar.setId(Integer.parseInt(id_field.getText()));
                c_apilar.setPeso(Integer.parseInt(peso_field.getText()));
                c_apilar.setPais((String) pais_selector.getSelectedItem());
                c_apilar.setAduana(aduanas_bool.isSelected());
                if (prioridad1.isSelected()) c_apilar.setPrioridad(1);
                if (prioridad2.isSelected()) c_apilar.setPrioridad(2);
                if (prioridad3.isSelected()) c_apilar.setPrioridad(3);
                c_apilar.setDescripcion(descripcion_field.getText());
                c_apilar.setOrigen(origen_field.getText());
                c_apilar.setDestino(destino_field.getText());

                boolean apilado = false;
                apilado = almacen1.apilar(c_apilar, almacen1);  //si intenta apilar en Hub 1
                if(!apilado){ //se cumple si no se apila en Hub 1
                    apilado = almacen2.apilar(c_apilar, almacen2);  //se intenta apilar en Hub 2
                    if(!apilado){ //se cumple si no se apila en Hub 2
                        apilado = almacen3.apilar(c_apilar, almacen3); //se intenta pilar en Hub 3
                        if(!apilado){ //muestra la ventana si no se consigue apilar
                            VentanaError errorLleno = new VentanaError("No queda espacio en los almacenes para esa prioridad");
                        }
                    }
                }


            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int col = Integer.parseInt(String.valueOf(columna_desapilar))-1;
                almacen1.desapilar(col, almacen1);
                estadoHub1.setText(almacen1.toString());
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

                estadoHub1.setText(almacen1.toString());
            }
        });
    }

    private void actualizar(Puerto alm1, Puerto alm2, Puerto alm3){
        id_field.setText("");
        peso_field.setText("");
        destino_field.setText("");
        descripcion_field.setText("");
        origen_field.setText("");
        pais_selector.setSelectedIndex(0);
        aduanas_bool.setSelected(false);
        columna_desapilar.setText("");
        id_mostrar.setText("");
        mostrar_nPaises.setText("");

        estadoHub1.setText(alm1.toString());
        estadoHub2.setText(alm2.toString());
        estadoHub3.setText(alm3.toString());
    }

    public static void main(String[] args) {
        GestionContenedores panel = new GestionContenedores();
    }
}
