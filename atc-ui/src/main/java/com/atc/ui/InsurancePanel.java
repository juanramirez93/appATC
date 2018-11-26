package com.atc.ui;

import com.atc.ui.insurances.inventory.MainInventory;
import com.atc.ui.insurances.movement.MainMovement;
import com.atc.ui.insurances.policies.MainPolicy;
import com.atc.ui.insurances.product.MainProduct;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsurancePanel extends JPanel implements ActionListener {

    private JButton policyButton;
    private JButton productButton;
    private JButton movementButton;
    private JButton inventoryButton;
    private MainPolicy mainPolicy = null;
    private MainProduct mainProduct = null;
    private MainMovement mainMovement = null;
    private MainInventory mainInventory = null;
    private MainFrame parent;

    public InsurancePanel(MainFrame parent) {
        super();
        initializeLayout();
        this.parent = parent;
    }

    private void initializeLayout() {
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder(StringsConstants.INSURANCES));
        policyButton = new JButton(StringsConstants.POLICY_MENU);
        policyButton.addActionListener(this);
        add(policyButton);
        productButton = new JButton(StringsConstants.PRODUCT_MENU);
        productButton.addActionListener(this);
        add(productButton);
        movementButton = new JButton(StringsConstants.MOVEMENT_MENU);
        movementButton.addActionListener(this);
        add(movementButton);
        inventoryButton = new JButton(StringsConstants.INVENTORY_MENU);
        inventoryButton.addActionListener(this);
        add(inventoryButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == policyButton) {
            if(parent.userSession.getPermisos().getPoliza() % parent.LISTADO == 0) {
                if(mainPolicy != null) {
                    mainPolicy.dispose();
                }
                mainPolicy = new MainPolicy();
                mainPolicy.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == productButton) {
            if(parent.userSession.getPermisos().getProducto() % parent.LISTADO == 0) {
                if(mainProduct != null) {
                    mainProduct.dispose();
                }
                mainProduct = new MainProduct();
                mainProduct.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == movementButton) {
            if(parent.userSession.getPermisos().getMovimiento() % parent.LISTADO == 0) {
                if(mainMovement != null) {
                    mainMovement.dispose();
                }
                mainMovement = new MainMovement();
                mainMovement.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        } else if(e.getSource() == inventoryButton) {
            if(parent.userSession.getPermisos().getStock() % parent.LISTADO == 0) {
                if(mainInventory != null) {
                    mainInventory.dispose();
                }
                mainInventory = new MainInventory();
                mainInventory.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        }
    }
}
