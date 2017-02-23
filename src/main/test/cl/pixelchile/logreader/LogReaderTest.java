package cl.pixelchile.logreader;

import org.junit.Test;

public class LogReaderTest {

	@Test
	public void test1() {
		String[] params = new String[2];
		params[0] = "http://www.pixelchile.cl/soap/fpro-soap-2017-portlet.log";
		params[1] = "ERROR";
		
		LogReader.main(params);
	}
}
