package piechart.ui;

import java.util.List;

import common.RenderPanel;
import piechart.Config;
import piechart.Sector;
import piechart.ui.components.SectorComponent;
import piechart.ui.components.TitleComponent;

/**
 * PiePanel is the JPanel that contains all render parts
 * 
 * @author Daniel Xu
 *
 */
public class PiePanel extends RenderPanel {

    public PiePanel(Config config, List<Sector> sectors) {
	super(config);
	super.addRenderable(new TitleComponent(config));
	super.addRenderable(new SectorComponent(config).addSector(sectors));
    }
}
