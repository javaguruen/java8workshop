package no.berghamre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
  private static Logger log = LoggerFactory.getLogger( DataReader.class);

  public static List<String> readData(){
    Path newFile = Paths.get("src", "main", "resources", "income.csv");
    List<String> data = new ArrayList<>();
    try(BufferedReader reader = Files.newBufferedReader( newFile, Charset.forName("utf-8"))){
      log.info("Reading file: {}", newFile);
      String lineFromFile = "";
      while((lineFromFile = reader.readLine()) != null){
        data.add(lineFromFile);
      }
    }catch(IOException exception){
      log.error("Error reading file", exception);
    }
    return data;
  }

    public static List<String> readDataStripHeader() {
        List<String> strings = readData();
        return strings.subList(1, strings.size());
    }
}
