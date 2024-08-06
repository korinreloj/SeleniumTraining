package demos;

import java.util.List;

import utilities.CSV;
import utilities.Excel;

public class DataReaders {

	public static void main(String[] args) {
//		readCSV();
		readXLS();
	}
	
	public static void readCSV() {
		String filename = "/Users/corinnejoycereloj/eclipse-workspace/Selenium/UserAccounts.csv";
		List <String[]> records = CSV.get(filename);
		
		// iterating through the list
		for (String[] record: records) {
			for (String field : record) {
				System.out.println(field);
			}
		}
	}
	
	public static void readXLS() {
		String filename = "/Users/corinnejoycereloj/eclipse-workspace/Selenium/UserLogin.xls";
		String[][] data = Excel.get(filename);
		
		for (String[] record : data) {
			System.out.println("RECORD");
			System.out.println(record[0] + " | " + record[1] + "\n");
		}
	}

}
