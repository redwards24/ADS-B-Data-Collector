# ADS-B-Data-Collector
A program to collect, process, and visualize ADS-B data from [the OpenSky Network](https://opensky-network.org/).



## Introduction
This java program is a graphical interface to querying and processing state vector data from the OpenSky Network.
To use this program, you must have an account with OpenSky as well as access to their [historical database](https://opensky-network.org/data/historical-flight-data).

Also, this program uses MATLAB to visualize the state vector data. The program does not require MATLAB to be installed on you computer, but
the simulation aspect of the program will not work. The visualization part uses the [Mapping Toolbox](https://www.mathworks.com/help/map/), [Database Toolbox](https://www.mathworks.com/help/database/), and the [Image Processing Toolbox](https://www.mathworks.com/help/images/).

This project has only been tested on Windows 10.
To run this program, you will need to download the ADSBDataCollector.jar file as well as the database and resources folders into the same directory. 
This project uses java jdk 21 and MATLAB R2024a. <path_to_java>\java\jdk-21\bin and <path_to_matlab>\MATLAB\R2024\bin\win64 must be added to the system path.



## Use Cases
This program has two main functionalites: 
1. Colleting and Processing state vector data
2.  Plotting and Animating state vector data

### Collecting and Processing
The typical use case for collecting and processing is as follows:

1. Select a source of data.
   - The source can be:
     * The OpenSky Network
     * The Local Database
     * A CSV file (note: validation of file content has not been implemented, however the program should not crash and only show an error message if an invalid file is used)
   - To combine data sets, simply add more than one source to the list of sources
     
2. Select a destination for the data.
   - The destination can be:
     * The Local Database
     * A CSV file

3. Select filters
   - Currently, the filters available are:
     * Date and Time - limit the range of time of the data set
     * Boundary - limit the latitude and longitude limits of the data set
        - Box - select a north, south, east, and west limit
        - Center Point - select a center point, such as O'Hare International Airport, and define a radius, unit, and shape to calculate a boundary
     * Nulls - select columns to remove null values from, rows with null values in the specified columns will be removed
     * Duplicates - select columns to remove duplicates rows, for example, if columns lat and lon are selected, then no two rows will have the same lat and lon values, but two rows may have the same lat or lon value
     * Expired - remove rows based on lastcontact or lastposupdate values
     * Airlines - remove rows whose callsign does not belong to the selected airlines
   - If OpenSky is selected as a source, then filters can either be added to a query, which will be used to query OpenSky's database, or filters can be add to local processing, which means the filters will be applied using java methods
   - When querying OpenSky, you should at least have a Date and Time filter as well as a Boundary filter
   - To move data, do not select any filters
  
4. Start the process
   - If OpenSky is selected as a source, then you will be asked to enter your Trino/OpenSky username. After that you will be directed to the Trino login page. Once you have logged in and have been authenticated,
     then the program will continue its process.
   - If the process succesfully finished then you will get a message saying so. Otherwise, you will get an error message and can look at the log to determine what went wrong.
     i. The log is still being updated to give more debugging info
   - If the local database is chosen as the destination, then you will have to restart the program to see it show up as a selectable source. This should be fixed in the future.


### Plotting and Animating
The typical use case for ploting and animating is as follows:

1. Select a source of data.
   - The source can be:
     * The Local Database
     * A CSV file 
   - Currently, plotting and animating using a file as the source may not work every time. I would recommend storing data in the database, as it seems to work every time
  
2. Select flights to plot or animate.
   - Click on the source and then press the "Select Flights" button. A dialog will pop up for you to select from the flights in the source.
  
3. Configure settings
   - GeoPlot:
     * Line Style - the appearance of the line that connects points, can be none
     * Marker - the appearance of the marker used to mark points, can be none
     * Color - the color of the line and marker
   - Animate:
     * Basemap Zoom - determines the level of zoom of the basemap when MATLAB downloads it
     * Raster Width - determines the width of the basemap when MATLAB downloads it
     * Raster Height - determines the height of the basemap when MATLAB downloads it
     * Plane Scale - determines how MATLAB should resize the plane image
     * Figure Zoom - determines the level of zoom of the MATLAB figure
     * Resolution(dpi) - determines the dpi of the MATLAB figure if the figure saved (not the video)
     * Latitude Offset - fine tune the center point of the MATLAB figure
     * Longitude Offset - fine tune the center point of the MATLAB figure
     * Time Interval - determines how often a plane should be plotted, if set to 10, then a plane will be plotted every 10 seconds
   - When animating, the MATLAB figure should be fine tuned to fit every image with the figure frame. There is a button to open the figure that will show what will be animated.
  
4. Plot or Animate



## Folder Content
The database folder contains LocalDB.db which is used to store program information as well as state vectors.

The jars folder contains the external libraries used in this project.

The resources folder contains two images of airplanes. The image called AirplaneN.png is from MATLAB's [Communications Toolbox](https://www.mathworks.com/help/comm/).
More specifically, the image is from [Airplane Tracking Using ADS-B Signals](https://www.mathworks.com/help/comm/usrpradio/ug/airplane-tracking-using-ads-b-signals-2.html);
The other image is an edited version of AirplaneN.png.

The src folder contains the source code for this project.

## External Libraries
This project uses [SQLite](https://www.sqlite.org/) for local database storage.

This project uses [Trino JDBC](https://trino.io/docs/current/client/jdbc.html) for querying the OpenSky Network.

This project uses [FlatLaf](https://www.formdev.com/flatlaf/) for a better looking GUI.

This project uses [MATLAB Engine](https://www.mathworks.com/help/matlab/matlab_external/get-started-with-matlab-engine-api-for-java.html) for plotting and animating flight paths.
