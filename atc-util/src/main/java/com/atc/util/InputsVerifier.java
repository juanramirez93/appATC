package com.atc.util;

import com.atc.service.PolicyService;
import com.atc.service.empresa.EmpresaService;
import com.atc.service.vehiculo.VehiculoService;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public enum InputsVerifier {
    INSTANCE;

    private VehiculoService vehiculoService;

    private PolicyService policyService;

    InputsVerifier() {
        vehiculoService = new VehiculoService();
        policyService = new PolicyService();
    }

    public InputVerifier policyExistAndIsNumber = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            boolean correct;
            JTextField tf = (JTextField) input;
            tf.setBackground(Color.white);
            String str = tf.getText();
            if(str.isEmpty()) return true;
            if(NumberConstants.isNumber(str)) {
                if(!policyService.exist(str)) {
                    correct = true;
                } else {
                    JOptionPane.showMessageDialog(null, StringsConstants.POLICY_ALREADY_EXIST,
                            StringsConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
                    correct = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, StringsConstants.ONLY_NUMBERS,
                        StringsConstants.APP_NAME,
                        JOptionPane.ERROR_MESSAGE);
                correct = false;
            }
            if(!correct) {
                tf.setText("");
            }
            return correct;
        }
    };

    public InputVerifier toUpper = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            JTextComponent in = (JTextComponent) input;
            in.setText(in.getText().toUpperCase());
            return true;
        }
    };

    public InputVerifier existVehicle = new InputVerifier() {

        @Override
        public boolean verify(JComponent input) {
            JTextField tf = (JTextField) input;
            String cadena = tf.getText();
            if(cadena.isEmpty()) {
                if(vehiculoService.existVehiculo(cadena)) {
                    JOptionPane.showMessageDialog(null, StringsConstants.PLACA_ALREADY_EXIST,
                            StringsConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            tf.setText(tf.getText().toUpperCase());
            return true;
        }
    };

    public InputVerifier isNumberNull = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            boolean verificado;
            JTextField tf = (JTextField) input;
            String cadena = tf.getText();
            if(cadena.isEmpty() || NumberConstants.isNumber(cadena)) {
                verificado = true;
            } else {
                JOptionPane.showMessageDialog(null, StringsConstants.ONLY_NUMBERS,
                        StringsConstants.APP_NAME,
                        JOptionPane.ERROR_MESSAGE);
                verificado = false;
            }
            if(!verificado) {
                tf.setText("");
            }
            return verificado;
        }
    };

    public InputVerifier isNumberNotNull = new InputVerifier() {
        @Override
        public boolean verify(JComponent input) {
            boolean verificado;
            JTextField tf = (JTextField) input;
            String cadena = tf.getText();
            if(NumberConstants.isNumber(cadena)) {
                verificado = true;
            } else {
                JOptionPane.showMessageDialog(null, StringsConstants.ONLY_NUMBERS,
                        StringsConstants.APP_NAME,
                        JOptionPane.ERROR_MESSAGE);
                verificado = false;
            }
            if(!verificado) {
                tf.setText("");
            }
            return verificado;
        }
    };

    public InputVerifier existEmpresa(JTextField nameEmpresa, JDialog frame) {
        return new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                EmpresaService service = new EmpresaService();
                boolean verificado;
                long nit = 0;
                JTextField tf = (JTextField) input;
                String cadena = tf.getText();
                if(NumberConstants.isNumber(cadena)) {
                    nit = Long.valueOf(cadena);
                    if(service.existEmpresa(nit)) {
                        verificado = true;
                        nameEmpresa.setText(service.findByNit(nit).getNombre());
                    } else {
                        int rta =
                                JOptionPane.showConfirmDialog(null, StringsConstants.NIT_ISNT_EXIST,
                                        StringsConstants.APP_NAME, JOptionPane.OK_CANCEL_OPTION);
                        if(rta == 0) {
                            frame.setVisible(true);
                        }
                        verificado = false;
                    }
                } else {
                    verificado = true;
                }
                return verificado;
            }
        };
    }

    public InputVerifier existPolicy(String branch, JFrame cePolicy) {
        return new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                PolicyService policyService = new PolicyService();
                JTextField field = (JTextField) input;
                String s = field.getText();
                if(NumberConstants.isNumber(s)) {
                    if(!policyService.existPolicy(branch, s)) {
                        int rta =
                                JOptionPane
                                        .showConfirmDialog(null, StringsConstants.POLICY_ISNT_EXIST,
                                                StringsConstants.APP_NAME,
                                                JOptionPane.OK_CANCEL_OPTION);
                        if(rta == JOptionPane.OK_OPTION) {
                            cePolicy.setVisible(true);
                            return false;
                        } else {
                            field.setText("");
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, StringsConstants.ONLY_NUMBERS,
                            StringsConstants.APP_NAME,
                            JOptionPane.ERROR_MESSAGE);
                    field.setText("");
                    return true;
                }
            }
        };
    }
}
