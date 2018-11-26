package com.atc.ui;

import com.atc.app.Control;
import com.atc.app.FrameAbstract;
import com.atc.connection.Session;
import com.atc.model.Usuario;
import com.atc.ui.afiliado.MainAfiliado;
import com.atc.ui.documentos.ReintegroGenerator;
import com.atc.ui.empleado.MainEmpleado;
import com.atc.ui.empresa.MainEmpresa;
import com.atc.ui.natural.MainNatural;
import com.atc.ui.seguros.movimiento.MainMovimiento;
import com.atc.ui.seguros.poliza.MainPoliza;
import com.atc.ui.seguros.producto.MainProducto;
import com.atc.ui.seguros.reporte.VerReporte;
import com.atc.ui.seguros.stock.MainStock;
import com.atc.ui.vehiculo.MainVehiculos;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFrame extends FrameAbstract implements ActionListener {

    private static final long serialVersionUID = -2719474495779446718L;
    private JButton personaButton;
    private JButton empresaButton;
    private JButton empleadoButton;

    private JButton polizaButton;
    private JButton productoButton;
    private JButton movimientoButton;
    private JButton reintegroSegurosButton;
    private JButton reporteSegurosButton;

    private JButton afiliacionButton;
    private JButton vehicleButton;

    private JButton cambiarClaveButton;

    private JPanel mainPanel;
    private JPanel headPanel;

    private JPanel bdPanel;
    private JPanel segurosPanel;
    private JPanel afilPanel;

    private JPanel userPanel;
    private JButton stockButton;
    private JPanel footPanel;

    private AdminPanel adminPanel;
    protected Usuario userSession;

    private AfiliacionesPanel afiliacionesPanel;

    public static final int LISTADO = 3;
    public static final int DETALLE = 5;
    public static final int EDITAR = 7;
    public static final int AGREGAR = 11;

    public MainFrame() {
        super(StringsConstants.ATC);
        initializeVariables();
        initializeLayout();
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
    }

    private void initializeLayout() {
        setSize(NumberConstants.MAIN_WIDTH, NumberConstants.MAIN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);
        setLayout(layout);
        setHead();
        setMain();
        setBD();
        setFoot();
        setSegurosPanel();
        setAfiliacionesPanel();
        setUserPanel();
        if(userSession.getUser().equals("admin")) {
            setAdminPanel();
        }
    }

    private void setFoot() {
        footPanel.setLayout(new FlowLayout());
        JLabel version = new JLabel("Version: " + StringsConstants.VERSION);
        footPanel.add(version);
        add(footPanel, BorderLayout.SOUTH);
    }

    private void setAfiliacionesPanel() {
        afiliacionButton = new JButton(StringsConstants.AFILIACIONES_AFILIADOS);
        afiliacionButton.addActionListener(this);
        afilPanel = new JPanel();
        afilPanel.setLayout(new FlowLayout());
        afilPanel
                .setBorder(BorderFactory.createTitledBorder(StringsConstants.AFILICIONES_PANEL));
        afilPanel.add(afiliacionButton);
        mainPanel.add(afilPanel);
        afiliacionesPanel = new AfiliacionesPanel(this);
       // mainPanel.add(afiliacionesPanel);
    }

    private void setUserPanel() {
        userPanel = new JPanel();
        userPanel.setLayout(new FlowLayout());
        userPanel.setBorder(
                BorderFactory.createTitledBorder(userSession.getEmpleado().getAbreviatura()));
        cambiarClaveButton = new JButton(StringsConstants.CAMBIAR_CLAVE);
        cambiarClaveButton.addActionListener(this);
        userPanel.add(cambiarClaveButton);
        mainPanel.add(userPanel);
    }

    private void setAdminPanel() {
        adminPanel = new AdminPanel();
        mainPanel.add(adminPanel);
    }

    private void setMain() {
        BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(layout);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void setHead() {
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MMM-yyyy");
        JLabel fechaLabel = new JLabel(fecha.format(date));
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headPanel.setLayout(new BorderLayout());
        headPanel.add(new HeaderPanel(StringsConstants.APP_NAME), BorderLayout.NORTH);
        headPanel.add(fechaLabel, BorderLayout.CENTER);
        add(headPanel, BorderLayout.NORTH);
    }

    private void setBD() {
        bdPanel.setLayout(new FlowLayout());
        bdPanel.setBorder(BorderFactory.createTitledBorder(StringsConstants.DATA_BASE_PANEL));
        bdPanel.add(personaButton);
        bdPanel.add(empresaButton);
        bdPanel.add(vehicleButton);
        bdPanel.add(empleadoButton);
        mainPanel.add(bdPanel);
    }

    private void setSegurosPanel() {
        polizaButton = new JButton(StringsConstants.SEGUROS_POLIZA);
        polizaButton.addActionListener(this);
        productoButton = new JButton(StringsConstants.SEGUROS_PRODUCTO);
        productoButton.addActionListener(this);
        movimientoButton = new JButton(StringsConstants.SEGUROS_MOVIMIENTO);
        movimientoButton.addActionListener(this);
        stockButton = new JButton(StringsConstants.SEGUROS_STOCK);
        stockButton.addActionListener(this);
        reintegroSegurosButton = new JButton(StringsConstants.SEGUROS_REINTEGRO);
        reintegroSegurosButton.addActionListener(this);
        reporteSegurosButton = new JButton(StringsConstants.SEGUROS_REPORTES);
        reporteSegurosButton.addActionListener(this);
        segurosPanel.setLayout(new FlowLayout());
        segurosPanel.setBorder(BorderFactory.createTitledBorder(StringsConstants.SEGUROS_PANEL));
        segurosPanel.add(polizaButton);
        segurosPanel.add(productoButton);
        segurosPanel.add(movimientoButton);
        segurosPanel.add(stockButton);
        segurosPanel.add(reintegroSegurosButton);
        segurosPanel.add(reporteSegurosButton);
        mainPanel.add(segurosPanel);
    }

    private void initializeVariables() {
        this.userSession = Session.INSTANCE.getUserSession();
        mainPanel = new JPanel();
        headPanel = new JPanel();
        footPanel = new JPanel();
        personaButton = new JButton(StringsConstants.PERSONA_MENU);
        personaButton.addActionListener(this);
        empresaButton = new JButton(StringsConstants.EMPRESA_MENU);
        empresaButton.addActionListener(this);
        empleadoButton = new JButton(StringsConstants.EMPLEDO_MENU);
        empleadoButton.addActionListener(this);
        vehicleButton = new JButton(StringsConstants.VEHICLE_MENU);
        vehicleButton.addActionListener(this);
        bdPanel = new JPanel();
        segurosPanel = new JPanel();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == empresaButton) {
            if(userSession.getPermisos().getEmpresa() % LISTADO == 0) {
                new MainEmpresa();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == personaButton) {
            if(userSession.getPermisos().getNaturalPermiso() % LISTADO == 0) {
                new MainNatural();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == empleadoButton) {
            if(userSession.getPermisos().getEmpleado() % LISTADO == 0) {
                new MainEmpleado();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == polizaButton) {
            if(userSession.getPermisos().getPoliza() % LISTADO == 0) {
                new MainPoliza();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == productoButton) {
            if(userSession.getPermisos().getProducto() % LISTADO == 0) {
                new MainProducto();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == stockButton) {
            if(userSession.getPermisos().getStock() % LISTADO == 0) {
                new MainStock();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == movimientoButton) {
            if(userSession.getPermisos().getMovimiento() % LISTADO == 0) {
                new MainMovimiento();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == reintegroSegurosButton) {
            if(userSession.getPermisos().getReintegro() % LISTADO == 0) {
                new ReintegroGenerator();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == reporteSegurosButton) {
            if(userSession.getPermisos().getReportes() % LISTADO == 0) {
                new VerReporte();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == afiliacionButton) {
            if(userSession.getPermisos().getAfiliacion() % LISTADO == 0) {
                new MainAfiliado();
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == cambiarClaveButton) {
            CambiarPass pass = new CambiarPass();
            pass.setVisible(true);
        } else if(e.getSource() == vehicleButton) {
            new MainVehiculos();
        }
    }

    private void close() {
        new Control().cerrarApp();
        System.exit(0);
    }
}
