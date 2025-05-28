package br.ufes.inf.mcp;

import java.io.FileReader;
import java.io.Reader;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Reader in = new FileReader("female-and-male-life-expectancy-at-birth-in-years.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        
        int line = 0;
        LinkedList <Country>countries = new LinkedList<>();

        for(CSVRecord record : records) {

            if(line == 72){
                String name = record.get(0);
                String code = record.get(1);
                String year = record.get(2);
                String female_exp = record.get(4);
                Country c = new Country(name, code, year, female_exp);
                System.out.println(name + year);
                countries.add(c);
                line = 1;
            }
            line++;
        }
    }
}
