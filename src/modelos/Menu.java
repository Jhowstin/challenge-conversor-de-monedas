package modelos;

public class Menu {

    public String menu= """
            *** Tipos de monedas ***
            USD = Dolar dstaounidense
            DOP = Peso Dominicano
            BRL = Real brasileño
            COP = Peso Colombiano
            EUR = Euro
            RUB = Rublo Ruso
            9 = Salir
            """;

    public String getMenu() {
        return menu;
    }

    public boolean esMonedaValida(String moneda) {
        String[] monedasValidas = {"USD", "DOP", "BRL", "COP", "EUR", "RUB"};
        for (String m : monedasValidas) {
            if (m.equalsIgnoreCase(moneda)) {
                return true;
            }
        }
        return false;
    }
}