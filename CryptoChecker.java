import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CryptoChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a cryptocurrency name (e.g., bitcoin): ");
        String coin = scanner.nextLine().toLowerCase();

        String apiURL = "https://api.coingecko.com/api/v3/simple/price?ids=" +
                coin + "&vs_currencies=usd&include_market_cap=true&include_24hr_change=true";

        try {
            URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("API error. Response code: " + responseCode);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(jsonString.toString());
            if (!json.has(coin)) {
                System.out.println("Invalid coin name or no data found.");
                return;
            }

            JSONObject data = json.getJSONObject(coin);
            double price = data.getDouble("usd");
            double marketCap = data.getDouble("usd_market_cap");
            double change = data.getDouble("usd_24h_change");

            System.out.printf("\n--- %s Stats ---\n", coin.substring(0, 1).toUpperCase() + coin.substring(1));
            System.out.printf("Price (USD): $%.2f\n", price);
            System.out.printf("Market Cap: $%,.0f\n", marketCap);
            System.out.printf("24h Change: %.2f%%\n", change);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
