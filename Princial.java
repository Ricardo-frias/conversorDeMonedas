import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Princial {

    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner lectura = new Scanner(System.in);
        System.out.printf("Elija el tipo de cambio: ");
        var busqueda = lectura.nextLine();
        // en busqueda se puede elegir el tipo de moneda que quieres cambiar

        String direccion = "https://v6.exchangerate-api.com/v6/40aabc8d0dbfa21853e04dab/latest/"+busqueda;
        String direccion1 = "https://v6.exchangerate-api.com/v6/40aabc8d0dbfa21853e04dab/latest/USD";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        System.out.printf(json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOmd miTituloOmd = gson.fromJson(json, TituloOmd.class);
        System.out.printf(String.valueOf(miTituloOmd));

        datosDelConversol misDatosDeConversol = new datosDelConversol (miTituloOmd);

        System.out.printf(String.valueOf(miTituloOmd));







    }


}
