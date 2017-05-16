package cl.pixelchile.logreader;

import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.stream.Stream;

import org.junit.Test;

public class LogReaderTest {
	private static final String site_url = "http://www.pixelchile.cl/soap/fpro-soap-2017-portlet.log";

//	@Test
	public void testLogReader() {
		String[] params = new String[2];
		params[0] = site_url;
		params[1] = "ERROR";
		
		LogReader.main(params);
	}
	
//	@Test
//	public void testJava8() {
//		try {
//			String line = Files.readAllLines(Paths.get("build.xml")).get(12);
//			System.out.println(line);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testJava8a() {
//		Stream<String> lines = null;
//		try {
//			lines = Files.lines(Paths.get("build.xml"));
//		    String line = lines.skip(12).findFirst().get();
//		    System.out.println(line);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			lines.close();
//		}
//	}
}
