/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.io.Serializable;

/**
 *
 * @author BritishWaldo
 */
public class Note implements Serializable
{
    private String title = "";
    private String contents = "";

    public Note() 
    {
        
    }
    
    public Note(String inputTitle, String inputContents)
    {
        this.title = inputTitle;
        this.contents = inputContents;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String inputTitle)
    {
        this.title = inputTitle;
    }
    
    public String getContents()
    {
        return this.contents;
    }
    
    public void setContents(String inputContents)
    {
        this.contents = inputContents;
    }
    
    public String toString()
    {
        return "Title: " + this.title + " Contents: " + this.contents;
    }
}
