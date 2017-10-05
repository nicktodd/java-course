

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4JTest {

	static
	{
		PropertyConfigurator.configure("log4j.properties");
	}
	private static Logger logger = Logger.getLogger("log4j.logger.com.citi");
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//logger.setLevel(Level.ALL);
		
		logger.error("This is an error message");
		
		logger.debug("This is a debug message");
	
		logger.info("This is just an info message");
	}

}
