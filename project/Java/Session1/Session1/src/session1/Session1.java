package session1;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Session1 {

    public static void main(String[] args) {
        try {
            SAXParserFactory f = SAXParserFactory.newInstance();
            SAXParser parser = f.newSAXParser();
            ShipOrderHandler soh =  new ShipOrderHandler();
            parser.parse(Session1.class.getResourceAsStream("shiporder.xml"),soh);
            List<Item> l = soh.getList();
            for(Item i : l){
                System.out.println(i);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Session1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Session1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Session1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ShipOrderHandler extends DefaultHandler {

    List<Item> list;

    public ShipOrderHandler() {

        list = new LinkedList<Item>();
    }

    public List<Item> getList() {
        return list;
    }
    
    private boolean itemFound = false;
    private boolean titleFound = false;
    private boolean noteFound = false;
    private boolean quantityFound = false;
    private boolean priceFound = false;
    private Item currentItem;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("item")) {
            currentItem = new Item();
            list.add(currentItem);
            itemFound = true;
        }
        if (qName.equals("title")) {
            titleFound = true;
        }
        if (qName.equals("note")) {
            noteFound = true;
        }
        if (qName.equals("quantity")) {
            quantityFound = true;
        }
        if (qName.equals("price")) {
            priceFound = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(titleFound){
            String title = new String(ch, start, length);
            currentItem.setTitle(title);
            titleFound = false;
        }
        if(noteFound){
            String note = new String(ch, start, length);
            currentItem.setNote(note);
            noteFound = false;
        }
        if(quantityFound){
            String q = new String(ch, start, length);
            currentItem.setQuantity(q);
            quantityFound = false;
        }
        if(priceFound){
            String p = new String(ch, start, length);
            currentItem.setPrice(p);
            priceFound = false;
        }
    }
}