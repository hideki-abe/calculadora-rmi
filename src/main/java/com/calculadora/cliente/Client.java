package com.calculadora.cliente;

import com.calculadora.servidor.CalculadoraService;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			Calculadora calc = null;
			try {
				calc = new Calculadora();
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			} catch (NotBoundException e) {
				throw new RuntimeException(e);
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
			calc.setVisible(true);
		});

		//System.out.println(" >>> " + service.soma(1.0, 5.0));

		
	}

}
