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

    public InfoContenedor(int id, Hub valencia){
        setContentPane(panelInfo);
        setTitle("Informacion del contenedor");
        setSize(640,420);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        int f=0, c=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<11;j++){
                if(id==valencia.matriz[i][j].id){
                    f=i;
                    c=j;
                }
            }
        }
        mostrar_id.setText(String.valueOf(valencia.matriz[f][c].id));
        mostrar_peso.setText(String.valueOf(valencia.matriz[f][c].peso));
        mostrar_decripcion.setText(valencia.matriz[f][c].descripcion);
        mostrar_origen.setText(valencia.matriz[f][c].origen);
        mostrar_pais.setText(valencia.matriz[f][c].pais);
        if(valencia.matriz[f][c].prioridad == 1) prioridad1.setSelected(true);
        if(valencia.matriz[f][c].prioridad == 2) prioridad2.setSelected(true);
        if(valencia.matriz[f][c].prioridad == 3) prioridad3.setSelected(true);
        aduanasCheck.setSelected(valencia.matriz[f][c].aduana);
    }
}
