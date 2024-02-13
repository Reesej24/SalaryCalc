import java.util.Scanner;   // Scanner is in the java.util package and must be imported

public class IncomeTaxMainB {
    public static void main(String[] args) {
        final String PROMPT_SALARY = "\nEnter annual salary (-1 to exit)";
        Scanner scnr = new Scanner(System.in);
        int annualSalary;
        double taxRate;
        int taxToPay;
        int i;

        int[] salaryRange = {   0, 30000, 60000, Integer.MAX_VALUE };
        double taxRates   = { 0.0,  0.25,  0.35,              0.45 };

        TaxTableTools table = new TaxTableTools(salaryRange, taxRates);

        // Get the first annual salary to process
        annualSalary = table.getInteger(scnr, PROMPT_SALARY);

        while (annualSalary >= 0) {
            taxRate = table.getValue(annualSalary);
            taxToPay = (int)(annualSalary * taxRate);   // Truncate tax to an integer amount
            System.out.println("Annual Salary: " + annualSalary +
                               "\tTax rate: " + taxRate +
                               "\tTax to pay: " + taxToPay);

            // Get the next annual salary
            annualSalary = table.getInteger(scnr, PROMPT_SALARY);
        }

    }
}
