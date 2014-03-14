package no.berghamre;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class DataReader {
    private static Logger log = LoggerFactory.getLogger(DataReader.class);


    public static List<IncomeStatistics> decodeLinesUsingForEach() {
        List<String> lines = readDataStripHeader();
        final ArrayList<IncomeStatistics> retval = new ArrayList<>();
        lines.forEach(line -> {
            List<String> strings = Arrays.asList(line.split(","));
            String county = strings.get(0);
            Gender sex = Gender.valueOf(strings.get(1));
            List<String> years = strings.subList(2, strings.size());
            for (int i = 0; i < years.size(); i++) {
                int averageIncome = Integer.parseInt(years.get(i));
                final IncomeStatistics is = new IncomeStatistics(county, sex, 1997 + i, averageIncome);
                retval.add(is);
            }
        });
        return retval;
    }

    public static List<IncomeStatistics> read() throws IOException {
        Path newFile = Paths.get("src", "main", "resources", "income.csv");
        return Files.newBufferedReader(newFile, Charset.forName("utf-8")).lines().skip(1).map(line -> {
            String[] strings = line.split(",");
            final String county = strings[0];
            final Gender sex = Gender.valueOf(strings[1]);
            return Arrays.stream(strings, 2, strings.length).reduce(new ArrayList<IncomeStatistics>(), readAccumulator(county, sex), readCombiner());
        }).flatMap(l -> l.stream()).collect(Collectors.toList());
    }

    private static BinaryOperator<ArrayList<IncomeStatistics>> readCombiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    private static BiFunction<ArrayList<IncomeStatistics>, ? super String, ArrayList<IncomeStatistics>> readAccumulator(String county, Gender sex) {
        return (list, str) -> {
            int year = 1997 + list.size();
            list.add(new IncomeStatistics(county, sex, year, Integer.valueOf(str)));
            return list;
        };
    }


    public static List<String> readData() {
        Path newFile = Paths.get("src", "main", "resources", "income.csv");
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(newFile, Charset.forName("utf-8"))) {
            log.info("Reading file: {}", newFile);
            String lineFromFile = "";
            while ((lineFromFile = reader.readLine()) != null) {
                data.add(lineFromFile);
            }
        } catch (IOException exception) {
            log.error("Error reading file", exception);
        }
        return data;
    }

    public static List<String> readDataStripHeader() {
        List<String> strings = readData();
        return strings.subList(1, strings.size());
    }
}
