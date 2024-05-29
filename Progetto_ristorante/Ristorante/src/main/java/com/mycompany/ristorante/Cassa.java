/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ristorante;

/**
 *
 * @author munin
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cassa {
    private List<Comanda> comandePagate;
    private List<Double> prezziTotali;

    public Cassa() {
        this.comandePagate = new ArrayList<>();
        this.prezziTotali = new ArrayList<>();
    }

    public void registraPagamento(Comanda comanda, double prezzoTotale) {
        comandePagate.add(comanda);
        prezziTotali.add(prezzoTotale);
    }

    public void stampaScontrino() {
        System.out.println("Scontrino:");
        for (int i = 0; i < comandePagate.size(); i++) {
            Comanda comanda = comandePagate.get(i);
            double prezzoTotale = prezziTotali.get(i);
            System.out.println("Comanda per il tavolo " + comanda.getNumeroTavolo() + ":");
            comanda.stampaComanda();
            System.out.println("Totale: $" + prezzoTotale);
            System.out.println("----------------------------------");
        }
    }
    
    public void scriviScontrinoSuFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scontrino.txt", true))) {
            for (int i = 0; i < comandePagate.size(); i++) {
                Comanda comanda = comandePagate.get(i);
                double prezzoTotale = prezziTotali.get(i);

                writer.write("Scontrino per il tavolo " + comanda.getNumeroTavolo() + ":");
                writer.newLine();
                List<String> piatti = comanda.getPiatti();
                List<Double> prezzi = comanda.getPrezzi();
                for (int j = 0; j < piatti.size(); j++) {
                    writer.write(piatti.get(j) + " - $" + prezzi.get(j));
                    writer.newLine();
                }
                writer.write("Totale: $" + prezzoTotale);
                writer.newLine();
                writer.newLine();
            }
            System.out.println("Lo scontrino è stato scritto correttamente sul file.");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura dello scontrino sul file.");
        }
    }
}
