package cl.pixelchile.logreader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LogReader {
	private static final String ENCODING = "UTF-8";
	private static final String OUTFILE = "soap_out.log";
	private static final String DATE_FORMAT = "HH:mm:ss dd/MM/yyyy";
	private static final String PROTOCOL = "http://";

	public static void main(String[] args) {
		File file = null;
		Scanner scanner = null;
		PrintWriter writer = null;

		int line = 0;
		int found = 0;

		try {
			String url = args[0];
			String pattern = args[1];

			System.out.println("Leyendo el archivo : " + url);
			System.out.println("Buscando la cadena : " + pattern);
			System.out.println("Fecha de inicio    : " + getDate());
			separator();

			if (url.contains(PROTOCOL)) {
				scanner = new Scanner(new URL(url).openStream(), ENCODING);
			} else {
				file = new File(url);
				scanner = new Scanner(file, ENCODING);
			}

			writer = new PrintWriter(OUTFILE, ENCODING);

			while (scanner.hasNextLine()) {
				String strLine = scanner.nextLine();
				line++;

				if (strLine.contains(pattern)) {
					found++;
					System.out.println("Linea " + line + ": " + strLine);
					writer.println("Linea " + line + ": " + strLine);
				}
			}

			separator();
			System.out.println(line + " linea(s) leidas.");
			System.out.println(found + " linea(s) encontradas.");
			System.out.println("Fecha de termino    : " + getDate());
			separator();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			writer.close();
		}
	}

	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		Date date = new Date();

		return dateFormat.format(date);
	}
	
	public static void separator() {
		System.out.println("--------------------------------------------------");	
	}

}
