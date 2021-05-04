import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();

        //XML to Object from 1st URL
        URL firstURL = new URL("http://www.geoplugin.net/xml.gp?base_currency=USD");

        FirstGeoPlugin firstObject = xmlMapper.readValue(firstURL, FirstGeoPlugin.class);

        //XML to Object from 2nd URL
        URL secondURL = new URL("http://www.geoplugin.net/xml.gp?ip=xx.xx.xx.xx"); // Raw URL
        secondURL = new URL(secondURL.toString().replaceAll
                ("xx.xx.xx.xx", firstObject.getGeoplugin_request())); // Replacing xx.xx.xx.xx to IP

        SecondGeoPlugin secondObject = xmlMapper.readValue(secondURL, SecondGeoPlugin.class);

        // Printing of both objects
        System.out.println("======================First object======================\n\n" + firstObject);

        System.out.println("\n======================Second object======================\n\n" + secondObject);

    }
}
