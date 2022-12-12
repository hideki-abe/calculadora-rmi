package com.calculadora.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

public abstract class CalculadoraForm extends JFrame{

    protected JLabel lblNumero1;
    protected JTextField txtNumero1;

    protected JLabel lblNumero2;
    protected JTextField txtNumero2;

    protected JLabel lblResultadoSoma;
    protected JTextField txtResultadoSoma;

    protected JLabel lblResultadoSubtracao;
    protected JTextField txtResultadoSubtracao;

    protected JPanel pnlForm;
    protected JPanel pnlRodape;

    protected JButton btnCalcular;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    public CalculadoraForm(){
        this.inicializar();
        this.eventos();
    }

    private void inicializar() {
        this.setTitle("Calculadora: ");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END);
        this.pack();
    }

    protected abstract void btnCalcularClick(ActionEvent ev);
    protected abstract void btnLimparClick(ActionEvent ev);
    protected abstract void btnFecharClick(ActionEvent ev);

    private void eventos() {
       btnFechar.addActionListener(this::btnFecharClick);
       btnLimpar.addActionListener(this::btnLimparClick);
       btnCalcular.addActionListener(this::btnCalcularClick);
    }

    public JPanel getPnlForm() {
        if (pnlForm == null) {
            pnlForm = new JPanel(new GridLayout(4, 2));

            lblNumero1 = new JLabel("Numero 1: ");
            txtNumero1 = new JTextField(15);

            lblNumero2 = new JLabel("Numero 2: ");
            txtNumero2 = new JTextField(15);

            lblResultadoSoma = new JLabel("Soma: ");
            txtResultadoSoma = new JTextField(15);
            txtResultadoSoma.setEditable(false);

            lblResultadoSubtracao = new JLabel("Subtracao: ");
            txtResultadoSubtracao = new JTextField(15);
            txtResultadoSubtracao.setEditable(false);

            pnlForm.add(lblNumero1);
            pnlForm.add(txtNumero1);
            pnlForm.add(lblNumero2);
            pnlForm.add(txtNumero2);
            pnlForm.add(lblResultadoSoma);
            pnlForm.add(txtResultadoSoma);
            pnlForm.add(lblResultadoSubtracao);
            pnlForm.add(txtResultadoSubtracao);
        }
        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if(pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCalcular = new JButton("Calcular");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnCalcular);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);

        }
        return pnlRodape;
    }
}
