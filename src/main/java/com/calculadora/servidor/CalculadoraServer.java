package com.calculadora.servidor;

import com.calculadora.view.CalculadoraForm;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServer extends UnicastRemoteObject implements CalculadoraService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected CalculadoraServer() throws RemoteException {
		super();
	}


	@Override
	public String soma(Double a, Double b) throws RemoteException {
		Double soma = a + b;
		return soma.toString();
	}

	@Override
	public String subtracao(Double a, Double b) throws RemoteException {
		Double subtracao = a - b;
		return subtracao.toString();
	}
}
