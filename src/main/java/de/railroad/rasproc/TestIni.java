package de.railroad.rasproc;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

public class TestIni {

	public static void main(String[] args) throws InvalidFileFormatException, IOException {
		// TODO Auto-generated method stub
		
		 Wini ini = new Wini(new File("test.ini"));
		 for (Entry<String, Section> string : ini.entrySet()) {
			System.out.println(string.getKey() + ":" + string.getValue());
		}

	}

}
