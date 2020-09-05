package com.javainuse.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.opencsv.CSVWriter;

public class OpenCSVWriteTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String[] entries = { "\"book\"", "coin", "pencil", "cup" };
		String fileName = "src/main/resources/items.csv";

		try (OutputStream fos = new FileOutputStream(fileName);
				OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
				CSVWriter writer = new CSVWriter(osw)) {

			writer.writeNext(entries);
		}
	}

}
