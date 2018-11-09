/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.photel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Portege R30
 */
public class hotelServlet extends HttpServlet {

    @EJB
    private photel photel;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tugas Modul 2</title>");
            out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
            out.println("<script src='js/bootstrap.min.js'></script>");
            out.println("<style>\n" +
"	.menu {\n" +
"		margin-left: -15px; \n" +
"		margin-right: 15px;\n" +
"	}\n" +
"	.daftar{\n" +
"		border: 2px solid #e5e5e5; \n" +
"		border-radius: 5px; \n" +
"		padding: 5px;\n" +
"	}\n" +
"	.table th, .table td{\n" +
"		text-align: center;\n" +
"	}\n" +
"	.nav{\n" +
"		padding: 5px; \n" +
"		border: 2px solid #e5e5e5;\n" +
"		border-radius: 5px;\n" +
"	}\n" +
"	.nav li{\n" +
"		border-bottom: 2px solid #e5e5e5;\n" +
"		border-radius: 5px;\n" +
"	}\n" +
"	.daftar h3{\n" +
"                margin-top: 50px;\n" +
"		margin-bottom: 25px;\n" +
"	}\n" +
"       .background {\n"+   
"       background-image: url('hm.jpg');"+
"	}\n" +
"	</style>");
            out.println("</head>");
            out.println("<body style=\"background-image:url(hm.png)\">");
            out.println("<div id='background'>");
            out.println("<div class=\"container\">\n" +
"    <div class=\"jumbotron row\">");
            out.println("<h2><center>Tugas RSBK Pemesanan Hotel</center></h2>");
            out.println("</div>");
            out.println("<font color=\"white\">");
            String nama = request.getParameter("nama");
            String malam = request.getParameter("malam");
            if ((malam != null) && (malam.length() > 0)) {
                double d = Double.parseDouble(malam);
                if (request.getParameter("standard") != null){
                    String std = photel.standard(d);
                    out.println("<p>Halo "+nama+", Harga Kamar yang Harus Dibayar: "+std+"</p>");
                }  
                if (request.getParameter("deluxe") != null) {
                    String dlx = photel.deluxe(d);
                    out.println("<p>Halo "+nama+", Harga Kamar yang Harus Dibayar: "+dlx+ " .</p>");
                }
                if (request.getParameter("suite") != null) {
                    String swt = photel.suite(d);
                    out.println("<p>Halo "+nama+", Harga Kamar yang Harus Dibayar: " +swt+ " .</p>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Selamat Datang!</p>");
                out.println("<p>Silakan pesan kamar hotel yang kamu mau</p>");
                out.println("</center>");
                out.println("<div class=\"row content\">");
                out.println("<div class=\"col-md-12\">");
                out.println("<div class=\"col-md-4 col-md-offset-4 daftar\">");
                out.println("<form method=\"get\">");
                out.println("&nbsp; &nbsp; &nbsp; &nbsp; <label>Nama Kamu</label>");
                out.println("</font>");
                out.println("<font color=\"black\">");
                out.println("&nbsp; &nbsp; <input type=\"text\" name=\"nama\" size=\"20\">");
                out.println("<br/>");
                out.println("</font>");
                out.println("<font color=\"white\">");
                out.println("&nbsp; &nbsp; &nbsp; &nbsp; <label>Jumlah Malam</label>");
                out.println("</font>");
                out.println("<font color=\"black\">");
                out.println("  <input type=\"text\" name=\"malam\" size=\"20\">");
                out.println("</font>");
                out.println("<center>");
                out.println("<font color=\"white\">");
                out.println("&nbsp;<label>Pilih Jenis Kamar</label>");
                out.println("</font>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"standard\" value=\"standard\" class=\"btn btn-md btn-success\" />");
                out.println("<input type=\"submit\" name=\"deluxe\" value=\"deluxe\" class=\"btn btn-md btn-warning\" />");
                out.println("<input type=\"submit\" name=\"suite\" value=\"suite\" class=\"btn btn-md btn-primary\" />");
                out.println("</center>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</center>");
                out.println("</form>");
            }
        
        }
        finally {

            out.println("</body>");
            out.println("</html>");
            out.close();
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
