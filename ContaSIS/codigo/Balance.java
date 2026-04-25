import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.io.*;

public class Balance {

    ArrayList<Cuenta> cuentasAct = new ArrayList<>();
    ArrayList<Cuenta> cuentasPas = new ArrayList<>();
 
    public void AgCuentaActivos(Cuenta c){ // Este metodo recibe el objeto cuenta = tipo (clase) y c = variable(parametro) en pocas palabras recibe el objeto lo nombra "c" y guarda en el ArrayList
        cuentasAct.add(c); 
    }

    public void AgCuentaPasivos(Cuenta c){ // Lo mismo con este pero recibe los pasivos
        cuentasPas.add(c);
    }

    public void CalcularBalance(){
        double TotActivos=0;

    try{
        FileWriter archivo = new FileWriter("../reportes\\Balance.txt"); // Instancio el metodo writer para crear el archivo y donde se guarda
        PrintWriter escribir = new PrintWriter(archivo); // Instancio el metodo PrintWriter para editar el archivo

        escribir.println("BALANCE GENERAL: ");
        escribir.println("----------------");
        
        for(int i=0; i<cuentasAct.size();i++){
           double Activos = cuentasAct.get(i).getMonto();
           TotActivos = TotActivos+Activos;

           escribir.println(cuentasAct.get(i).getNombre() + ": $" + cuentasAct.get(i).getMonto());// Guardo cuentas en el .txt
        }
        escribir.println("Total Activos: $"+TotActivos); // Guardo su total
        System.out.println("Total Activos: $"+TotActivos);

        escribir.println("----------------"); // inserto linea de separacion en el txt

        double TotPasivos=0;

        for(int i=0; i<cuentasPas.size();i++){
           double Pasivos = cuentasPas.get(i).getMonto();
           TotPasivos = TotPasivos+Pasivos;

           escribir.println(cuentasPas.get(i).getNombre()+": $"+cuentasPas.get(i).getMonto());// Guardo cuentas en el .txt
        }
        System.out.println("Total Pasivos: $"+TotPasivos);
        escribir.println("Total Pasivos: $"+TotPasivos); // Guardo su total

        escribir.println("----------------");

        double Capital;

        Capital = TotActivos-TotPasivos;

        escribir.println("Capital: $"+Capital); // Guardo capital
        escribir.close();

        JTextArea MostrarRes = new JTextArea(); //  Instancio un JArea para mostrar los resultados

        MostrarRes.setText("Total de Activos: $"+TotActivos+"\n"+"Total de Pasivos: $"+TotPasivos+"\n"+"Capital: $"+Capital); // Indicamos lo que quiero mostrar

        JOptionPane.showMessageDialog(null, MostrarRes); // Se muestra

    }catch(Exception e){
        System.out.println("Error de Archivo");
    }
       
    }

}
