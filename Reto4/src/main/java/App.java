import view.VistaRequerimientosReto4;
import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try{
                    VistaRequerimientosReto4 frame = new VistaRequerimientosReto4();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


        /*
        // Casos de prueba
        
        // Requerimiento 1 
        VistaRequerimientosReto4.requerimiento1();
        System.out.println();

        // Requerimiento 3 
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        // Requerimiento 4 
        VistaRequerimientosReto4.requerimiento4();
        System.out.println();*/

}

