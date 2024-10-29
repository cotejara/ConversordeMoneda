import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    Moneda buscaMoneda (String moneda1, String moneda2) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/18275bb9fba009706a04998a/pair/" + moneda1+"/"+moneda2);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        //este codigo se copio de javadoc
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson( response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public double convertirMonto(double moneda, double monto) {
        if (moneda > 0 && monto > 0) {
            return (moneda * monto);
        } else {
            System.out.println("Hay un error en algunos de los montos ");
            return 0;
        }
    }

}
