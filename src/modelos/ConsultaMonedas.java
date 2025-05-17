package modelos;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

    public ResultadoConversion buscaMoneda(String monedaOrigen, String monedaDestino, double monto){
        String apiKey = "Pon aqui tu ApiKey";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey +
                "/pair/" + monedaOrigen + "/" + monedaDestino + "/" + monto);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parseamos toda la respuesta como un objeto ResultadoConversion
            return new Gson().fromJson(response.body(), ResultadoConversion.class);

        } catch (Exception e) {
            throw new RuntimeException("Error en la conversión: " + e.getMessage());
        }
    }
}
