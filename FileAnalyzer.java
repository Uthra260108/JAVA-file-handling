import java.io.*;

public class FileAnalyzer {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "analysis.txt";

        int characters = 0;
        int words = 0;
        int lines = 0;
        int vowels = 0;

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

                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' ||
                        ch == 'O' || ch == 'U') {
                        vowels++;
                    }
                }
            }

            br.close();

            bw.write("Number of Characters = " + characters);
            bw.newLine();

            bw.write("Number of Words = " + words);
            bw.newLine();

            bw.write("Number of Lines = " + lines);
            bw.newLine();

            bw.write("Number of Vowels = " + vowels);
            bw.newLine();

            bw.close();

            System.out.println("Analysis completed successfully.");
            System.out.println("Number of Characters = " + characters);
            System.out.println("Number of Words = " + words);
            System.out.println("Number of Lines = " + lines);
            System.out.println("Number of Vowels = " + vowels);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
