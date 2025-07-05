package com.mycompany.e.commercetec;

import java.util.HashMap;
import java.util.Map;

public class ConfiguracionSistema {
    // Instancia única (Singleton)
    private static ConfiguracionSistema instancia;
    
    // Configuraciones del sistema
    private Map<String, String> configuraciones;
    
    // Constructor privado para evitar instanciación externa
    private ConfiguracionSistema() {
        configuraciones = new HashMap<>();
        cargarConfiguracionesDefecto();
    }
    
    // Método para obtener la única instancia
    public static ConfiguracionSistema obtenerInstancia() {
        if (instancia == null) {
            synchronized (ConfiguracionSistema.class) {
                if (instancia == null) {
                    instancia = new ConfiguracionSistema();
                }
            }
        }
        return instancia;
    }
    
    // Cargar configuraciones por defecto
    private void cargarConfiguracionesDefecto() {
        configuraciones.put("db.host", "localhost");
        configuraciones.put("db.puerto", "3306");
        configuraciones.put("db.nombre", "ecommerce_db");
        configuraciones.put("ui.tema", "oscuro");
        configuraciones.put("ui.idioma", "español");
        configuraciones.put("sistema.version", "1.0.0");
        configuraciones.put("pago.timeout", "30000");
        configuraciones.put("inventario.alertaStock", "5");
    }
    
    // Obtener configuración
    public String obtenerConfiguracion(String clave) {
        return configuraciones.get(clave);
    }
    
    // Establecer configuración
    public void establecerConfiguracion(String clave, String valor) {
        configuraciones.put(clave, valor);
        System.out.println("Configuración actualizada: " + clave + " = " + valor);
    }
    
    // Mostrar todas las configuraciones
    public void mostrarConfiguraciones() {
        System.out.println("=== CONFIGURACIONES DEL SISTEMA ===");
        for (Map.Entry<String, String> entry : configuraciones.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    // Prevenir clonación
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("No se puede clonar una instancia Singleton");
    }
}
