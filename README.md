# ADS-B-Data-Collector
A program to collect, process, and visualize ADS-B data from [the OpenSky Network](https://opensky-network.org/).



## Introduction
This java program is a graphical interface to querying and processing state vector data from the OpenSky Network.
To use this program, you must have an account with OpenSky as well as access to their [historical database](https://opensky-network.org/data/historical-flight-data).

Also, this program uses MATLAB to visualize the state vector data. The program does not require MATLAB to be installed on you computer, but
the simulation aspect of the program will not work. The visualization part uses the [Mapping Toolbox](https://www.mathworks.com/help/map/), [Database Toolbox](https://www.mathworks.com/help/database/), and the [Image Processing Toolbox](https://www.mathworks.com/help/images/).

### Launching the Program
This project has only been testing on Windows 10.
To run this program, you will need to download the ADSBDataCollector.jar file as well as the database and resources folders into the same directory. 
This project uses java jdk 21 and MATLAB R2024a. <path_to_java>\java\jdk-21\bin and <path_to_matlab>\MATLAB\R2024\bin\win64 must be added to the system path.

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
