package PaqG10_B;

import javax.swing.*;

public class VentanaError extends JFrame{
    private JPanel panelError;
    private JLabel errorLabel;

    public VentanaError(String error){
        setContentPane(panelError);
        setTitle("Informacion del contenedor");
        setSize(420,210);
        setLocationRelativeTo(null);
        setVisible(true);
        errorLabel.setText(error);
    }
}
