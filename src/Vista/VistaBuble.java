/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidad.BubleSort_Min;
import Entidad.Imprimir;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ufps.util.colecciones_seed.Secuencia;

/**
 *
 * @author Sebastian I
 */
public class VistaBuble {

    public static void main(String[] args) {
        Random r = new Random();
        int length = 200000;
        Secuencia<Integer> secuencia = new Secuencia(length);
        Secuencia<Integer> secuencia1 = new Secuencia(length);

        for (int i = 0; i < length; i++) {
            int d = r.nextInt(length);
            secuencia.insertar(d);
            secuencia1.insertar(d);
        }

        BubleSort_Min s = new BubleSort_Min(secuencia, secuencia1);

        try {
            Imprimir i = new Imprimir();

            //Aplicar metodos para consola --> comentar metodos de pdf
            System.out.println("Buble Sort: ");
            s.sort_Buble_Min();
            s.getSecuencia1().toString2();
            
            System.out.println("Burbuja Bidireccional: ");
            s.burbujaBidireccional();
            s.getSecuencia().toString2();

        } catch (Exception ex) {
            Logger.getLogger(VistaBuble.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
