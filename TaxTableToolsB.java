import java.util.Scanner;       // Scanner is in the java.util package and must be imported

public class TaxTableToolsB {
    /** This class searches the 'search' table with a search argument and
     * returns the corresponding value in the 'value' table. Variable
     * 'nEntries' has the number of entries in each table.
     */
    private int [] search =   {   0, 20000, 50000, 100000, Integer.MAX_VALUE };
    private double [] value = { 0.0,  0.10,  0.20,   0.30,              0.40 };
    private int nEntries;

    // ************************************************************************

    // Default Constructor
    public TaxTableTools() {
        nEntries = search.length;       // Set the length of the search table
    }

    // ************************************************************************

    //Overloaded Constructor
    public TaxTableTools(int[] newSearch, double[] newValue) {
        search = newSearch;
        value = newValue;
        nEntries = search.length;
        // Update length of search table
    }

    // ************************************************************************

    //Method to prompt for and input an integer
    public int getInteger(Scanner input, String prompt){
        int inputValue = 0;

        System.out.println(prompt + ": ");
        inputValue = input.nextInt();

        return inputValue;
    }

    // ************************************************************************

    // Method to get a value from one table based on a range in the other table

    public double getValue(int searchArgument) {
        double result;
        boolean keepLooking;
        int i;

        result = 0.0;
        keepLooking = true;
        i = 0;

        while ((i < nEntries) && keepLooking) {
            if (searchArgument <= search[i]) {
                result = value[i];
                keepLooking = false;
            }
            else {
                ++i;
            }
        }

        return result;
    }


}
