# Description
Grapher is a tool that is able to show functions or points on a graph.

# How to use
Here is a basic example of how to use Grapher with default configuration
```java
Grapher g = new Grapher();              // Initialize Grapher, with default Config
Expression e = new Expression("x");     // Funtion that we want to show, here we use y=x
g.add_exp(e);                           // Add expression to the graph
g.show();                               // Must call show() to show up the graph on screen
```

Here is an example of how to apply custom configuration to Grapher
```java
Gonfig c = new Config();                // Create instance of Config
c.graph_location_x = 0;                 // Change graph location x to 0
c.graph_location_y = 0;                 // Change graph location y to 0
Grapher g = new Grapher(c);             // Apply the configuration by passing it to Grapher
Expression e = new Expression("x");     // Funtion that we want to show, here we use y=x
g.add_exp(e);                           // Add expression to the graph
g.show();                               // Must call show() to show up the graph on screen
```

Here is an example of showing points on Grapher
```java
Grapher g = new Grapher();      // Initialize Grapher, with default Config
Point p1 = new Point(1.5, 3);   // Create a new point with x=1.5, y=3
Point p2 = new Point(3, 6);     // Create a new point with x=3, y=6
g.add_pts(Color.GREEN, p1);     // Add a point to the graph, specifying the color
g.add_pts(p2);                  // Add a point to the graph, using color in default configuration
g.show();                       // Must call show() to show up the graph on screen
```
More examples can be found in [here](https://github.com/NielXu/JPlot/blob/master/src/grapher/Demo.java)
# Images


