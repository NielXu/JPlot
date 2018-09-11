# Introduction
A histogram is an accurate representation of the distribution of numerical data. It is an estimate of the probability distribution of a continuous variable. Histogram package allows users to customize their graphs and easily find out the distribution between different data within some intervals.

# How to use
Here is an example of constructing a histogram. Histogram is a bit complex for setup since it requires more details than other kinds of graphs.
```java
Config con = new Config();                          // Construct a new Config object
con.xunit = new String[] {"10:00", "11:00"};        // Set xunits to '10:00', '11:00'
con.yunit = new double[] {10, 20, 30, 40, 50};      // Set yunit to 10, 20, 30, 40, 50
con.xlabel = "Time";                                // Set x label to 'Time'
con.ylabel = "Rate";                                // Set y label to 'Rate'
con.title = "Time vs Rate";                         // Set title of the histogram to 'Time vs Rate'
con.width = 600;                                    // Set width of the graph to 600
con.height = 400;                                   // Set height of the graph to 400
Histogram hist = new Histogram(con);                // Apply configuration by passing the Config object to Histogram
Category c1 = new Category("teen", Color.ORANGE);   // Create a new category with name 'teen' and represents as ORANGE
Category c2 = new Category("adult", Color.BLUE);    // Create a new category with name 'adult' and represents as BLUE
// ---------- Section 10:00 ----------
Section s1 = new Section();                         // Create an empty new section
Bar b1_s1 = new Bar(1.25, c1);                      // Create a bar with y value to be 1.25 of the y units
Bar b2_s1 = new Bar(2.97, c2);                      // Create a bar with y value to be 2.97 of the y units
s1.addBar(b1_s1, b2_s1);                            // Add these two bars to the section1
// ---------- Section 11:00 ----------
Section s2 = new Section();                         // Create an empty new section
Bar b1_s2 = new Bar(2.11, c1);                      // Create a bar with y value to be 2.11 of the y units
Bar b2_s2 = new Bar(0.39, c2);                      // Create a bar with y value to be 0.39 of the y units
s2.addBar(b1_s2, b2_s2);                            // Add these two bars to the section2
hist.addSection(s1, s2);                            // Add these two sections to the histogram
hist.show();                                        // Call show() to show up the graph
```
More examples can be found in [here](https://github.com/NielXu/JPlot/blob/master/src/histogram/Demo.java)

# Images
![Img](https://github.com/NielXu/JPlot/blob/master/resources/histogram.jpg "histogram")
