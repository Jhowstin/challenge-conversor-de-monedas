import modelos.ConsultaMonedas;
import modelos.Menu;
import modelos.TiposDeMonedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMonedas consulta = new ConsultaMonedas();
        Menu menu = new Menu();
        try {
            System.out.println("Intrduzca la moneda a convertir");
            System.out.println(menu.getMenu());
            String tipoDeMoneda = teclado.nextLine();
            System.out.println("Introduzca la moneda destino");
            System.out.println(menu.getMenu());
            String monedaDestino = teclado.nextLine();
            System.out.println("Introduzca el monto a convertir");
            double montoAConvertir = teclado.nextDouble();

            TiposDeMonedas moneda = consulta.buscaMoneda(tipoDeMoneda);

            double tasa = 0;
            switch (monedaDestino) {
                case "USD" -> tasa = moneda.USD();
                case "DOP" -> tasa = moneda.DOP();
                case "BRL" -> tasa = moneda.BRL();
                case "COP" -> tasa = moneda.COP();
                case "EUR" -> tasa = moneda.EUR();
                case "RUB" -> tasa = moneda.RUB();
                default -> {
                    System.out.println("Moneda destino no válida.");
                    return;
                }
            }

            double resultado = tasa * montoAConvertir;
            System.out.println(resultado);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}