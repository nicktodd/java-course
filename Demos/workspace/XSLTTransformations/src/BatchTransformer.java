/**
 * This class can be used to batch transform a set of XML 
 * documents based upon a specified stylesheet
 * the output is placed into a folder.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class BatchTransformer {

	private static String folderPath = "C:\\Documents and Settings\\Nick Todd\\My Documents\\Conygre\\WebSite\\site\\WebContent\\xml";
	private static String xsltFile = "file:\\\\C:\\Documents and Settings\\Nick Todd\\My Documents\\Conygre\\WebSite\\site\\WebContent\\xml\\genericNoTable.xslt";
	private static String outputFolder = "c:\\temp\\outlines";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File(folderPath);
		String[] listing = folder.list();
		
		try {
		      TransformerFactory tFactory = TransformerFactory.newInstance();
		      Transformer transformer =
		       tFactory.newTransformer(new StreamSource(xsltFile));
		       
		    
		
		for (String current : listing)
		{
			if (current.endsWith("xml"))
			{
				transformer.transform(new StreamSource(folderPath + "\\" + current),
			           new StreamResult(new FileOutputStream(outputFolder + "\\" + current + ".html")));
			}    
			
		}
		}
		
		catch (TransformerException e) {
		      System.out.println("Transformer exception " + e);
		    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
