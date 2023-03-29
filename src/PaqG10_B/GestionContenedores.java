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

    public GestionContenedores(Puerto almacen){
        setContentPane(panelPrincipal);
        setTitle("Gestion de contenedores");
        setSize(1280,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        estadoHub.setText(almacen.toString());

        MostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(id_mostrar.getText());
                boolean existeContenedor = false;
                for(int j=0;j<12;j++){          //el bucle comprueba si existe algun contenedor con el id introducido
                    for(int i=9;i>=0;i--){
                        if(id==almacen.almacen[i][j].getId()){
                            existeContenedor = true;
                            break;
                        }
                    }
                }
                if (existeContenedor){
                    InfoContenedor panelInfo = new InfoContenedor(id,almacen);
                    actualizar(almacen);
                }
                if(!existeContenedor){
                    VentanaError noExiste = new VentanaError("No existe ningún contenedor con ese id");
                    actualizar(almacen);
                }
            }
        });

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contenedor c_apilar = new Contenedor();
                int id_apilar = Integer.parseInt(id_field.getText());
                boolean id_repetido=false;

                for(int j=0;j<12;j++){
                    for(int i=9;i>=0;i--){
                        if(id_apilar==almacen.almacen[i][j].getId()){
                            id_repetido=true;
                            break;
                        }
                    }
                }
                if(id_repetido){
                    VentanaError errorRepetido = new VentanaError("Ya hay un contenedor con ese identificador");
                    actualizar(almacen);
                }
                if(!id_repetido) {
                    c_apilar.setId(id_apilar);
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
                    apilado = almacen.apilar(c_apilar);  //se intenta apilar en el almacen
                    if (!apilado) { //la condicion se cumple si no se consigue apilar
                        VentanaError errorLleno = new VentanaError("No queda espacio en el almacén para esa prioridad");
                    }

                    actualizar(almacen);
                }
            }
        });

        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int col = Integer.parseInt(columna_desapilar.getText())-1;
                if(!almacen.desapilar(col)){
                    VentanaError colVacia = new VentanaError("La columna no tiene contenedores");
                }
                else actualizar(almacen);
            }
        });

        cuant_conten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suma=0;
                String Pais = (String) pais_cuantos.getSelectedItem();
                suma = almacen.cantCont(Pais);
                mostrar_nPaises.setText(String.valueOf(suma));
            }
        });
    }

    private void actualizar(Puerto alm){
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

        estadoHub.setText(alm.toString());
    }

    public static void main(String[] args) {
        Puerto almacen = new Puerto(); //Creamos el almacen con el que se va a trabajar
        GestionContenedores panel = new GestionContenedores(almacen);  //se abre el panel de gestion con el almacen creado
    }
}
