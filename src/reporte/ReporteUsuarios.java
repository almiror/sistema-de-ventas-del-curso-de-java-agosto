
package reporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReporteUsuarios {
    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();

    public void reporteUsuarios() {
        String query = "SELECT * FROM usuarios";
        Document document = new Document(PageSize.A4, 24f, 24f, 24f, 24f);
        try {
            FileOutputStream archivo = new FileOutputStream("D:\\ventas/reporteusuarios.pdf");
            PdfWriter.getInstance(document, archivo);
            document.open();
            // FUENTES

            Font fuenteTitulo = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 18, Font.NORMAL,
                    BaseColor.BLACK);

            Font tituloTabla = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 9, Font.NORMAL,
                    BaseColor.BLACK);
            Font fuenteDescripcion = FontFactory.getFont(
                    FontFactory.HELVETICA, 7, Font.NORMAL,
                    BaseColor.BLACK);

            //SALTO DE LINEA
            Paragraph saltoLinea = new Paragraph();
            saltoLinea.add(new Paragraph(Chunk.NEWLINE));

            Paragraph titulo = new Paragraph("REPORTE DE USUARIOS", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);

            document.add(titulo);
            document.add(saltoLinea);

            //DATOS DEL PRODUCTO
            PdfPTable productos = new PdfPTable(4);
            productos.setWidthPercentage(100f);
            float[] medida = {30f, 25f, 25f, 20f};
            productos.setWidths(medida);
            
            PdfPCell descripcionProducto = new PdfPCell(new Phrase("Nombres Apellidos", tituloTabla));
            descripcionProducto.setVerticalAlignment(Element.ALIGN_CENTER);
            descripcionProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell medidaUnidad = new PdfPCell(new Phrase("TIPO DOCUMENTO", tituloTabla));
            medidaUnidad.setVerticalAlignment(Element.ALIGN_CENTER);
            medidaUnidad.setHorizontalAlignment(Element.ALIGN_LEFT);            
            PdfPCell precioventas = new PdfPCell(new Phrase("N° DOCUMENTO", tituloTabla));
            precioventas.setVerticalAlignment(Element.ALIGN_CENTER);
            precioventas.setHorizontalAlignment(Element.ALIGN_LEFT);            
            
            PdfPCell stockproducto = new PdfPCell(new Phrase("TIPO DE USUARIO", tituloTabla));
            stockproducto.setVerticalAlignment(Element.ALIGN_CENTER);
            stockproducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            productos.addCell(descripcionProducto);
            productos.addCell(medidaUnidad);
            productos.addCell(precioventas);
            productos.addCell(stockproducto);
            

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                        PdfPCell nombrecliente = new PdfPCell(new Phrase(rs.getString("nombre") + " "+ rs.getString("apellido"), fuenteDescripcion));
                        nombrecliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        nombrecliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrecliente.setBorder(0);
                        PdfPCell datoCliente = new PdfPCell(new Phrase(rs.getString("tipo_documento"), fuenteDescripcion));
                        datoCliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        datoCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datoCliente.setBorder(0);
                        productos.addCell(nombrecliente);
                        productos.addCell(datoCliente);

                        PdfPCell documentocliente = new PdfPCell(new Phrase(rs.getString("numero_documento"), fuenteDescripcion));
                        documentocliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        documentocliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        documentocliente.setBorder(0);

                        PdfPCell datoDocumentoCliente = new PdfPCell(new Phrase(rs.getString("tipo_usuario"), fuenteDescripcion));
                        datoDocumentoCliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        datoDocumentoCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datoDocumentoCliente.setBorder(0);
                        productos.addCell(documentocliente);
                        productos.addCell(datoDocumentoCliente);
                }
            } catch (Exception e) {
            }
            document.add(productos);
            document.add(saltoLinea);

            document.close();

            File abrirArchivo = new File("D:\\ventas/reporteusuarios.pdf");
            Desktop.getDesktop().open(abrirArchivo);
        } catch (Exception e) {
        }
    }
}
