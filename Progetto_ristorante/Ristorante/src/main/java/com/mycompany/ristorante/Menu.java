package com.mycompany.ristorante;

/**
 *
 * @author muninn
 */


public class Menu {
    private final String[] antipasti = {"Bruschetta", "Caprese", "Insalata di mare"};
    private final double[] prezziAntipasti = {1.50, 3.00, 5.50};

    private final String[] panini = {"Panino al salame", "Panino vegetariano", "Panino con pollo"};
    private final double[] prezziPanini = {5.00, 6.00, 6.50};

    private final String[] bevande = {"Acqua minerale", "Coca Cola", "Aranciata"};
    private final double[] prezziBevande = {1.10, 1.50, 1.50};

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
