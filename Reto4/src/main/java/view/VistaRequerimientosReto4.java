package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LiderCiudad;
import model.vo.SumaProveedor;
import model.vo.ProyectoCiudad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder; 

public class VistaRequerimientosReto4 extends JFrame{

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(80,50,800,630);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5");
        lbltitulo.setBounds(28,6,61,16);
        contentPane.add(lbltitulo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28,70,737,455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Consulta 1");
        btnConsulta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento1();
            }
        });
        btnConsulta1.setBounds(28, 537, 117, 29);
        contentPane.add(btnConsulta1);

        JButton btnConsulta3 = new JButton("Consulta 3");
        btnConsulta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento3();
            }
        });
        btnConsulta3.setBounds(157, 537, 117, 29);
        contentPane.add(btnConsulta3);

        JButton btnConsulta4 = new JButton("Consulta 4");
        btnConsulta4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                requerimiento4();
            }
        });
        btnConsulta4.setBounds(286, 537, 117, 29);
        contentPane.add(btnConsulta4); 

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText("");;
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);
    }

    public static void requerimiento1() {

        System.out.println("-----Proyecto Ciudad-------");

        try {

            ArrayList<ProyectoCiudad> rankingProyectoCiudad = controlador.consultarProyectoCiudad();

            // Encabezado del resultado
            String salida = "Constructora \t Fecha_Inicio \t Clasificación \n";

            // Cada VO cargado, mostrarlo en la vista
            for (ProyectoCiudad proyectoCiudad : rankingProyectoCiudad) {
                salida += proyectoCiudad.getConstructora();
                salida += "\t";
                salida += proyectoCiudad.getFechaInicio();
                salida += "\t";
                salida += proyectoCiudad.getClasificacion();
                salida += "\n";
            }
            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento3() {

        String salida = "-----Suma Cantidades------- \n";

        try {

            ArrayList<SumaProveedor> rankingSumaProveedor = controlador.consultarSumaProveedor();

            // Encabezado del resultado
            salida += "Suma Cantidades: ";

            // Cada VO cargado, mostrarlo en la vista
            for (SumaProveedor suma : rankingSumaProveedor) {
                salida += suma.getCantidad();
            }
            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void requerimiento4() {

        String salida = "-----Líder Ciudad-------\n";

        try {

            ArrayList<LiderCiudad> rankingLiderCiudad = controlador.consultarLiderCiudad();

            // Encabezado del resultado
            salida += "Nombre Líder: \n";

            // Cada VO cargado, mostrarlo en la vista
            for (LiderCiudad lider : rankingLiderCiudad) {
                salida += lider.getNombreLider();
                salida += "\n";
            }
            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

}
