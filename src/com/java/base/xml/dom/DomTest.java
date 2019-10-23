package com.java.base.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @ClassName DomTest
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/16 18:48
 * @Version 1.0
 **/
public class DomTest {

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("src/com/java/base/xml/book.xml");
            NodeList bookList = document.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                NamedNodeMap namedNodeMap = book.getAttributes();
                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    Node name = namedNodeMap.item(j);
                    System.out.println("name:"+name.getNodeName()+",value:"+name.getNodeValue());
                }
                NodeList nodeList  = book.getChildNodes();
                for (int j = 0; j < nodeList.getLength(); j++) {
                    if (nodeList.item(j).getNodeType()== Node.ELEMENT_NODE)
                    System.out.println(nodeList.item(j).getNodeName());
                    System.out.println(nodeList.item(j).getNodeValue());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
