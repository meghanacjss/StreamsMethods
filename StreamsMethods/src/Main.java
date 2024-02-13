import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {

        // 1. Integer Stream
        IntStream Stream1 =IntStream.of(1,2,3);
        IntStream Stream2 =IntStream.of(3,5,6);
        IntStream.concat(Stream1,Stream2).distinct().forEach(System.out::println);
        IntStream.range(1, 6).forEach(System.out::print);
        System.out.println();

        // 2. Integer Stream with skip
        IntStream.range(1, 6).skip(3).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // 3. Integer Stream with sum
        int sum = IntStream.range(1, 6).sum();
        System.out.println("Sum: " + sum);

        // 4. Stream.of, sorted, and findFirst
        Stream.of("apple", "banana", "orange")
                .sorted().findFirst().ifPresent(System.out::println);

        // 5. Stream from Array, sort, filter, and print
        int[] numbers = {5, 3, 8, 1, 2};
        Arrays.stream(numbers).sorted().filter(x -> x > 2).forEach(System.out::print);
        System.out.println();

        // 6. Average of squares of an int array
        Arrays.stream(numbers)
                .map(x -> x * x).average()
                .ifPresent(avg -> System.out.println("Average of squares: " + avg));

        // 7. Stream from List, filter, and print
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        fruits.stream().filter(fruit -> fruit.startsWith("b")).forEach(System.out::println);

        // 13. Reduction - sum
        int[] numbersForSumReduction = {1, 2, 3, 4, 5};
        int sumReduction = Arrays.stream(numbersForSumReduction).reduce(0, (x, y) -> x + y);
        System.out.println("Sum using reduction: " + sumReduction);

        // 14. Reduction - summary statistics
        IntSummaryStatistics stat = IntStream.of(1, 2, 3, 4, 5).summaryStatistics();
        System.out.println("Summary Statistics: " + stat);

        // 10. Stream rows from CSV file and count
        Path filePath = Path.of("src/streams/file.csv");
        try{
            long rowCount = Files.lines(filePath)
                    .skip(1).count();
            System.out.println("No. of rows in csv file:"+rowCount);
        }catch(IOException e){
            e.printStackTrace();
        }


        //8. Stream rows from text file, sort, filter, and print
        try {
        Stream<String> lines = Files.lines(Paths.get("src/streams/textfile.txt"));
            lines.sorted().filter(line -> line.length() > 20).forEach(System.out::println);
        } catch (IOException e) {
        e.printStackTrace();
        }


        //9. Stream rows from text file and save to List
        List<String> list = new ArrayList<>();
        try {
        list = Files.lines(Paths.get("src/streams/textfile.txt")).sorted()
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        } catch (IOException e) {
        e.printStackTrace();
        }

        //11. Stream rows from CSV file, parse data from rows
        try {
        Stream<String> rows = Files.lines(Paths.get("src/streams/file.csv"));
            rows.map(row -> row.split(",")).skip(1)
            .forEach(rowArray -> System.out.println(Arrays.toString(rowArray)));
        } catch (IOException e) {
        e.printStackTrace();
        }
        //12. Stream rows from CSV file, store fields in HashMap

        Map<String,String> hashmap = new HashMap<>();
        try {
            Stream<String> rows = Files.lines(Paths.get("src/streams/hashmap.csv"));
            hashmap = rows.map(row -> row.split(","))
         .collect(Collectors.toMap(rowArray -> rowArray[0], rowArray -> (rowArray[1])));
        } catch (IOException e) {
        e.printStackTrace();
        }
        System.out.println("CSV Data in HashMap: " + hashmap);

    }
}



























































































//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }
