import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String inputFile = "source.txt";
        String outputFile = "destination.txt";

        int characters = 0;
        int words = 0;
        int lines = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            String line;

            while ((line = br.readLine()) != null) {
                lines++;

                characters += line.length();

                String[] data = line.trim().split("\\s+");

                if (!line.trim().isEmpty()) {
                    words += data.length;
                }

                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("File copied successfully.");
            System.out.println("Number of Lines = " + lines);
            System.out.println("Number of Words = " + words);
            System.out.println("Number of Characters = " + characters);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
