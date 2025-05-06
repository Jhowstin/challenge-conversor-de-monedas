package modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {


    public TiposDeMonedas buscaMoneda(String moneda){

        String apiKey = "8d188202d22c89718d650b05";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+moneda);



        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            RespuestaApi respuesta = new Gson().fromJson(response.body(), RespuestaApi.class);
            return respuesta.conversion_rates();
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda");
        }

    }

}