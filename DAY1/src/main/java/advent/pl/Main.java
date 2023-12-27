package advent.pl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final DataParser dataParser = new DataParser();
        // First part of the task.
        System.out.println("Sum of numbers (hidden as digits in lines) from small data: " + dataParser.getNumbersAndCountSum(
                DataReader.getInputLines(DataReader.pathForSmallData)
        ));
        System.out.println("Sum of numbers (hidden as digits in lines) from big data: " + dataParser.getNumbersAndCountSum(
                DataReader.getInputLines(DataReader.pathForBigData)
        ));

        // Second part of the task.
        System.out.println("Sum of numbers hidden in line as digits' names and as digits in small data input: " + dataParser.findNumbersSum(
                DataReader.getInputLines(DataReader.pathForSmallInputWithDigitNames)
        ));
        System.out.println("Sum of numbers hidden in as digits' names and as digits in big data input: " + dataParser.findNumbersSum(
                DataReader.getInputLines(DataReader.pathForBigData)
        ));
    }
}