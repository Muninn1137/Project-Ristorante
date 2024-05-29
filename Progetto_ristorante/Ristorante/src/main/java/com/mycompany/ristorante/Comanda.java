/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ristorante;

/**
 *
 * @author muninn/momo/danylo
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private final int numeroTavolo;
    private final List<String> piatti;
    private final List<Double> prezzi;

    public Comanda(int numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.piatti = new ArrayList<>();
        this.prezzi = new ArrayList<>();
    }

    public void aggiungiPiatto(String piatto, double prezzo, int quantita) {
        
        for (int i = 0; i < quantita; i++){
            piatti.add(piatto);
            prezzi.add(prezzo);
        }
    }
    
    public double calcolaPrezzoTotale() {
        double prezzoTotale = 0.0;
        for (Double prezzo : prezzi) {
            prezzoTotale += prezzo;
        }
        return prezzoTotale;
    }

      public List<String> getPiatti() {
        return piatti;
    }

    public List<Double> getPrezzi() {
        return prezzi;
    }
    
    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    public void stampaComanda() {
        System.out.println("Comanda per il tavolo " + numeroTavolo + ":");
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println(piatti.get(i) + " - $" + prezzi.get(i));
        }
    }

    public void salvaComandaSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("comande.txt", true))) {
            for (int i = 0; i < piatti.size(); i++) {
                writer.write("Tavolo: " + numeroTavolo + ", Comanda: " + piatti.get(i) + " - $" + prezzi.get(i));
                writer.newLine();
            }
            writer.newLine();
            System.out.println("Comanda per il tavolo " + numeroTavolo + " registrata con successo.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file.");
        }
    }
    
}

