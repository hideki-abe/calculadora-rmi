package com.calculadora.cliente;

import com.calculadora.servidor.CalculadoraService;
import com.calculadora.view.CalculadoraForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Calculadora extends CalculadoraForm {

    private CalculadoraService service;

    public Calculadora() throws MalformedURLException, NotBoundException, RemoteException {
        this.service = (CalculadoraService) Naming.lookup("rmi://localhost:5099/calculadora");
    }


    @Override
    protected void btnCalcularClick(ActionEvent ev) {
        double num1 = Double.parseDouble(txtNumero1.getText());
        double num2 = Double.parseDouble(txtNumero2.getText());
        try{
            txtResultadoSoma.setText(service.soma(num1, num2));
            txtResultadoSubtracao.setText(service.subtracao(num1, num2));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void btnLimparClick(ActionEvent ev) {
        txtNumero1.setText("");
        txtNumero2.setText("");
        txtResultadoSoma.setText("");
        txtResultadoSubtracao.setText("");
    }

    @Override
    protected void btnFecharClick(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
    }
}
