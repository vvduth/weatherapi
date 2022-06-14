package com.example.weatherapi.helper;

import com.example.weatherapi.entity.WeatherImport;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {  "Year", "m", "d", "Time", "Air temperature (degC)" };
    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<WeatherImport> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<WeatherImport> weatherimports = new ArrayList<WeatherImport>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                WeatherImport weatherImportsingle = new WeatherImport(
                        Integer.parseInt(csvRecord.get("d")),
                        Integer.parseInt(csvRecord.get("Year")),
                        Integer.parseInt(csvRecord.get("m")),
                        Time.valueOf(csvRecord.get("Time")),
                        Double.parseDouble(csvRecord.get("Air temperature (degC)"))
                );

                weatherimports.add(weatherImportsingle);
            }
            return weatherimports;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<WeatherImport> weatherImports) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (WeatherImport weatherImport : weatherImports) {
                List<String> data = Arrays.asList(
                        String.valueOf(weatherImport.getDay()),
                        String.valueOf(weatherImport.getYear()),
                        String.valueOf(weatherImport.getMonth()),

                        String.valueOf(weatherImport.getTime()),

                        String.valueOf(weatherImport.getAir_temp())


                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}

