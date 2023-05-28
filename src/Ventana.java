import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JTextField txtCedulaReg;
    private JTextField txtNombreReg;
    private JTextField txtSueldoReg;
    private JButton btnRegistro;
    private JTextField txtCedulaMod;
    private JTextField txtNombreMod;
    private JTextField txtSueldoMod;
    private JButton btnModificar;
    private JButton btnLista;
    private JTextArea txtLista;
    private JButton btnCalculos;
    private JTextArea txtCalculos;

    Lista listado=new Lista();
public Ventana() {
    btnRegistro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int cedula =Integer.parseInt(txtCedulaReg.getText());
            String nombre =txtNombreReg.getText();
            double sueldo = Double.parseDouble(txtSueldoReg.getText());
            Empleado em =new Empleado(cedula,nombre,sueldo);
            if (listado.empleadoExistente(cedula)==true){
                JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese numero de cedula");
            }else {
                listado.agregar(em);
                JOptionPane.showMessageDialog(null, "Empleado registrado correctamente");
            }
        }
    });

    btnLista.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList listadoEmpleado = (listado.mostrarListaEmpleados());
            txtLista.setText(listadoEmpleado.toString());

        }
    });

    btnCalculos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList listadoCaldulo = (listado.mostrarListaCalculos());
            txtCalculos.setText(listadoCaldulo.toString());
        }
    });

    btnModificar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) throws RuntimeException {
            int cedula =Integer.parseInt(txtCedulaMod.getText());
            String nombre =txtNombreMod.getText();
            double sueldo = Double.parseDouble(txtSueldoMod.getText());
            boolean modificar= listado.modificarEmpleado(cedula, nombre, sueldo);
            if (modificar==true){
                JOptionPane.showMessageDialog(null,"Se han guardado los cambios del empleado con cedula: "+cedula);
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
        }
    });
}
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
