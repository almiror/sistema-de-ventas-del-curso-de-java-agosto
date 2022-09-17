package reporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
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

public class Ticket80MM {

    private Conexion conectando = new Conexion();
    private Connection cn = conectando.conexion();

    public void ticket(String idVenta) {
        String query = "SELECT v.numero_comprante,v.total,v.subtotal,v.itbis,v.fecha_emision, "
                + "dv.cantidad,dv.total,dv.subtotal,dv.itbis, c.nombre, c.numero_documento, "
                + "p.descripcion,p.unidad_medida,p.precio_venta "
                + "FROM ventas v "
                + "INNER JOIN detalle_ventas dv ON "
                + "dv.idventa = v.id "
                + "INNER JOIN comprobantes cv ON "
                + "cv.id = v.idcomprobante "
                + "INNER JOIN clientes c ON "
                + "c.id = v.idcliente "
                + "INNER JOIN productos p ON "
                + "p.id  = dv.idproducto "
                + "WHERE v.id = " + idVenta;
        Rectangle r = new Rectangle(210, 400);
        Document document = new Document(r, 9f, 9f, 7f, 7f);
        try {
            FileOutputStream archivo = new FileOutputStream("D:\\ventas/TICKET.pdf");
            PdfWriter.getInstance(document, archivo);
            document.open();
            // FUENTES

            Font fuenteTitulo = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD, 8, Font.NORMAL,
                    BaseColor.BLACK);

            Font fuenteDescripcion = FontFactory.getFont(
                    FontFactory.HELVETICA, 7, Font.NORMAL,
                    BaseColor.BLACK);

            //SALTO DE LINEA
            Paragraph saltoLinea = new Paragraph();
            saltoLinea.add(new Paragraph(Chunk.NEWLINE));

            PdfPTable encabesadoTicket = new PdfPTable(1);
            encabesadoTicket.setWidthPercentage(100);
            float[] medidaCelda = {100f};
            encabesadoTicket.setWidths(medidaCelda);

            PdfPCell empresa = new PdfPCell(new Phrase("EMPRESA DEMO", fuenteTitulo));
            empresa.setVerticalAlignment(Element.ALIGN_CENTER);
            empresa.setHorizontalAlignment(Element.ALIGN_CENTER);
            empresa.setBorder(0);
            PdfPCell direccion = new PdfPCell(new Phrase("LIMA PERU", fuenteDescripcion));
            direccion.setVerticalAlignment(Element.ALIGN_CENTER);
            direccion.setHorizontalAlignment(Element.ALIGN_CENTER);
            direccion.setBorder(0);
            PdfPCell rnc = new PdfPCell(new Phrase("RNC: 676163464", fuenteDescripcion));
            rnc.setVerticalAlignment(Element.ALIGN_CENTER);
            rnc.setHorizontalAlignment(Element.ALIGN_CENTER);
            rnc.setBorder(0);
            encabesadoTicket.addCell(empresa);
            encabesadoTicket.addCell(direccion);
            encabesadoTicket.addCell(rnc);
            document.add(encabesadoTicket);
            document.add(saltoLinea);

            //DATOS DEL CLIENTE
            PdfPTable encabesadoCliente = new PdfPTable(2);
            encabesadoCliente.setWidthPercentage(100);
            float[] medidaCeldaCliente = {35f, 65f};
            encabesadoCliente.setWidths(medidaCeldaCliente);

            try {
                int contador = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    contador++;
                    if (contador <= 1) {
                        PdfPCell nombrecliente = new PdfPCell(new Phrase("Cliente", fuenteTitulo));
                        nombrecliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        nombrecliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        nombrecliente.setBorder(0);
                        PdfPCell datoCliente = new PdfPCell(new Phrase(rs.getString("c.nombre"), fuenteDescripcion));
                        datoCliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        datoCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datoCliente.setBorder(0);
                        encabesadoCliente.addCell(nombrecliente);
                        encabesadoCliente.addCell(datoCliente);

                        PdfPCell documentocliente = new PdfPCell(new Phrase("Documento", fuenteTitulo));
                        documentocliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        documentocliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        documentocliente.setBorder(0);

                        PdfPCell datoDocumentoCliente = new PdfPCell(new Phrase(rs.getString("c.numero_documento"), fuenteDescripcion));
                        datoDocumentoCliente.setVerticalAlignment(Element.ALIGN_CENTER);
                        datoDocumentoCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
                        datoDocumentoCliente.setBorder(0);
                        encabesadoCliente.addCell(documentocliente);
                        encabesadoCliente.addCell(datoDocumentoCliente);
                    }
                }
            } catch (Exception e) {
            }
            document.add(encabesadoCliente);
            document.add(saltoLinea);

            //DATOS DEL DETALLE DE LA VENTAS
            PdfPTable ventas = new PdfPTable(5);
            ventas.setWidthPercentage(100);
            float[] medidaCeldaVentas = {15f, 20f, 15f, 15f, 15f};
            ventas.setWidths(medidaCeldaVentas);

            PdfPCell cantidad = new PdfPCell(new Phrase("Cant", fuenteTitulo));
            cantidad.setVerticalAlignment(Element.ALIGN_CENTER);
            cantidad.setHorizontalAlignment(Element.ALIGN_LEFT);
            cantidad.setBorder(0);
            PdfPCell medida = new PdfPCell(new Phrase("UM", fuenteTitulo));
            medida.setVerticalAlignment(Element.ALIGN_CENTER);
            medida.setHorizontalAlignment(Element.ALIGN_LEFT);
            medida.setBorder(0);
            PdfPCell precio = new PdfPCell(new Phrase("PRECIO", fuenteTitulo));
            precio.setVerticalAlignment(Element.ALIGN_CENTER);
            precio.setHorizontalAlignment(Element.ALIGN_LEFT);
            precio.setBorder(0);

            PdfPCell itbis = new PdfPCell(new Phrase("ITBIS", fuenteTitulo));
            itbis.setVerticalAlignment(Element.ALIGN_CENTER);
            itbis.setHorizontalAlignment(Element.ALIGN_LEFT);
            itbis.setBorder(0);

            PdfPCell total = new PdfPCell(new Phrase("TOTAL", fuenteTitulo));
            total.setVerticalAlignment(Element.ALIGN_CENTER);
            total.setHorizontalAlignment(Element.ALIGN_LEFT);
            total.setBorder(0);

            ventas.addCell(cantidad);
            ventas.addCell(medida);
            ventas.addCell(precio);
            ventas.addCell(itbis);
            ventas.addCell(total);

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    PdfPCell cantidadDato = new PdfPCell(new Phrase(rs.getString("dv.cantidad"), fuenteDescripcion));
                    cantidadDato.setVerticalAlignment(Element.ALIGN_CENTER);
                    cantidadDato.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cantidadDato.setBorder(0);
                    PdfPCell medidaDato = new PdfPCell(new Phrase(rs.getString("p.unidad_medida"), fuenteDescripcion));
                    medidaDato.setVerticalAlignment(Element.ALIGN_CENTER);
                    medidaDato.setHorizontalAlignment(Element.ALIGN_LEFT);
                    medidaDato.setBorder(0);
                    PdfPCell precioDato = new PdfPCell(new Phrase(rs.getString("dv.subtotal"), fuenteDescripcion));
                    precioDato.setVerticalAlignment(Element.ALIGN_CENTER);
                    precioDato.setHorizontalAlignment(Element.ALIGN_LEFT);
                    precioDato.setBorder(0);

                    PdfPCell itbisDato = new PdfPCell(new Phrase(rs.getString("dv.itbis"), fuenteDescripcion));
                    itbisDato.setVerticalAlignment(Element.ALIGN_CENTER);
                    itbisDato.setHorizontalAlignment(Element.ALIGN_LEFT);
                    itbisDato.setBorder(0);

                    PdfPCell totalDato = new PdfPCell(new Phrase(rs.getString("dv.total"), fuenteDescripcion));
                    totalDato.setVerticalAlignment(Element.ALIGN_CENTER);
                    totalDato.setHorizontalAlignment(Element.ALIGN_LEFT);
                    totalDato.setBorder(0);
                    
                    PdfPCell descripcionproducto = new PdfPCell(new Phrase(rs.getString("p.descripcion"), fuenteDescripcion));
                    descripcionproducto.setVerticalAlignment(Element.ALIGN_CENTER);
                    descripcionproducto.setHorizontalAlignment(Element.ALIGN_LEFT);
                    descripcionproducto.setBorder(0);
                    descripcionproducto.setColspan(5);

                    ventas.addCell(cantidadDato);
                    ventas.addCell(medidaDato);
                    ventas.addCell(precioDato);
                    ventas.addCell(itbisDato);
                    ventas.addCell(totalDato);
                    ventas.addCell(descripcionproducto);
                }
            } catch (Exception e) {
            }

            document.add(ventas);
            //DATOS PIE DE PAGINA DEL COMPROBANTE
            PdfPTable footer = new PdfPTable(2);
            footer.setWidthPercentage(100);
            float[] medidaCeldaFooter = {70f, 30f};
            footer.setWidths(medidaCeldaFooter);
            try {
                int contador = 0;
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    contador++;
                    if (contador <= 1) {
                        PdfPCell subTotal = new PdfPCell(new Phrase("SUBTOTAL", fuenteTitulo));
                        subTotal.setVerticalAlignment(Element.ALIGN_CENTER);
                        subTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        subTotal.setBorder(0);
                        PdfPCell subTotalDato = new PdfPCell(new Phrase(rs.getString("v.subtotal"), fuenteTitulo));
                        subTotalDato.setVerticalAlignment(Element.ALIGN_CENTER);
                        subTotalDato.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        subTotalDato.setBorder(0);

                        PdfPCell Itbis = new PdfPCell(new Phrase("ITBIS", fuenteTitulo));
                        Itbis.setVerticalAlignment(Element.ALIGN_CENTER);
                        Itbis.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        Itbis.setBorder(0);

                        PdfPCell itbisDato = new PdfPCell(new Phrase(rs.getString("v.itbis"), fuenteTitulo));
                        itbisDato.setVerticalAlignment(Element.ALIGN_CENTER);
                        itbisDato.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        itbisDato.setBorder(0);

                        PdfPCell totalventas = new PdfPCell(new Phrase("Total", fuenteTitulo));
                        totalventas.setVerticalAlignment(Element.ALIGN_CENTER);
                        totalventas.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalventas.setBorder(0);
                        PdfPCell totalventasDato = new PdfPCell(new Phrase(rs.getString("v.total"), fuenteTitulo));
                        totalventasDato.setVerticalAlignment(Element.ALIGN_CENTER);
                        totalventasDato.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        totalventasDato.setBorder(0);

                        footer.addCell(subTotal);
                        footer.addCell(subTotalDato);
                        footer.addCell(Itbis);
                        footer.addCell(itbisDato);
                        footer.addCell(totalventas);
                        footer.addCell(totalventasDato);
                    }
                }
            } catch (Exception e) {
            }
            document.add(saltoLinea);
            document.add(footer);

            document.close();
            
            File abrirArchivo = new File("D:\\ventas/TICKET.pdf");
            Desktop.getDesktop().open(abrirArchivo);
        } catch (Exception e) {
        }
    }

}
