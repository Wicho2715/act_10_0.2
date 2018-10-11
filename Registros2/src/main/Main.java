/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.Models2;
import views.Views2;
import controllers.Controllers2;
/**
 *
 * @author PC 10
 */
public class Main {
        private static Models2 models2;
    private static Views2 views2;
    private static Controllers2 controllers2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        models2 = new Models2();
        views2 = new Views2();
        controllers2 = new Controllers2(models2, views2);
        // TODO code application logic here
    }
    
}
