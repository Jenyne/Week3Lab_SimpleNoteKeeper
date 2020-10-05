/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Nykke
 */
public class Note extends HttpServlet implements Serializable {

    String notemsg;
    String title;
    private BufferedReader br;
    private PrintWriter pw;

    public Note() {
        notemsg = "";
        title = "";
    }

    public String getNotemsg() {
        return notemsg;
    }

    public void setNotemsg(String notemsg) {
        this.notemsg = notemsg;
    }

    public String getNote() {
        return notemsg;
    }

    public void setNote(String note, String title) {
        this.notemsg = note;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Note(String note, String title) throws FileNotFoundException, IOException {

        this.notemsg = note;
        this.title = title;

//        this.br = new BufferedReader(new FileReader(new File(path)));
//        this.pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
    }

    public static Note ReadNote(String path) throws IOException {
        String title = "";
        String notemsg = "";

        FileReader reader = new FileReader(path);
        BufferedReader br = new BufferedReader(reader);
        title = br.readLine();
        Note Note = new Note();
        if (br != null) {
            while (br != null) {
                notemsg += br.readLine();
            }

            Note.setTitle(title);
            Note.setNotemsg(notemsg);
            return Note;
        }

        return Note;
    }

    public static Note WriteNote(String title, String notemsg, String path) throws IOException {
        Note note = new Note(title, notemsg);
        FileWriter file = new FileWriter(path);
        PrintWriter pw = new PrintWriter(file);
        note.setTitle(title);
        note.setNotemsg(notemsg);
        pw.print(note.getTitle());
        pw.println(note.getNotemsg());

        return note;
    }
}
