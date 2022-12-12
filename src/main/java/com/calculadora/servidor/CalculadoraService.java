package com.calculadora.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculadoraService extends Remote {

	public String soma(Double a, Double b) throws RemoteException;
	public String subtracao(Double a, Double b) throws RemoteException;
	
}
