package fr.fidtec.parsers;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPATHSimple {

	   public static void main(String[] args) {
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	      try {
	         DocumentBuilder builder = factory.newDocumentBuilder();
	         File fileXML = new File("src/main/resources/test.xml");
	         Document xml = builder.parse(fileXML);
	         Element root = xml.getDocumentElement();
	    
	         XPathFactory xpf = XPathFactory.newInstance();
	         XPath path = xpf.newXPath();
	         
	         String expression = "/MrMme/Enfant";
	         NodeList nl = (NodeList)path.evaluate(expression, root, XPathConstants.NODESET);
	         for(int i=0; i < nl.getLength(); i++) {
	        	 System.out.println(nl.item(i).getTextContent());	 
	         }
	        
	         expression = "/MrMme/@nom";
	         String str = (String)path.evaluate(expression, root);
	         System.out.println(str);
	         
	      } catch (ParserConfigurationException e) {
	         e.printStackTrace();
	      } catch (SAXException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (XPathExpressionException e) {
	         e.printStackTrace();
	      }
	   }   
}


