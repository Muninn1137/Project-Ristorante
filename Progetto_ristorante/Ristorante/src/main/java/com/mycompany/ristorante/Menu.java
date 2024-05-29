/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ristorante;

/**
 *
 * @author muninn/momo/danylo
 */

public class Menu {
    private final String[] antipasti = {"Bruschetta", "Caprese", "Insalata di mare"};
    private final double[] prezziAntipasti = {7.50, 8.00, 9.50};

    private final String[] panini = {"Panino al salame", "Panino vegetariano", "Panino con pollo"};
    private final double[] prezziPanini = {6.00, 7.00, 8.50};

    private final String[] bevande = {"Acqua minerale", "Coca Cola", "Aranciata"};
    private final double[] prezziBevande = {1.50, 2.00, 2.00};

    public void visualizzaMenu() {
        System.out.println("MENU:");
        System.out.println("Antipasti:");
        for (int i = 0; i < antipasti.length; i++) {
            System.out.println((i + 1) + ". " + antipasti[i] + " - $" + prezziAntipasti[i]);
        }
        System.out.println("Panini:");
        for (int i = 0; i < panini.length; i++) {
            System.out.println((i + 1) + ". " + panini[i] + " - $" + prezziPanini[i]);
        }
        System.out.println("Bevande:");
        for (int i = 0; i < bevande.length; i++) {
            System.out.println((i + 1) + ". " + bevande[i] + " - $" + prezziBevande[i]);
        }
    }

    public String ottieniPiattoAntipasti(int indice) {
        return antipasti[indice];
    }

    public double ottieniPrezzoAntipasti(int indice) {
        return prezziAntipasti[indice];
    }

    public String ottieniPiattoPanini(int indice) {
        return panini[indice];
    }

    public double ottieniPrezzoPanini(int indice) {
        return prezziPanini[indice];
    }

    public String ottieniPiattoBevande(int indice) {
        return bevande[indice];
    }

    public double ottieniPrezzoBevande(int indice) {
        return prezziBevande[indice];
    }
}
