/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ristorante;

/**
 *
 * @author muninn/momo/danylo
 */

import java.util.Scanner;

public class Ristorante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Cassa cassa = new Cassa(); // Creiamo un'istanza della classe Ristorante
        
        
        while (true) {
            System.out.print("Inserisci il numero del tavolo: ");
            int numeroTavolo = scanner.nextInt();

            menu.visualizzaMenu();

            Comanda comanda = new Comanda(numeroTavolo);
            gestisciComanda(scanner, menu, comanda);

            comanda.stampaComanda();
            comanda.salvaComandaSuFile();
            
            double prezzoTotale = comanda.calcolaPrezzoTotale(); // Chiamata corretta al metodo calcolaPrezzoTotale()
            cassa.registraPagamento(comanda, prezzoTotale);

            System.out.print("Vuoi registrare un'altra comanda? (si/no): ");
            String risposta = scanner.next();
            if (!risposta.equalsIgnoreCase("si")) {
                break;
            }
        } 
        
        cassa.stampaScontrino(); // Stampiamo lo scontrino alla fine del ciclo principale
    }

    private static void gestisciComanda(Scanner scanner, Menu menu, Comanda comanda) {
        boolean continua = true;
        while (continua) {
            System.out.print("Seleziona una categoria (1 = Antipasti, 2 = Panini, 3 = Bevande, 0 per terminare): ");
            int categoria = scanner.nextInt();
            if (categoria == 0) {
                continua = false;
                continue;
            }
            System.out.print("Seleziona il piatto: ");
            int indicePiatto = scanner.nextInt() - 1;

            double prezzo = 0.0;
            String piatto = "";
            switch (categoria) {
                case 1:
                    piatto = menu.ottieniPiattoAntipasti(indicePiatto);
                    prezzo = menu.ottieniPrezzoAntipasti(indicePiatto);
                    break;
                case 2:
                    piatto = menu.ottieniPiattoPanini(indicePiatto);
                    prezzo = menu.ottieniPrezzoPanini(indicePiatto);
                    break;
                case 3:
                    piatto = menu.ottieniPiattoBevande(indicePiatto);
                    prezzo = menu.ottieniPrezzoBevande(indicePiatto);
                    break;
                default:
                    break;
            }

            if (prezzo != 0.0) {
                comanda.aggiungiPiatto(piatto, prezzo);
            } else {
                System.out.println("Categoria o piatto non valido.");
            }
        }
    }
}
