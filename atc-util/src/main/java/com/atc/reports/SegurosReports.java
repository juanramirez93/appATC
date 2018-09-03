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
import java.util.HashMap;
import java.util.Map;

public class SegurosReports {

	private String ruta = Session.INSTANCE.getPathFolderDocs();

	public void reporteReintegroRCE(Empleado empleado, int mes, int anio) throws JRException {

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("Empleado", empleado.getId());
		parametros.put("Titulo", StringsConstants.TITULO_REINEGRO_RCE);
		parametros.put("mesReporte", mes);
		parametros.put("anioReporte", anio);
		parametros.put("mesString", StringsConstants.getMonth(mes));

		String file = ruta + "\\Reportes\\MyReports\\REINT_RCE.jrxml";

		File fichero = new File(file);
		if (fichero.exists()) {

			JasperReport report = JasperCompileManager.compileReport(file);

			JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());

			JasperViewer.viewReport(print, false);

		} else {
			System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
		}

//		JasperExportManager.exportReportToPdfFile(pr, ruta + "ReintRce" + empleado.getAbreviatura() + mes + "-" + anio);

	}

	public void reporteRCE(int mes, int anio) throws JRException {

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("mesReporte", mes);
		parametros.put("anioReporte", anio);
		parametros.put("mesString", StringsConstants.getMonth(mes));

		String file = ruta + "\\Reportes\\MyReports\\REP_RCE.jrxml";

		File fichero = new File(file);

		if (fichero.exists()) {

			JasperReport report = JasperCompileManager.compileReport(file);

			JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());

			JasperViewer.viewReport(print, false);

		} else {
			System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
		}
	}

	public void reporteTRANSPORTE(int mes, int anio) throws JRException {

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("mesReporte", mes);
		parametros.put("anioReporte", anio);
		parametros.put("mesString", StringsConstants.getMonth(mes));

		String file = ruta + "\\Reportes\\MyReports\\REP_TRANSPORTE.jrxml";

		File fichero = new File(file);

		if (fichero.exists()) {

			JasperReport report = JasperCompileManager.compileReport(file);

			JasperPrint print = JasperFillManager.fillReport(report, parametros, conectar());

			JasperViewer.viewReport(print, false);

		} else {
			System.out.println(fichero.getAbsolutePath() + " No existe el archivo");
		}

//		JasperExportManager.exportReportToPdfFile(pr, ruta + "ReintRce" + empleado.getAbreviatura() + mes + "-" + anio);

	}

	public Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.10.75:3306/atc?serverTimezone=UTC", "atc",
					"Metallica.91");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
}
