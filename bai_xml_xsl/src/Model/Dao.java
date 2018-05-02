package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;

public class Dao {
    private static Connection conn;

    public Dao() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/assignments", "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getData() {
        ResultSet rs = null;

        return rs;
    }

    public void writeXML(String url) throws SQLException, ParserConfigurationException, TransformerException, IOException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("Products");
        document.appendChild(root);
        ResultSet rs = null;
        Statement stt = conn.createStatement();
        rs = stt.executeQuery("select * from products");
        while (rs.next()) {
            Element child = document.createElement("Product");
            root.appendChild(child);
            Element ProductID = document.createElement("ProductID");
            ProductID.setTextContent(rs.getString("productlD"));
            child.appendChild(ProductID);
            Element ProductName = document.createElement("ProductName");
            ProductName.setTextContent(rs.getString("productName"));
            child.appendChild(ProductName);
            Element SupplierID = document.createElement("SupplierID");
            SupplierID.setTextContent(rs.getString("supplierlD"));
            child.appendChild(SupplierID);
            Element CategoryID = document.createElement("CategoryID");
            CategoryID.setTextContent(rs.getString("categorylD"));
            child.appendChild(CategoryID);
            Element QuantityPerUnit = document.createElement("QuantityPerUnit");
            QuantityPerUnit.setTextContent(rs.getString("quantityPerUnit"));
            child.appendChild(QuantityPerUnit);
            Element UnitPrice = document.createElement("UnitPrice");
            UnitPrice.setTextContent(rs.getString("unitPrice"));
            child.appendChild(UnitPrice);
            Element UnitsInStock = document.createElement("UnitsInStock");
            UnitsInStock.setTextContent(rs.getString("unitslnStock"));
            child.appendChild(UnitsInStock);
            Element UnitsOnOrder = document.createElement("UnitsOnOrder");
            UnitsOnOrder.setTextContent(rs.getString("unitsOnOrder"));
            child.appendChild(UnitsOnOrder);
            Element ReorderLevel = document.createElement("ReorderLevel");
            ReorderLevel.setTextContent(rs.getString("reorderLevel"));
            child.appendChild(ReorderLevel);
            Element Discontinued = document.createElement("Discontinued");
            Discontinued.setTextContent(rs.getString("discontinued"));
            child.appendChild(Discontinued);
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
        FileWriter fwriter = new FileWriter(new File(url + "Products.xml"));
        fwriter.write(writer.toString());
        fwriter.close();

    }

    public static void main(String[] args) throws SQLException, ParserConfigurationException, TransformerException, IOException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("Products");
        document.appendChild(root);
        ResultSet rs = null;
        Statement stt = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments", "root", "").createStatement();
        rs = stt.executeQuery("select * from products");
        while (rs.next()) {
            Element child = document.createElement("Product");
            root.appendChild(child);
            Element ProductID = document.createElement("ProductID");
            ProductID.setTextContent(rs.getString("productlD"));
            child.appendChild(ProductID);
            Element ProductName = document.createElement("ProductName");
            ProductName.setTextContent(rs.getString("productName"));
            child.appendChild(ProductName);
            Element SupplierID = document.createElement("SupplierID");
            SupplierID.setTextContent(rs.getString("supplierlD"));
            child.appendChild(SupplierID);
            Element CategoryID = document.createElement("CategoryID");
            CategoryID.setTextContent(rs.getString("categorylD"));
            child.appendChild(CategoryID);
            Element QuantityPerUnit = document.createElement("QuantityPerUnit");
            QuantityPerUnit.setTextContent(rs.getString("quantityPerUnit"));
            child.appendChild(QuantityPerUnit);
            Element UnitPrice = document.createElement("UnitPrice");
            UnitPrice.setTextContent(rs.getString("unitPrice"));
            child.appendChild(UnitPrice);
            Element UnitsInStock = document.createElement("UnitsInStock");
            UnitsInStock.setTextContent(rs.getString("unitslnStock"));
            child.appendChild(UnitsInStock);
            Element UnitsOnOrder = document.createElement("UnitsOnOrder");
            UnitsOnOrder.setTextContent(rs.getString("unitsOnOrder"));
            child.appendChild(UnitsOnOrder);
            Element ReorderLevel = document.createElement("ReorderLevel");
            ReorderLevel.setTextContent(rs.getString("reorderLevel"));
            child.appendChild(ReorderLevel);
            Element Discontinued = document.createElement("Discontinued");
            Discontinued.setTextContent(rs.getString("discontinued"));
            child.appendChild(Discontinued);
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
        FileWriter fwriter = new FileWriter(new File( "Products.xml"));
        fwriter.write(writer.toString());
        fwriter.close();
    }


}
