# Five-card-draw

Five-card draw is a variant of poker where each player receives a hand of 5 cards, is then
allowed to swap any number of those cards for new ones, and then competes against each
other based on the standard 5 card poker hand strength. This is a a Java console-based application 
which will deal and evaluate poker hands for a simplified version of the five-card draw variant. 

## Authors

- [@JurassicRegz](https://github.com/JurassicRegz)

## Development

This program is developed using Java, OpenJDK 11. <br />
Testing is done using JUnit 4.13. <br />
Program should be run in a bash terminal.

## Installation
 Download the Zip containing the code on the repo or clone the repository. <br />
 Once downloaded or cloned, open up the folder directory in your bash terminal and run:

 ``` bash
 sudo apt update && sudo apt install openjdk-11-jdk-headless -y
 ```
## Usage/Examples
In your bash terminal, run the shell script to compile and execute the program.

```bash
./run.sh
Shuffling ... Shuffling ... Shuffling ...
Your hand: 2♢ 5♡ 2♤ 3♧ 4♤ 
You have: One Pair

Do you wish to draw again? Y/N >
```

To run the Unit tests run the shell script with the -t flag.

```bash
./run.sh -t
Running Tests ...
Tests ran: 16
Failed: 0
```

## Structure
```
Five-card-draw
|
│   README.md
│   .gitignore     
│   run.sh                      //script to compile and run program, run with -t flag for tests
|
└─── lib                        //contains jar executables to aid in running tests with JUnit
│   |      
|   |   junit-4.13.2.jar
│   |   hamcrest-core-1.3.jar    
│   
└─── src                        //contains all Java source files
|   │   *
|
└─── test                       //contains all unit test classes
    |   *
```