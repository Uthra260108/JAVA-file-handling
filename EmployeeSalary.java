import java.io.*;
public class EmployeeSalary {
    public static void main(String[] args) {
        String inputFile = "employees.txt";
        String outputFile = "salary_details.txt";
        double highestGross = 0;
        String highestEmployee = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            String line;
            bw.write("ID\tName\tBasic\tHRA\tDA\tGross Salary");
            bw.newLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double basic = Double.parseDouble(data[2]);
                double hra = basic * 0.20;
                double da = basic * 0.10;
                double gross = basic + hra + da;
                bw.write(id + "\t" + name + "\t" +
                         basic + "\t" + hra + "\t" +
                         da + "\t" + gross);
                bw.newLine();
                if (gross > highestGross) {
                    highestGross = gross;
                    highestEmployee = name;
                }
            }
            br.close();
            bw.close();
            System.out.println("Salary details written successfully.");
            System.out.println("Employee with highest gross salary:");
            System.out.println(highestEmployee);
            System.out.println("Gross Salary = " + highestGross);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
 