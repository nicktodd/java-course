import java.util.logging.*;
import java.io.IOException;

public class LoggingExample
{

    public static void main(String[] args)
    {
		// create the logger object
        Logger logger = Logger.getLogger("LoggingExample");

        // set the level of log information that is required
        logger.setLevel(Level.INFO);

        try
        {
			// define a file for the log
            FileHandler handler = new FileHandler("logfile.xml");

            // specify that you want the file to be created in XML
            handler.setFormatter(new XMLFormatter());

            logger.addHandler(handler);
        }
        catch (IOException e)
        {
			System.out.println("IOException " + e);
		}

		// now log some messages at different levels
        logger.severe ("Here is a SEVERE message");
        logger.warning("Here is a WARNING message");
        logger.info   ("Here is an INFO message");
        logger.config ("Here is a CONFIG message");
        logger.fine   ("Here is a FINE message");
        logger.finer  ("Here is a FINER message");
        logger.finest ("Here is a FINEST message");
    }
}
