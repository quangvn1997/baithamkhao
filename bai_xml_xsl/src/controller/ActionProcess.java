package controller;

import Model.Dao;
import Model.ProcessingXML;
import nu.xom.ParsingException;
import nu.xom.ValidityException;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActionProcess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("act");
        String error = "";
        HttpSession session = req.getSession();
        String url = req.getServletContext().getRealPath("/");
        if (action.equals("getdata")) {
            Dao dao = new Dao();
            try {
                dao.writeXML(url);
                req.setAttribute("info", "creating file is ok!");
                session.setAttribute("wrote", "ok");
                req.getRequestDispatcher("/Products.xml").forward(req, resp);
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("showdata")) {
            if (session.getAttribute("wrote") != null) {
                ProcessingXML xulyXML = new ProcessingXML();
                try {
                    ArrayList aL = xulyXML.readXML(url);
                    req.setAttribute("products", aL);
                    getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
                } catch (ParsingException ex) {
                    error = ex.getMessage();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
            } else {
                req.setAttribute("info", "you should \"get datar first !");
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else if (action.equals("filteddata")) {
            if (session.getAttribute("wrote") != null) {
                String filter = req.getParameter("filter");
                try {
                    int IntFilter = Integer.parseInt(filter);
                } catch (NumberFormatException numbprFormatExteptiOn) {
                    req.setAttribute("info", "you should enter numberic format for value to filt data!");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                ProcessingXML xulyXML = new ProcessingXML();
                try {
                    ArrayList aL = xulyXML.filtedContent(url, filter);
                    req.setAttribute("products", aL);
                    getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
                } catch (ValidityException ex) {
                    error = ex.getMessage();
                } catch (ParsingException ex) {
                    error = ex.getMessage();
                }
            } else {
                req.setAttribute("info", "you should \"get data\" first !");
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
        if (!"".equals(error)) {
            req.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }


}
