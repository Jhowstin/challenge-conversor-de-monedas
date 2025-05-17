import modelos.ConsultaMonedas;
import modelos.Menu;
import modelos.ResultadoConversion;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMonedas consulta = new ConsultaMonedas();
        Menu menu = new Menu();

        int salir = 0;
        while (salir != 9) {
            try {
                System.out.println("Intrduzca la moneda a convertir");
                System.out.println(menu.getMenu());
                String monedaAConvertir = teclado.nextLine();

                if (monedaAConvertir.equals("9")) {
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                }

                if (!menu.esMonedaValida(monedaAConvertir)) {
                    System.out.println("Moneda no válida. Reiniciando...\n");
                    continue;
                }

                System.out.println("Introduzca la moneda destino");
                System.out.println(menu.getMenu());
                String monedaDestino = teclado.nextLine();

                if (monedaDestino.equals("9")){
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                }

                if (!menu.esMonedaValida(monedaDestino)) {
                    System.out.println("Moneda no válida. Reiniciando...\n");
                    continue;
                }

                System.out.println("Introduzca el monto a convertir");
                double montoAConvertir = teclado.nextDouble();
                teclado.nextLine();
                

                ResultadoConversion resultado = consulta.buscaMoneda(monedaAConvertir, monedaDestino, montoAConvertir);
                System.out.println("******************************************************");
                System.out.println("La tasa de conversion de " + monedaAConvertir + " a " + monedaDestino + " es: " + resultado.conversion_rate());
                System.out.println("La conversión de " + montoAConvertir + " " + monedaAConvertir + " a " +
                        monedaDestino + " es: " + resultado.conversion_result());
                System.out.println("******************************************************");

                System.out.println("¿Desea hacer otra conversión? (1 para continuar o 9 para salir)");
                salir = teclado.nextInt();
                teclado.nextLine(); // limpiar buffer
                System.out.println("Gracias por usar el conversor de monedas.");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Gracias por usar el conversor de monedas.");
            }
        }

    }
}