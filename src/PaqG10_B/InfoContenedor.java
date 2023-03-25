package PaqG10_B;

import javax.swing.*;

public class InfoContenedor extends JFrame{
    private JPanel panelInfo;
    private JTextField mostrar_id;
    private JTextField mostrar_peso;
    private JTextArea mostrar_decripcion;
    private JTextField mostrar_origen;
    private JTextField mostrar_destino;
    private JTextField mostrar_pais;
    private JRadioButton prioridad1;
    private JRadioButton prioridad2;
    private JRadioButton prioridad3;
    private JCheckBox aduanasCheck;

    public InfoContenedor(int id, Puerto hub){
        setContentPane(panelInfo);
        setTitle("Informacion del contenedor");
        setSize(640,420);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        int f=0, c=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<11;j++){
                if(id==hub.almacen[i][j].getId()){
                    f=i;
                    c=j;
                }
            }
        }
        mostrar_id.setText(String.valueOf(hub.almacen[f][c].getId()));
        mostrar_peso.setText(String.valueOf(hub.almacen[f][c].getPeso()));
        mostrar_decripcion.setText(hub.almacen[f][c].getDescripcion());
        mostrar_origen.setText(hub.almacen[f][c].getOrigen());
        mostrar_destino.setText(hub.almacen[f][c].getDestino());
        mostrar_pais.setText(hub.almacen[f][c].getPais());
        if(hub.almacen[f][c].getPrioridad() == 1) prioridad1.setSelected(true);
        if(hub.almacen[f][c].getPrioridad() == 2) prioridad2.setSelected(true);
        if(hub.almacen[f][c].getPrioridad() == 3) prioridad3.setSelected(true);
        aduanasCheck.setSelected(hub.almacen[f][c].isAduana());
    }
}