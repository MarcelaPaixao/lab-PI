package br.ufes.inf.mcp;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Reader in = new FileReader("female-and-male-life-expectancy-at-birth-in-years.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        LinkedList <Country> countries = new LinkedList<>();
        int line_num = 0;
        for (CSVRecord record : records) {
            line_num++;
            if((line_num - 2) % 72 == 0){
                String name = record.get(0);
                String code = record.get(1);
                String year = record.get(2);
                String male_exp = record.get(3);
                String fem_exp = record.get(4);
                Country c = new Country(name, code, year, male_exp, fem_exp);
                countries.add(c);
            }
        }
    }
}
