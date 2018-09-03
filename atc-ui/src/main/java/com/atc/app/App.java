package com.atc.app;

import com.atc.ui.Auth;

import javax.swing.*;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		if (new Control().comprobar()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Auth();
				}
			});
		}
	}

}
