/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managers.Note;

/**
 *
 * @author BritishWaldo
 */
public class NoteServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println("IN DO GET------------------------------------");
        
        Note newNote = readNoteFromFile();
        
        System.out.println(newNote);

        if (request.getParameterMap().containsKey("viewNote"))
        {            
            request.setAttribute("note_title", newNote.getTitle());
            request.setAttribute("note_contents", newNote.getContents());
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
            return;
        }
        else if (request.getParameterMap().containsKey("editNote"))
        {
            request.setAttribute("note_title", newNote.getTitle());
            request.setAttribute("note_contents", newNote.getContents());
            
            getServletContext().getRequestDispatcher("/WEB-INF/editNote.jsp").forward(request, response);
            return;
        }
        else
        {            
            request.setAttribute("note_title", newNote.getTitle());
            request.setAttribute("note_contents", newNote.getContents());
            
            getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println("IN DO POST+++++++++++++++++++++++++++++++++++++");

        String noteTitle = request.getParameter("note_title");
        String noteContents = request.getParameter("note_contents");
        
        Note newNote = new Note(noteTitle, noteContents);
        
        saveNoteToFile(newNote);
        
        request.setAttribute("note_title", newNote.getTitle());
        request.setAttribute("note_contents", newNote.getContents().replace("\n", "<br>"));
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewNote.jsp").forward(request, response);
    }
    
    private void saveNoteToFile(Note inputNote)
    {
        try 
        {
            String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
            
            PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(notePath, false)));
            
            String noteTitle = inputNote.getTitle();
            String noteContents = inputNote.getContents();
            
            fileWriter.print(noteTitle + "\n" + noteContents);
            
            fileWriter.close();
        } catch (IOException IOE) 
        {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, IOE);
        } 
    }
    
    private Note readNoteFromFile()
    {
        Note newNote = new Note();
        
        try 
        {
            String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
                        
            BufferedReader fileReader = new BufferedReader(new FileReader(new File(notePath)));
            
            String noteTitle = fileReader.readLine();
            String noteContents = "";
            
            String placeholder = fileReader.readLine();
            do
            {
                if (noteContents.equals(""))
                {
                    noteContents += placeholder;
                }
                else
                {
                    noteContents += "\n";
                    noteContents += placeholder;
                }

                placeholder = fileReader.readLine();
            } while (placeholder != null);
            
            newNote = new Note(noteTitle, noteContents);
            
            System.out.println("IN READNOTE****************************");
            System.out.println(newNote);
            
            fileReader.close();
        } catch (IOException IOE) 
        {
            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, IOE);
        } 
        
        return newNote;
    }

}
