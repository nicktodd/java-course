import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.conygre.spring.IPerson;


public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  BeanFactory factory = new XmlBeanFactory ( 
		             new FileSystemResource( "people.xml" ) );
		  
		  IPerson person = (IPerson)factory.getBean("person1");
		  System.out.println("The person is called " + person.getName());
		  
		  System.out.println(person.getAddress().getCity());
		  
	}

}
