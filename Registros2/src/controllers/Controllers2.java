/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.Models2;
import views.Views2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author PC 10
 */
public class Controllers2 implements ActionListener{
    private final Models2 models2;
    private final Views2 views2;
    
    public Controllers2(Models2 models2, Views2 views2){
        this.models2 = models2;
        this.views2 = views2;
        views2.JB_Siguiente.addActionListener(this);
        views2.JB_Anterior.addActionListener(this);
        views2.JB_Save.addActionListener(this);
        views2.JB_Primero.addActionListener(this);
        views2.JB_Ultimo.addActionListener(this);
        views2.JB_Clean.addActionListener(this);
        initView();
    }
     public void actionPerformed(ActionEvent e) {
        int contador=0;
        if(e.getSource()==views2.JB_Save){
            models2.setPath("C:\\Users\\PC 10\\Documents\\NetBeansProjects\\base.csv");
            models2.setTxt(models2.getText(views2.JTF_Name.getText(),views2.JTF_Email.getText()));
            models2.witreFile(models2.getPath(), models2.getTxt());
            JOptionPane.showMessageDialog(views2, "El registro se ha guardado");
            views2.JTF_Name.setText(null);
            views2.JTF_Email.setText(null);
        } else if(e.getSource()==views2.JB_Anterior){
            models2.setContador(models2.getContador()-1);
            contador+=models2.getContador();
            System.out.println(contador);
            obtenerPath();
            models2.verRegistros(models2.getTxt(), contador);
            mostrarJTF();
        } else if(e.getSource()==views2.JB_Primero){
            obtenerPath();
            models2.primerRegistro(models2.getTxt());
            mostrarJTF();
        } else if(e.getSource()==views2.JB_Ultimo){
            obtenerPath();
            models2.ultimoRegistro(models2.getTxt());
            mostrarJTF();
        } else if(e.getSource() == views2.JB_Siguiente){
            models2.setContador(models2.getContador()+1);
            contador+=models2.getContador();
            System.out.println(contador);
            obtenerPath();
            models2.verRegistros(models2.getTxt(), contador);
            mostrarJTF();
        } else if(e.getSource()==views2.JB_Clean){
            models2.setEmail(null);
            models2.setName(null);
            mostrarJTF();
        }
    }
       private void initView() {
        views2.setTitle("Agenda v2.0");
        views2.setResizable(false);
        views2.setLocationRelativeTo(null);
        views2.setVisible(true);
        obtenerPath();
        models2.primerRegistro(models2.getTxt());
         mostrarJTF();
    }    

    private void obtenerPath() {
        models2.setPath("C:\\Users\\PC 10\\Documents\\NetBeansProjects\\base.csv");
        models2.readFile(models2.getPath());
    }

    private void mostrarJTF() {
        views2.JTF_Name.setText(models2.getName());
        views2.JTF_Email.setText(models2.getEmail());
    }
}

