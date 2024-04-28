# ADS-B-Data-Collector
A program to collect, process, and visualize ADS-B data from [the OpenSky Network](https://opensky-network.org/).



## Introduction
This java program is a graphical interface to querying and processing state vector data from the OpenSky Network.
To use this program, you must have an account with OpenSky as well as access to their [historical database](https://opensky-network.org/data/historical-flight-data).

Also, this program uses MATLAB to visualize the state vector data. The program does not require MATLAB to be installed on you computer, but
the simulation aspect of the program will not work.

To run this program, you will need to download the ADSBDataCollector.jar file as well as the database and resources folders into the same directory.



## External Libraries
This project uses [SQLite](https://www.sqlite.org/) for local database storage.

This project uses [Trino JDBC](https://trino.io/docs/current/client/jdbc.html) for querying the OpenSky Network.

This project uses [FlatLaf](https://www.formdev.com/flatlaf/) for a better looking GUI.

This project uses [MATLAB Engine](https://www.mathworks.com/help/matlab/matlab_external/get-started-with-matlab-engine-api-for-java.html) for plotting and animating flight paths.
