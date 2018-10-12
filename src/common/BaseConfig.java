package common;

import java.awt.Color;

/**
 * The base configuration that all configurations shared. It contains six
 * variables that can be overrided by children configuration classes, which
 * defines the default location of the graph, default dimension of the graph,
 * default background color of the graph and a boolean that decides should high
 * quality mode be turned on or not<br>
 * 
 * Only children configuration class can override them, however, the overrided
 * values just represent the default values, user can still modify them by
 * changing public variables directly. It is more convenience and not
 * necessarily to call too many getters and setters.
 * 
 * @author Daniel Xu
 *
 */
public class BaseConfig {

    /** TITLE of the window, cannot be modified **/
    public final String TITLE = "JPlot v0.2";

    /** x value of the graph location, -1 means center of the screen **/
    public int graph_location_x = -1;

    /** y value of the graph location, -1 means center of the screen **/
    public int graph_location_y = -1;

    /** Width of the graph **/
    public int width = 600;

    /** Height of the graph **/
    public int height = 600;

    /** Background color **/
    public Color background_color = Color.WHITE;

    /** True to enable high quality, false to disable **/
    public boolean high_quality = true;
}
