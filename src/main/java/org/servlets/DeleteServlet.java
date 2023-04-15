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


@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    public DeleteServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            int noteId = Integer.parseInt(request.getParameter("note_id").trim());

            Session session= FactoryProvider.getFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Note note=session.get(Note.class,noteId);
            session.delete(note);
            transaction.commit();
            session.close();

            response.sendRedirect("show_notes.jsp");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
