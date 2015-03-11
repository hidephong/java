package apk;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dal.BookDAL;
import entity.Book;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TuanNA
 */
@WebServlet(name = "UploadPic", urlPatterns = {"/UploadPic"})
public class UploadPic extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // the directory where the uploaded file will be saved.
            String savePath = request.getServletContext().getRealPath("imagesbook") + "\\";

            String filename = "";

            ServletInputStream in = request.getInputStream();

            byte[] line = new byte[128];
            int i = in.readLine(line, 0, 128);
            int boundaryLength = i - 2;
            String boundary = new String(line, 0, boundaryLength); //-2 discards the newline character

            while (i != -1) {
                String newLine = new String(line, 0, i);
                if (newLine.startsWith("Content-Disposition: form-data; name=\"")) {
                    String s = new String(line, 0, i - 2);
                    int pos = s.indexOf("filename=\"");
                    if (pos != -1) {
                        String filepath = s.substring(pos + 10, s.length() - 1);
                        // Windows browsers include the full path on the client
                        // But Linux/Unix and Mac browsers only send the filename
                        // test if this is from a Windows browser
                        pos = filepath.lastIndexOf("\\");
                        if (pos != -1) {
                            filename = filepath.substring(pos + 1);
                        } else {
                            filename = filepath;
                        }
                    }

                    //this is the file content
                    i = in.readLine(line, 0, 128);
                    i = in.readLine(line, 0, 128);
                    // blank line
                    i = in.readLine(line, 0, 128);

                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    newLine = new String(line, 0, i);

                    while (i != -1 && !newLine.startsWith(boundary)) {
                        // the problem is the last line of the file content
                        // contains the new line character.
                        // So, we need to check if the current line is
                        // the last line.
                        buffer.write(line, 0, i);
                        i = in.readLine(line, 0, 128);

                        newLine = new String(line, 0, i);

                    }
                    try {
                        // save the uploaded file
                        RandomAccessFile f = new RandomAccessFile(savePath + filename, "rw");
                        byte[] bytes = buffer.toByteArray();
                        f.write(bytes, 0, bytes.length - 2);
                        f.close();
                    } catch (Exception e) {
                    }
                }
                i = in.readLine(line, 0, 128);

            } // end while
           
            response.sendRedirect("uploadpic.jsp");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
