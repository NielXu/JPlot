package piechart.ui.components;

import java.awt.Graphics;
import java.awt.Rectangle;

import piechart.Config;

public class TitleComponent extends PieComponent {

    public TitleComponent(Config config) {
	super(config);
    }

    @Override
    public void render(Graphics g) {
	Rectangle rect = new Rectangle(0, 10, config.width, 20);
	super.renderlabel(g, rect, config.title_font, config.title, config.title_color);
    }

}
