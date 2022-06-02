import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;

public class interfazGrafica extends JFrame {


    private JPanel pnl;

    public interfazGrafica(String title) {//constructor
        //ASPECTO + TAMANO
        super(title);//el titulo que voy a poner en el main
        pnl.setPreferredSize(new Dimension(400, 300));//tamano de la ventanita
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnl);
        this.pack();


        //el boton -- cuando lo pulsas
       /* JButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {//manejamos excepciones

                    //guardamos los datos introducidos en variables que declaramos aqui
                    int noUnidades = (int) spinnerUnidades.getValue();
                    double precio = Double.parseDouble(textFieldPrecio.getText());


                    //imprimo en el label el resultado
                    labelPrecioFinal.setText("Precio Final: €" + df.format(precioFinal));

                } catch (NumberFormatException ex) {//si el usuario no introduce bien los datos
                    JOptionPane.showMessageDialog(pnl,//ventana de dialogo
                            "Los datos introducidos no son validos!", // Texto del mensaje
                            "Error", // Título
                            JOptionPane.WARNING_MESSAGE);//Icono
                }
            }
        });*/
    }

        //mi clase principal main
        public static void main(String[] args) {
            JFrame frame = new interfazGrafica("Interfaz Grafica");
            frame.setVisible(true);
        }
}
