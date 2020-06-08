/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import ufps.util.colecciones_seed.Secuencia;

/**
 *
 * @author Sebastian I
 */
public class BubleSort_Min<T> {

    private Secuencia<T> secuencia;
    private Secuencia<T> secuencia1;

    public BubleSort_Min() {
    }

    public BubleSort_Min(Secuencia<T> secuencia, Secuencia<T> secuencia1) {
        this.secuencia = secuencia;
        this.secuencia1 = secuencia1;
    }

    public void burbujaBidireccional() throws Exception {
        long inicio = System.currentTimeMillis();
        long contador = 0;
        int limiteDer = secuencia1.getTamanio() - 1;
        int j = 0;

        for (int i = 0; i <= limiteDer;) {
            contador++;
            if (j < limiteDer) {
                while (j < limiteDer) {
                    contador++;
                    compararBurbuja(j, 1, 0);
                    j++;
                }
                limiteDer--;
            } else {
                while (j > i) {
                    contador++;
                    compararBurbuja(j, -1, 1);
                    j--;
                }
                i++;
            }

        }
        long fin = System.currentTimeMillis();
        tiempoEjecucion(inicio, fin, contador);
    }

    public void sort_Buble_Min() {
        int tam = secuencia.getTamanio();
        long contador = 0;
        long inicio = System.currentTimeMillis();

        contador += BubleSort_Fase1(tam);

        int s = 0;
        for (int p = 0; p < (tam / 2) - 1; p++) {
            contador++;
            for (int j = 0; j < tam / 2; j++) {
                contador++;
                s = comparar(j, tam, s);
            }
            if (s == 0) {
                break;
            }
            s = 0;
        }
        long fin = System.currentTimeMillis();
        tiempoEjecucion(inicio, fin, contador);
    }

    private int BubleSort_Fase1(int tam) {
        int contador = 0;
        for (int i = 0; i < (tam / 2); i++) {
            int comparar = (((Comparable) (secuencia.get(i))).compareTo(secuencia.get(tam - (1 + i))));
            if (comparar > 0) {
                intercambio(i, tam - (i + 1));
            }
            contador++;
        }
        return contador;
    }

    private int comparar(int j, int tam, int s) {
        int comparar = (((Comparable) (secuencia.get(j))).compareTo(secuencia.get(j + 1)));
        if (comparar > 0) {
            intercambio(j, (j + 1));
            s = 1;
        }
        comparar = (((Comparable) (secuencia.get(tam - (j + 1)))).compareTo(secuencia.get(tam - (j + 2))));
        if (comparar < 0) {
            intercambio(tam - (j + 1), tam - (j + 2));
            s = 1;
        }
        return s;
    }

    private void compararBurbuja(int j, int valor, int condicion) {
        int c = ((Comparable) (secuencia1.get(j))).compareTo(secuencia1.get(j + valor));
        if (condicion == 0) {
            if (c > 0) {
                this.cambiarPos(valor, j);
            }
        } else {
            if (c < 0) {
                this.cambiarPos(valor, j);
            }
        }
    }

    private void tiempoEjecucion(long inicio, long fin, long contador) {
        System.out.println("Número de iteraciones: " + contador);
        double tiempo = ((fin - inicio));
        System.out.println(tiempo + " milisegundos.");
    }

    private void intercambio(int i, int j) {
        T aux;
        aux = secuencia.get(i);
        secuencia.set(i, secuencia.get(j));
        secuencia.set(j, aux);
    }

    //sortBublePDf
    public String sort_Buble_MinPdf() {
        int n = secuencia.getTamanio();
        long inicio = System.currentTimeMillis();
        long contador = 0;
        String msg = "";

        for (int i = 0; i < (n / 2); i++) {
            contador++;
            int comparar = (((Comparable) (secuencia.get(i))).compareTo(secuencia.get(n - (1 + i))));
            msg += this.secuencia.toString1() + "; : ;";
            if (comparar > 0) {
                intercambio(i, n - (i + 1));
            }
        }
        int s = 0;
        for (int p = 0; p < (n / 2) - 1; p++) {
            contador++;
            msg += this.secuencia.toString1() + "; : ;";
            for (int j = 0; j < n / 2; j++) {
                contador++;
                int comparar = (((Comparable) (secuencia.get(j))).compareTo(secuencia.get(j + 1)));
                if (comparar > 0) {
                    intercambio(j, (j + 1));
                    s = 1;
                }
                msg += this.secuencia.toString1() + "; : ;";
                comparar = (((Comparable) (secuencia.get(n - (j + 1)))).compareTo(secuencia.get(n - (j + 2))));
                if (comparar < 0) {
                    intercambio(n - (j + 1), n - (j + 2));
                    s = 1;
                }
            }
            if (s == 0) {
                break;
            }
            s = 0;
        }

        long fin = System.currentTimeMillis();
        double tiempo = (fin - inicio);
        msg += "/" + tiempo + "/" + contador;
        return msg;
    }

    //burbujaBidireccional
    public String burbujaBidireccionalPdf() throws Exception {
        String msg = "";
        long inicio = System.currentTimeMillis();
        long contador = 0;
        int limiteDer = secuencia1.getTamanio() - 1;
        int j = 0;

        for (int i = 0; i <= limiteDer;) {
            contador++;
            msg += this.secuencia1.toString1() + "; : ;";
            if (j < limiteDer) {
                while (j < limiteDer) {
                    contador++;
                    msg += compararPasoAPaso(j, 1, 0);
                    msg += this.secuencia1.toString1() + "; : ;";
                    j++;
                }
                limiteDer--;
            } else {
                while (j > i) {
                    contador++;
                    msg += compararPasoAPaso(j, -1, 1);
                    msg += this.secuencia1.toString1() + "; : ;";
                    j--;
                }
                i++;
            }

        }
        long fin = System.currentTimeMillis();
        double tiempo = (fin - inicio);
        msg += "/" + tiempo + "/" + contador;
        return msg;
    }

    private String compararPasoAPaso(int j, int valor, int condicion) {
        String rt = "";
        int c = ((Comparable) (secuencia1.get(j))).compareTo(secuencia1.get(j + valor));
        if (condicion == 0) {
            if (c > 0) {
                this.cambiarPos(valor, j);
            }
        } else {
            if (c < 0) {
                this.cambiarPos(valor, j);
            }
        }

        return rt;
    }

    private void cambiarPos(int x, int i) {
        T aux;
        aux = secuencia1.get(i);
        secuencia1.set(i, secuencia1.get(i + x));
        secuencia1.set(i + x, aux);
    }

    public Secuencia<T> getSecuencia() {
        return this.secuencia;
    }

    public Secuencia<T> getSecuencia1() {
        return secuencia1;
    }

    public void setSecuencia(Secuencia<T> secuencia) {
        this.secuencia = secuencia;
    }

    public void setSecuencia1(Secuencia<T> secuencia1) {
        this.secuencia1 = secuencia1;
    }

}
