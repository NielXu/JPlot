package grapher.ui.components.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import grapher.ui.components.CursorComponent;

/**
 * The mouse motion listener that provides cursor's x,y location to the
 * component.
 * 
 * @author Daniel Xu
 *
 */
public class MotionListener implements MouseMotionListener {

    /** The component that requires the cursor location **/
    private CursorComponent compo;
    /** The graph(JPanel) that need to be repainted **/
    private JPanel parent;

    public MotionListener(JPanel parent, CursorComponent compo) {
	this.parent = parent;
	this.compo = compo;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	// Not using
    }

    @Override
    public void mouseMoved(MouseEvent e) {
	compo.set_cursorlocation(e.getX(), e.getY());
	parent.repaint();
    }

}
