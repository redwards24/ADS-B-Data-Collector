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
  (1) Colleting and Processing state vector data
  (2) Plotting and Animating state vector data

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
        i. Box - select a north, south, east, and west limit
        ii. Center Point - select a center point, such as O'Hare International Airport, and define a radius, unit, and shape to calculate a boundary
     * Nulls - select columns to remove null values from, rows with null values in the specified columns will be removed
     * Duplicates - select columns to remove duplicates rows, for example, if columns lat and lon are selected, then no two rows will have the same lat and lon values, but two rows may have the same lat or lon value
     * Expired - remove rows based on lastcontact or lastposupdate values
     * Airlines - remove rows whose callsign does not belong to the selected airlines
   - If OpenSky is selected as a source, then filters can either be added to a query, which will be used to query OpenSky's database, or filters can be add to local processing, which means the filters will be applied using java methods
   - When querying OpenSky, you should at least have a Date and Time filter as well as a Boundary filter
  
4. Start the process
   - If OpenSky is selected as a source, then you will be asked to enter your Trino/OpenSky username. After that you will be directed to the Trino login page. Once you have logged in and have been authenticated,
     then the program will continue its process.
   - If the process succesfully finished then you will get a message saying so. Otherwise, you will get an error message and can look at the log to determine what went wrong.
     i. The log is still being updated to give more debugging info
   - If the local database is chosen as the destination, then you will have to restart the program to see it show up as a selectable source. This should be fixed in the future.

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
