package common;

import java.awt.Graphics;

/**
 * Renderable object should implement this interface. Renderable means that an
 * object can be render on the JPanel and the detail of rendering is done by
 * overriding the {@link #render(Graphics)} method.
 * 
 * @author Daniel Xu
 *
 */
public interface Renderable {

    /**
     * Render an object on JPanel
     * 
     * @param g Graphics
     */
    public void render(Graphics g);

}
