/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs359db.db.PhotosDB;
import cs359db.model.Photo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author panos
 */
@WebServlet(urlPatterns = {"/GetImage"})
public class GetImage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
  
         String Image=request.getParameter("image");
        int Id = Integer.parseInt(Image);
        String meta=request.getParameter("metadata");
        Photo ph=PhotosDB.getPhotoMetadataWithID(Id);
        boolean ismeta=Boolean.parseBoolean(meta);
        byte [] data=PhotosDB.getPhotoBlobWithID(Id);
        if (ismeta==true){
            response.setContentType("application/json");
            String Sphoto=ph.toString();
            try (PrintWriter out = response.getWriter()) {
                String Sphoto1="{\"userName\":\""+ph.getUserName()+"\",\"title\":\""+ph.getTitle()+"\",\"date\": \""+ph.getDate()+"\",\"contentType\": "+ph.getContentType()+",\"numberOfRatings\":\""+ph.getNumberOfRatings()+"\" }";
                System.out.println(Sphoto1);
                out.println(Sphoto1);
            }
        }else{
            String Content=ph.getContentType();
            response.setContentType(Content);
            try (OutputStream os = response.getOutputStream()) {
                os.write(data);
                os.flush();
                os.close();
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetImage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetImage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
