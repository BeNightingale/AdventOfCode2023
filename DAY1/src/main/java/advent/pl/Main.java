package advent.pl;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        final DataParser dataParser = new DataParser();
        // The first part of the task.
        System.out.println("Sum of numbers (hidden as digits in lines) from small data: " + dataParser.getNumbersAndCountSum(
                Reader.getInputLines(DataPath.pathForSmallData)
        ));
        System.out.println("Sum of numbers (hidden as digits in lines) from big data: " + dataParser.getNumbersAndCountSum(
                Reader.getInputLines(DataPath.pathForBigData)
        ));

        // The second part of the task.
        System.out.println("Sum of numbers hidden in line as digits' names and as digits in small data input: " + dataParser.findNumbersSum(
                Reader.getInputLines(DataPath.pathForSmallInputWithDigitNames)
        ));
        System.out.println("Sum of numbers hidden in as digits' names and as digits in big data input: " + dataParser.findNumbersSum(
                Reader.getInputLines(DataPath.pathForBigData)
        ));
    }
}