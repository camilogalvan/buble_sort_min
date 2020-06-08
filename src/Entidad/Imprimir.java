/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian I
 */
public class Imprimir {

    public Imprimir() {

    }

    public void generarPDF(String burbuja, String msBuble, String nombre) throws FileNotFoundException, IOException, InterruptedException {

        FileOutputStream f = new FileOutputStream(nombre + ".pdf");
        PdfWriter writer = new PdfWriter(f);
        PdfDocument pdfDoc = new PdfDocument(writer);

        Document document = new Document(pdfDoc, PageSize.A1);
        document.setMargins(50, 30, 20, 30);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont font1 = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

        try {
            document.add(new Paragraph("Juan Sebastian Sanchez Prada - 1151771").setFont(font1));
            document.add(new Paragraph("Juan Sebastian Amaya Ovalle - 1151772").setFont(font1));
            document.add(new Paragraph("Brayan Camilo Galvan Julio - 1151776").setFont(font1));

            Table table = new Table(2);
            proceso(table, font, document, burbuja, msBuble);

            document.close();

        } catch (Exception ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void abrirPDF(String nombre) throws IOException {

        int respuesta = JOptionPane.showConfirmDialog(null, "Desea Imprimir PDF",
                "Sopa de letras", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            File f = new File(nombre + ".pdf");
            Desktop.getDesktop().open(f);
        } else {
            JOptionPane.showMessageDialog(null, "No se abrirá el PDF");
        }
    }

    private void proceso(Table tabla, PdfFont font, Document document,
            String burbuja, String msBuble) {

        String datosBurbujaBi[] = burbuja.split(";"), datosBubleSort[] = msBuble.split(";");
        int length = datosBurbujaBi.length > datosBubleSort.length ? datosBurbujaBi.length : datosBubleSort.length;
        int iBurbuja = 0, iBuble = 0;
        String ultBurbuja = datosBurbujaBi[0], ultBuble = datosBubleSort[0];
        String tieCant1[] = burbuja.split("/");
        String tieCant2[] = msBuble.split("/");
        datosBurbujaBi[datosBurbujaBi.length - 1] = "";
        datosBubleSort[datosBubleSort.length - 1] = "";
        tabla = new Table(2);
        tabla.addHeaderCell("Burbuja Bidireccional").setBackgroundColor(Color.LIGHT_GRAY);
        tabla.addHeaderCell("Buble Sort").setBackgroundColor(Color.LIGHT_GRAY);

        document.add(tabla);
        tabla.setWidthPercent(90);
        tabla = new Table(2);

        for (int j = 0; j < (length); j += 2, iBurbuja++, iBuble++) {
            condicionesUso(j, datosBurbujaBi, datosBubleSort, ultBurbuja, ultBuble,
                    iBurbuja, iBuble, tabla, font);
        }
        cargarTablas(tabla, document, tieCant1, tieCant2);
    }

    private void condicionesUso(int j, String datosBurbujaBi[], String datosBubleSort[],
            String ultBurbuja, String ultBuble, int iBurbuja, int iBuble, Table tabla, PdfFont font) {

        if (j - 1 < (datosBurbujaBi.length)) {
            ultBurbuja = "Iteración " + (iBurbuja + 1) + ": " + datosBurbujaBi[j];
        } else {
            ultBurbuja = " ";
        }
        if (j - 1 < (datosBubleSort.length)) {
            ultBuble = "Iteración " + (iBuble + 1) + ": " + datosBubleSort[j];
        } else {
            ultBuble = "";
        }
        tabla.addCell(String.valueOf(ultBurbuja)).setFont(font).setBackgroundColor(Color.YELLOW);
        tabla.addCell(String.valueOf(ultBuble)).setFont(font).setBackgroundColor(Color.YELLOW);
    }

    private void cargarTablas(Table tabla, Document document, String tieCant1[], String tieCant2[]) {
        document.add(tabla);
        tabla.setWidthPercent(90);

        tabla = new Table(2);

        tabla.addFooterCell("Tiempo ejecuciòn: " + tieCant1[1] + "milisegundos\n"
                + "Cantidad de iteraciones: " + tieCant1[2]).setBackgroundColor(Color.LIGHT_GRAY);
        tabla.addFooterCell("Tiempo ejecuciòn: " + tieCant2[1] + "\n"
                + "Cantidad de iteraciones: " + tieCant2[2]).setBackgroundColor(Color.LIGHT_GRAY);
        document.add(tabla);
        tabla.setWidthPercent(90);
    }
}
