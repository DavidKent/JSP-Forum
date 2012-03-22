/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Forums.Modules;

/**
 *
 * @author Zerotension
 */
public class Channel implements Module {
    private String m_name;
    private String m_description;
    
    public Channel(String name, String description) {
        m_name = name;
        m_description = description;
    }
 
    @Override
    public String toString() { 
        String output = "";
        output += "<a href='?view=forum&id=[[NAME]]'>";
        output += "<div class='channel'>";
        output += "<div class='channel_header'>[[NAME]]";
        output += "</div>";
        output += "<div class='channel_description'>[[DESCRIPTION]]";
        output += "</div>";
        output += "</div>";
        output += "</a>";
        return output.replace("[[NAME]]", m_name).replace("[[DESCRIPTION]]", m_description);
    }
}
