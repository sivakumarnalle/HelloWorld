package com.javainuse.main;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVReadTest {
	public static void main(String[] args) {
		try (Reader reader = Files.newBufferedReader(
				Paths.get("D:\\eclipse-workspace\\drools-hello-world-table\\src\\main\\resources\\rules\\rules.csv"));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL);) {
			for (CSVRecord csvRecord : csvParser) {
				System.out.println("Record No - " + csvRecord.getRecordNumber());
				for (int i =0; i < csvRecord.size(); i++) {
					System.out.println(csvRecord.get(i));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
