import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherBitAPI {
    public static void main(String[] args) {
        try {
            String apiKey = "afb2deeec54d47d999a2b42985fa712a";
            URL url = new URL("https://api.weatherbit.io/v2.0/current?city=Raleigh,NC&key=" + apiKey);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + con.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (con.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}