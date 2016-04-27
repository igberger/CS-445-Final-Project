/***************************************************************
* file: Basic.java
* author: ??????????????????????
* class: CS 445 – Computer Graphics
*
* assignment: final program
* date last modified: 4/27/2016 *
* purpose: 
****************************************************************/
package cs.pkg445.program.pkg1;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Basic {
	// method: start
	// purpose: create window, initialize OpenGL, print instructions, and run the main loop
	public void start() {
		try { 
			createWindow(); 
			initGL();
			printInstructions();
			run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// method: createWindow
	// purpose: creates a nonfullscreen window with resolution 640x480 with title "Final Program"
	private void createWindow() throws Exception{
		Display.setFullscreen(false);
		Display.setDisplayMode(new DisplayMode(640, 480));
		Display.setTitle("Final Program");
		Display.create();
	}
	// method: initGL
	// purpose: initialize OpenGL's coordinate system with the orgin at the center of the window and set the background to black
	private void initGL() {
		glClearColor(0f, 0f, 0f, 0f);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(-320, 320, -240, 240, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	}
	// method: render
	// purpose: 
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		
	}
	// method: run
	// purpose: main loop, updates display at 60Hz while it has not been requested to close
	public void run() {
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			processKeyboard();
			render();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	// method: processKeyboard
	// purpose: respond to specified keyboard inputs: see comments for response to each input
	public void processKeyboard() {
	}
	// method: printInstructions
	// purpose: Print instructions to console for user input
	private void printInstructions() {
		System.out.println("Controls:");
		System.out.println("ESC - Quit");
	}
	// method: main
	// purpose: entry point for program, runs the start method
	public static void main(String[] args) {
		Basic basic = new Basic();
		basic.start(); 
	}
}