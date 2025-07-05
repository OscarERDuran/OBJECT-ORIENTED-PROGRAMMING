package com.mycompany.e.commercetec;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private List<ObservadorEvento> observadores;
    
    public GestorEventos() {
        this.observadores = new ArrayList<>();
    }
    
    // Suscribir observador
    public void suscribir(ObservadorEvento observador) {
        observadores.add(observador);
        System.out.println("Observador suscrito al sistema de eventos");
    }
    
    // Desuscribir observador
    public void desuscribir(ObservadorEvento observador) {
        observadores.remove(observador);
        System.out.println("Observador desuscrito del sistema de eventos");
    }
    
    // Notificar a todos los observadores
    public void notificarEvento(String tipoEvento, Object datos) {
        System.out.println("🔔 Evento disparado: " + tipoEvento);
        for (ObservadorEvento observador : observadores) {
            observador.notificar(tipoEvento, datos);
        }
    }
}
