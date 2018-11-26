package com.atc.reports;

import com.atc.connection.Session;
import com.atc.model.Empleado;
import com.atc.util.StringsConstants;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum Reintegros {
    INSTANCE;

    private String ruta = Session.INSTANCE.getPathFolderDocs();

    public void reporteReintegroAfiliados(Empleado empleado, Date inicio, Date fin)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINEGRO_AFILIACIONES);
        parametros.put("FechaInicial", inicio);
        parametros.put("FechaFinal", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_AFILIACIONES.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_Afiliaciones.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroVida(Empleado empleado, Date inicio, Date fin) throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINTEGRO_VIDA);
        parametros.put("FechaInicial", inicio);
        parametros.put("FechaFinal", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_VIDA.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_SegurosVida(" + System.currentTimeMillis() + ").pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroVidaFact(Empleado empleado, Date inicio, Date fin)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINTEGRO_VIDA_FACT);
        parametros.put("FechaInicial", inicio);
        parametros.put("FechaFinal", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_VIDA_FACT.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_segurosVidaFact.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
        //		JasperExportManager.exportReportToPdfFile(pr, ruta + "ReintRce" + empleado
        // .getAbreviatura() + mes + "-" +
        // anio);
    }

    public Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://192.168.10.75:3306/atc?serverTimezone=UTC", "atc",
                            "Metallica.91");
        } catch(ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conexion;
    }

    public void cuentaCobro(Empleado empleado, String mes, int valor, String concepto, Date fecha)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("mes", mes.toUpperCase());
        parametros.put("fecha", fecha);
        parametros.put("valor", valor);
        parametros.put("valorStr",
                StringsConstants.numberToLetters(String.valueOf(valor)).toUpperCase());
        parametros.put("concepto", concepto.toUpperCase());
        String file = ruta + "\\Reportes\\MyReports\\CTA_COBRO.jrxml";
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\cta_cobro_" + mes +
                            "_" + concepto + ".pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroRCE(Empleado empleado, Date inicio, Date fin) throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINEGRO_RCE);
        parametros.put("inicio", inicio);
        parametros.put("final", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_RCE.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_segurosRCE.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroTransporte(Empleado empleado, Date inicio, Date fin)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINTEGRO_TRANSPORTE);
        parametros.put("inicio", inicio);
        parametros.put("final", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_TRANSPORTE.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_segurosTRANSPORTE.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroRCEFact(Empleado empleado, Date inicio, Date fin)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINTEGRO_RCE_FACT);
        parametros.put("inicio", inicio);
        parametros.put("final", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_RCE_FACT.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_segurosRCE_FACT.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteReintegroTransporteFact(Empleado empleado, Date inicio, Date fin)
            throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Empleado", empleado.getId());
        parametros.put("Titulo", StringsConstants.TITULO_REINTEGRO_TRANSPORTE_FACT);
        parametros.put("inicio", inicio);
        parametros.put("final", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REINT_TRANSPORTE_FACT.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\" + empleado.getAbreviatura() + "\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_segurosTRANSPORTE_FACT.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }

    public void reporteMovimientoVida(Date inicio, Date fin) throws JRException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Titulo", StringsConstants.TITULO_REPORTE_MOVIMIENTO_VIDA);
        parametros.put("inicio", inicio);
        parametros.put("final", fin);
        parametros.put("logo", ruta + "\\Reportes\\MyReports\\logoCompletoCuadrado.PNG");
        String file = ruta + "\\Reportes\\MyReports\\REPORTE FACT VIDA.jrxml";
        Calendar mes = Calendar.getInstance();
        mes.setTime(inicio);
        File fichero = new File(file);
        if(fichero.exists()) {
            JasperReport report = JasperCompileManager.compileReport(file);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());
            JasperViewer.viewReport(print, false);
            JasperExportManager.exportReportToPdfFile(print,
                    "H:\\atcapp\\Reintegros\\liquidacion_" +
                            StringsConstants.getMonth(mes.get(Calendar.MONTH) + 1) +
                            "_REPORTE_MOV_VIDA.pdf");
        } else {
            System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
        }
    }
}
