/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Nykke
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String state = request.getRequestURI();
        if (state.contains("editnote")) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
            request.setAttribute("notemsg", "Content goes here.");
            request.setAttribute("title", "Title");
        } else {
//            ServletContext context = getServletContext();
//            String path = context.getRealPath("/WEB-INF/note.txt");
//            Note.ReadNote(path);
            Note note = new Note();
            request.setAttribute("notemsg", note.getNote());
            request.setAttribute("title", note.getTitle());
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page = request.getRequestURI();

        if (page.contains("editnote")) {
//        if(notemsg == null || notemsg.equals("")|| title==null || title.equals("")){
//            request.setAttribute("error","Please Enter a title and message.");
//            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request,response);
//        }
//        
            String  path = getServletContext().getRealPath("/WEB-INF/note.txt");
            String notemsg = request.getParameter("notemsg");
            String title = request.getParameter("title");
            Note note = new Note(title, notemsg);
            request.setAttribute("notemsg", notemsg);
            request.setAttribute("title", title);
            request.setAttribute("note", note);
            Note.WriteNote(title,notemsg,path);
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
