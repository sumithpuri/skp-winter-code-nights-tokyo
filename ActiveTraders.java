import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

/*
 * HackerRank Problem Solving - Ain't a Horse that Can't be Rode
 * Sumith Kumar Puri (c) 2021 - ~ Bengaluru, Karnataka, India ~
 * 
 */
class ActiveTradersLogic {
    
    public static List<String> mostActive(List<String> customers) {

        // How About Arrays or Custom LinkedList for a 'Very Fast' Traversal?
        Map<String, Integer> customerMap = new TreeMap<String, Integer>();
        List<String> solutionStr = new ArrayList<String>();
        int customerMapSize = customers.size();

        for (int i = 0; i < customerMapSize; i++) {

            String customerKey = customers.get(i);

            if (customerMap.containsKey(customerKey)) {

                Integer customerCount = customerMap.get(customerKey);
                customerMap.put(customerKey, ++customerCount);
            } else {
                customerMap.put(customerKey, 1);
            }
        }

        Set<String> customerMapKeys = customerMap.keySet();
        for (String customerKey : customerMapKeys) {

            Integer customerCount = customerMap.get(customerKey);
            double currentCustomerPercent = (double) (customerCount) / (double) customerMapSize;

            if (currentCustomerPercent * 100 >= 5.0) {

                solutionStr.add(customerKey);
            }
        }

        return solutionStr;
    }
}

public class ActiveTraders {
    
    // kindly configure and environment variable OUTPUT_PATH
	// provide a value that will hold the output, like below
	// f:/active_traders.txt
    public static final String OUTPUT_PATH = "OUTPUT_PATH";
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv(OUTPUT_PATH)));

        int customersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());

        List<String> result = ActiveTradersLogic.mostActive(customers);

        bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}