package suhaib.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseMotionListener, MouseListener {
	private static int MouseX = -1, MouseY = -1;
	private static int MouseButton = -1;

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		MouseButton = e.getButton();
	}

	public void mouseReleased(MouseEvent e) {
		MouseButton = -1;
	}

	public void mouseDragged(MouseEvent e) {
		MouseX = e.getX();
		MouseY = e.getY();
		//MouseButton = e.getButton();
	}

	public void mouseMoved(MouseEvent e) {
		MouseX = e.getX();
		MouseY = e.getY();
	}
	
	public static int getX(){
		return MouseX;
	}
	
	public static int getY(){
		return MouseY;
	}
	
	public static int getButton(){
		return MouseButton;
	}

}
