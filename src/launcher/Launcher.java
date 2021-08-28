package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student alumno = new Student(13147, "Dupre", "Valentin", null, null, null);
            	alumno.setGithubURL("https://github.com/ValentinDupre67/tdp-proyecto-1.git");
            	alumno.setMail("valentindupre79@gmail.com");
            	alumno.setPathPhoto("/images/Valen.png");
        		new SimplePresentationScreen(alumno);	
            }
        });
		
    }
}