import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;





class Controller implements MouseListener,KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    }

    public void update(final Graphics g) {
        model.update(g);
    }

    public void keyPressed(final KeyEvent e) {
    }

    public void keyReleased(final KeyEvent e) {
    }

    public void keyTyped(final KeyEvent e) {
        final RobberCar robbercar = new RobberCar();
        if (e.getKeyChar() == 'h') {
            System.out.println("HELLO WORLD");
        }
        if (e.getKeyChar() == 'n') {
            System.out.println("Robbers captured : " + robbercar.getCaptured() + " Robbers escaped : " + robbercar.getEscaped());
        }
        if (e.getKeyChar() == 'r') {
            model.initialize();
            view.repaint();
        }

        if (e.getKeyChar() == 's') {
            final SpriteMover spriteMover = new SpriteMover(view, model);
            final Thread thread = new Thread(spriteMover);
            thread.start();
           

        }
    }

    public void mousePressed(final MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            view.repaint();
            // Gets here is left mouse button was clicked
            model.specificSprite(e.getX(), e.getY());

        } else if (SwingUtilities.isRightMouseButton(e)) {
            // Gets here if right mouse button was clicked
            // model.fillCarUp();
            view.repaint();
            model.updateScene(view.getWidth(), view.getHeight());

        }
    }

    public void mouseReleased(final MouseEvent e) {
    }

    public void mouseEntered(final MouseEvent e) {
    }

    public void mouseExited(final MouseEvent e) {
    }

    public void mouseClicked(final MouseEvent e) {
    }

    public static void main(final String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
    	System.out.println("cwd=" + System.getProperty("user.dir")); 
        new Controller();
    }
}