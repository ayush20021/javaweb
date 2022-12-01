/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.javawebprpject;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Filters.*;
import javax.servlet.RequestDispatcher;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Ayush
 */
public class LoginServlet extends HttpServlet {
        public void  Login(String Name){
        
    
    
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Servlet LoginServlet</title></head>");
        String uname = request.getParameter("txtId");
        String upass = request.getParameter("txtPass");
        String email = request.getParameter("txtemail");
            MongoClient mongoClient = new MongoClient();
            MongoDatabase db = mongoClient.getDatabase("User");// connecting DB
            MongoCollection<Document>  collection= db.getCollection("UserData");
//            Document user11 = collection.find(eq("User_Name",uname )).first();
            
            Bson filter = eq("User_Name",uname);
            MongoCursor<Document> cursor = collection.find(filter).iterator();
           // out.println(filter);
            //out.print("<h1>  Welcome "+ filter +"</h1>");
            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
            rd.forward(request, response);

      
            
//            collection = db.getCollection("Userdata");
//             if(user11!= null){
//             out.println("<body bgcolor=blue >");
//             out.println("<h1> Sucessfully Logedin  !!! </h1>");
//             out.println("</body></html>");
//             out.println(user11);
//             }else{
//             out.println("<body bgcolor=red >");
//             out.println("<h1> Invalid Password or User Id  !!! </h1>");
//             out.println("</body></html>");
//             
//             }
//             
//              Document user = new Document("User_Name",uname)
//              .append("Password",upass)
//              .append("Email",email);
//               collection.insertOne(user);
                   
             
    }
}
