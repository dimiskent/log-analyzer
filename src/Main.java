import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] logs = new int[3];
        // 0 => info
        // 1 => warning
        // 2 => error
        try(BufferedReader br = new BufferedReader(new FileReader("app.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("INFO")) logs[0]++;
                else if(line.contains("WARNING")) logs[1]++;
                else if(line.contains("ERROR")) logs[2]++;
            }
            System.out.println("Info: " + logs[0]);
            System.out.println("Warnings: " + logs[1]);
            System.out.println("Errors: " + logs[2]);
        } catch (FileNotFoundException e) {
            System.out.println("Please provide app.log (not found)");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
