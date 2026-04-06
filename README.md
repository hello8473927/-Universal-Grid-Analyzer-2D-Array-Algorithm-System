# Universal Grid Analyzer

## Student Name
Mohammad Ahmad Kadi Amin

## Description of System
The Universal Grid Analyzer is a command line based tool that is built on java, it allows the user ot analyze, manipulte, and perform checks on a data set in the form of 2D integer arrays. This system is designed in a way such that any grid can be inputed as long as it has a minimum grid size of 6x6, allowing it to be used on a general basis. it is simple to use due to its menu interface that allows users to navigate through the features this commandline app provides such as aggregation, pattern detection, transformation, and validation operations. this program implements its features through the usage of nested for loops which helps it stand out from hard coded solutions.

## explanation of the algorithms

### Algorithm 1: Row & Column Aggregation
it calculates the sum of each row and each column using nested for loops. the row sums are calculated through the itteration of each row and summing values across columns. column sums are calculated by iterating through each column and summing values across rows. the results are then stored in separate a 1D array.

### Algorithm 2: Global Max & Min with Position
traverses through the entire grid to find the max and min values. initializes tracking variables with the first element, then compares every suceeding element. when a new max or min is found, it updates both the value and its coordinates (row, column).

### Algorithm 3: Frequency Counter
counts the number of occurrences of a user specified target value and counts amount of values that exceed the user defined threshold. uses nested loops to scan the grid and increment counters based on conditional checks.

### Algorithm 4: Row & Column Comparison
is used within algorithm 1. after calculating sums, identifies the row with the highest sum and the column with the lowest sum by iterating through the sum arrays and tracking indexes of extreme values.

### Algorithm 5: Pattern Detection
checks if the rows are increasing from left to right, through the usage of nested loops to compre adjacent elements. returns the index of the increasing row but returns -1 if it doesnt exist

### Algorithm 6: Grid Transformation
provides three transformation options:
shift elements on a row to the right by one position, swap two rows (through the usage of a temporary array), and reverse a column (uses a two pointer approach swapping top and bottom elements).

### Algorithm 7: Subgrid Processing
accepts user specified boundaries rowStart, rowEnd, colStart, and colEnd then calculates the sum and returns maximum value within that rectangular region. validates the boundaries before processing.

### Algorithm 8: Boundary & Diagonal Processing
extracts and displays boundary elements (perimeter of grid) in clockwise order, main diagonal (which is from top left to bottom right), and a secondary diagonal (which is from top right to bottom left).

### Algorithm 9: Validation Algorithm
checks if there are repeating values within a row through the usage of nested for loops. and it returns true if elements are repeated but false if not it returns false

### Algorithm 10: Menu System
helps provide a more user friendly experience through the usage of if chains (for option selection) and loops (to prevent the app from closing after compiling a option),

## Sample Output
GRID ANALYZER
enter a number of rows youd like the grid to have (minimum is 6): 6
enter a number of columns youd like the grid to have (minimum is 6): 6
Initialize the Grid
You will need to enter 36 values for the 6x6 grid:
Assign a vlaue to Grid[0][0]: 1
Assign a vlaue to Grid[0][1]: 2
Assign a vlaue to Grid[0][2]: 3
Assign a vlaue to Grid[0][3]: 4
Assign a vlaue to Grid[0][4]: 5
Assign a vlaue to Grid[0][5]: 6
[... continues for all 36 values ...]
Grid initialized successfully!
MAIN MENU

1. Display Grid
2. Row/Column Sums (Aggregation)
3. Find Max/Min with Position
4. Frequency Check
5. Pattern Detection (Increasing Sequence)
6. Transform Grid (Rotate/Swap/Reverse)
7. Subgrid Analysis
8. Boundary & Diagonals
9. Validation Check (Duplicate Detection)
0. Exit
Enter your choice (0-9): 1

    current grid (6x6)
    0 1 2 3 4 5
    0 1 2 3 4 5 6
    1 7 8 9 10 11 12
    2 13 14 15 16 17 18
    3 19 20 21 22 23 24
    4 25 26 27 28 29 30
    5 31 32 33 34 35 36
    Press Enter to continue...

Enter your choice (0-9): 2
ALGORITHM 1: Row & Column Aggregation
Row Sums:
Row 0: 21
Row 1: 57
Row 2: 93
Row 3: 129
Row 4: 165
Row 5: 201
Column Sums:
Col 0: 91
Col 1: 102
Col 2: 113
Col 3: 124
Col 4: 135
Col 5: 146
ALGORITHM 4: Row & Column Comparison
row with highest sum: Row 5 (Sum: 201)
column with lowest sum: Col 0 (Sum: 91)
Press Enter to continue...
Enter your choice (0-9): 3
ALGORITHM 2: Global Max & Min with Position
max value: 36
position: (5, 5)
min Value: 1
position: (0, 0)
Press Enter to continue...
Enter your choice (0-9): 4
ALGORITHM 3: Frequency Counter
Enter specific value to count: 5
Enter threshold value: 20
results:
occurrences of 5: 1
values greater than 20: 16
Press Enter to continue...
Enter your choice (0-9): 5
ALGORITHM 5: Pattern Detection
checking for strictly increasing rows
strictly increasing row found at index: 0
row contents: 1 2 3 4 5 6
Press Enter to continue...
Enter your choice (0-9): 6
ALGORITHM 6: Grid Transformation
Current Grid:
current grid (6x6)
0 1 2 3 4 5
0 1 2 3 4 5 6
1 7 8 9 10 11 12
2 13 14 15 16 17 18
3 19 20 21 22 23 24
4 25 26 27 28 29 30
5 31 32 33 34 35 36
Transformation Options:

1. Rotate a row right by 1
2. Swap two rows
3. Reverse a column
    Select transformation (1-3): 1
    Enter row index to rotate (0-5): 0
    row 0 shifted to the right by 1 position.
    grid after transformation:
    current grid (6x6)
    0 1 2 3 4 5
    0 6 1 2 3 4 5
    [... rest of grid ...]
    Press Enter to continue...

Enter your choice (0-9): 0
Thank you for using Universal Grid Analyzer. Goodbye!


## Challenges Faced
one of the main and i believe the only challenge i faced, was time, this project was quite time consuming because of the amount of testing it took to get it just write, another one that was minor was knowing what logic to use, since it was somewhta specified, it wasnt exactly too hard to jsut follow instructons.
