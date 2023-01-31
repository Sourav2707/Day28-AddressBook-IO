package com.day9_address_book;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVOperation {
    public void csvWriter(List<Contacts> contacts) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        File file2 = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day28-AddressBook-IO\\src\\main\\java\\com\\day9_address_book\\AddressBook.csv");
        FileWriter fileWriter = new FileWriter(file2);
        // Create Mapping Strategy to arrange the
        // column name in order
        ColumnPositionMappingStrategy mappingStrategy= new ColumnPositionMappingStrategy();
        mappingStrategy.setType(Contacts.class);
        // Arrange column name as provided in below array.
        String[] columns = new String[]{ "count", "f_name", "l_name", "address", "city", "state", "zip", "ph_no", "email" };
        mappingStrategy.setColumnMapping(columns);
        // Creating StatefulBeanToCsv object
        StatefulBeanToCsvBuilder<Contacts> builder = new StatefulBeanToCsvBuilder<>(fileWriter);
        StatefulBeanToCsv writer = builder.withMappingStrategy(mappingStrategy).build();
        // Write list to StatefulBeanToCsv object
        writer.write(contacts);
        fileWriter.close();
    }
}
