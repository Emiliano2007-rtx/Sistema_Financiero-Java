import java.util.*;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Balance Bal = new Balance(); // Instancio la clase Balance para llamar los metodos que ocupe
        
        int opc;

        do{

            String ops [] = {"Balance General","Estado de Resultados","Salir"};

            opc = JOptionPane.showOptionDialog(null, "Seleccione la Operacion a Realizar:", "Menu:", 0, 1, null, ops, sc);

            switch (opc) {
                case 0:

                    String TipoC [] = {"Activo","Pasivo"}; 

                    int tipo=0;
                    String tipoStr="";
                    String nom="";
                    String MontStr="";
                    double mont=0;
                    int conti=0;

                    while (conti!=1) {
                        
                        tipo = JOptionPane.showOptionDialog(null, "Seleccione el Tipo de Cuenta", "Tipo de Cuenta", 0, 1, null, TipoC, sc); 
                        // Este metodo solo devuelve 0 y 1 dependiendo de la opcion elegida (0 es activo y 1 es pasivo)

                        nom = JOptionPane.showInputDialog(null,"Ingrese el Nombre de la Cuenta:","Cuenta:",1);

                        MontStr = JOptionPane.showInputDialog(null,"Ingrese el Monto de la Cuenta:","Monto:",1);

                    try {
                        Double.parseDouble(nom);
                        JOptionPane.showMessageDialog(null, "Error: Caracteres No validos (Solo letras)");
                    } catch (Exception e) {

                    try {
                        mont = Double.parseDouble(MontStr); // convertimos a double
                        tipoStr = TipoC[tipo]; // Guarda el texto de la posicion que devuelva (tipo) 

                        Cuenta c = new Cuenta(tipoStr,nom,mont); // Instancio el constuctor

                        if(tipo==0){
                            Bal.AgCuentaActivos(c); // Accedo al metodo AgCuentaActivos() de la clase Balance para enviar el objeto
                        }
                        else{
                            Bal.AgCuentaPasivos(c);
                        }

                        String SiNo [] = {"Si","No"};

                        conti = JOptionPane.showOptionDialog(null, "Agregar Otra Cuenta?:", "Cuenta", 0, 1, null, SiNo, sc);
                        // Preguntamos si quiere agregar otra cuenta
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, "Error: Caracteres No validos (Solo Numeros)");
                    }

                    }

                }

                Bal.CalcularBalance();
                break;

                case 1:
                    // En Desarrollo 
                    //Estado de Resultados Proximamente
                break;
            }
            
        }while(opc!=2);


    }
}
