import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ReadUsers {

    public static void main(String argv[]) throws
            IOException, ParserConfigurationException, SAXException {

        File xmlFile = new File("src/MMR_IRArticle23T1_IE_2016v2.xml");
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);   
       

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList rows = doc.getElementsByTagName("Row"); 

        for (int i = 0; i < rows.getLength(); i++) {

            Node row = rows.item(i);

            System.out.println("\nCurrent Element: " + row.getNodeName());

            if (row.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) row;

               // String uid = elem.getAttribute("id");
 
                Node node1 = elem.getElementsByTagName("Category__1_3").item(0);
                String c = node1.getTextContent();

                Node node2 = elem.getElementsByTagName("Year").item(0);
                String year = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("Scenario").item(0);
                String scenario = node3.getTextContent();
                
                Node node4 = elem.getElementsByTagName("Gas___Units").item(0);
                String gu= node4.getTextContent();
                
                Node node5 = elem.getElementsByTagName("Value").item(0);
                String value= node5.getTextContent();
                
                
                

               // System.out.println("User id:"+ uid);
              //  if(year == 2023 && scenario.equalsIgnoreCase("WEM")&& value > 0) {
                System.out.println("Category: "+ c);
                System.out.println("Year: " + year);
                System.out.println("Gas___Units: " + gu);
                System.out.println("Value: " + value);

		//If I wanted to store the user I just parsed then I would use Hibernate as follows
		//UserDAO dao = new UserDAO();
		//User user = new User(uid, name, lname,occup);
		//dao.persist(user);
                
            }
        }
    }
}
