import java.util.*;

public class I18NExample {

    static public void main(String[] args) {

        String language = "en";
        String country = "GB";


        Locale locale;
        ResourceBundle bundle;

        locale = new Locale(language, country);

        bundle = ResourceBundle.getBundle("MyBundle",
                                           locale);
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("goodbye"));
    }
}