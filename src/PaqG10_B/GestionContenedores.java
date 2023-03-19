package PaqG10_B;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.plaf.synth.SynthPopupMenuUI;
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

        Hub Valencia = new Hub();
        estadoHub.setText(Valencia.toString(Valencia));

        MostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoContenedor panelInfo = new InfoContenedor(Integer.parseInt(id_mostrar.getText()),Valencia);
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

                Valencia.apilar(apilado, Valencia);
                estadoHub.setText(Valencia.toString(Valencia));

                id_field.setText("");
                peso_field.setText("");
            }
        });
    }

    public static void main(String[] args) {
        GestionContenedores panel = new GestionContenedores();
    }
}
