/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author TuanNA
 */
public class conn {

    public conn() {
    }

    public List getAll() {
        List<User> list = new ArrayList<User>();
        User us = new User();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File("c:\\user.xml"));
            NodeList users = doc.getElementsByTagName("user");
            System.out.println("user count: " + users.getLength());
            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                String username = ((Element) user).getElementsByTagName("username").item(0).getTextContent();
                String password = ((Element) user).getElementsByTagName("password").item(0).getTextContent();

                System.out.println(username);
                us.setUser(username);
                us.setPass(password);
                list.add(us);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
