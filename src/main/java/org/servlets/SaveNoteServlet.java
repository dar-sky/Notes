package org.servlets;

import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.notes.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet(name = "SaveNoteServlet", value = "/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    public SaveNoteServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String title=request.getParameter("title");
            String content=request.getParameter("content");
            Note note = new Note(title,content,new Date());

            System.out.println(note.getContent());


            Session session= FactoryProvider.getFactory().openSession();
            Transaction transaction=session.beginTransaction();

            session.save(note);
            transaction.commit();
            session.close();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center;'>Note is added successfully </h1>");
            out.println("<h1 style='text-align:center;'><a href='show_notes.jsp'> View all Notes</h1>");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
