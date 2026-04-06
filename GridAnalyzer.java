import java.util.Scanner;
public class GridAnalyzer {
    
    // scanner for user input
    private static Scanner scanner = new Scanner(System.in);
    
    // the gobal variables used in this class
    private static int[][] grid;
    private static int rows;
    private static int cols;
    
    //entry point of the program: initializes the grid and runs the menu driven system
    public static void main(String[] args) {

        System.out.println("GRID ANALYZER");
        
        // initialize grid dimensions (the minimum is 6 rows and 6 columns)
        System.out.print("enter a number of rows youd like the grid to have (minimum is 6): ");
        rows = scanner.nextInt();
        if(rows < 6){
            System.out.println("failed to initialize row size. reason: attempted to initialize a value less than 6. solution: a value of 6 has been initialized as the row size.");
            rows = 6;
        }
        System.out.print("enter a number of columns youd like the grid to have (minimum is 6): ");
        cols = scanner.nextInt();
        if(cols < 6){
            System.out.println("failed to initialize column size. reason: attempted to initialize a value less than 6. solution: a value of 6 has been initialized as the column size.");
            cols = 6;
        }

        // initializes the user entered values to the grid size
        grid = new int[rows][cols];
        
        // prompt initializtation of the values within the grid to the user
        System.out.println("Initialize the Grid");
        System.out.println("You will need to enter " + (rows * cols) + " values for the " + rows + "x" + cols + " grid:");

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print("Assign a vlaue to Grid[" + r + "][" + c + "]: ");
                grid[r][c] = scanner.nextInt();
            }
        }
        
        System.out.println("grid initialized successfully.");
        
        // Run menu-driven system
        runMenuSystem();
        
        scanner.close();
        System.out.println("thank you for using my grid analyzer. goodbye.");
    }
    
    // ALGORITHM 10: Menu-Driven System. provides the user with an interactive menu to enable the user to select operations of their choice
    public static void runMenuSystem() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice (0-6): ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                displayGrid();
            } 
            else if (choice == 2) {
                rowColumnAggregation();
            } 
            else if (choice == 3) {
                findGlobalMaxMin();
            } 
            else if (choice == 4) {
                frequencyCounter();
            } 
            else if (choice == 5) {
                patternDetection();
            } 
            else if (choice == 6) {
                transformGrid();
            } 
            else if (choice == 0) {
                running = false;
                continue;
            } 
            else {
                System.out.println("invalid choice. Please select a choice 0-6.");
            }
            
            if (running && choice >= 1 && choice <= 6) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
    }
    
    //Displays the main menu options
    public static void displayMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. Display Grid");
        System.out.println("2. Row/Column Sums (Aggregation)");
        System.out.println("3. Find Max/Min with Position");
        System.out.println("4. Frequency Check");
        System.out.println("5. Pattern Detection (Increasing Sequence)");
        System.out.println("6. Transform Grid (Rotate/Swap/Reverse)");
        System.out.println("0. Exit");
    }
    
    //ALGORITHM 1: Row & Column Aggregation (Computes sum of each row and each column, stores in 1D arrays)
    public static void rowColumnAggregation() {
        System.out.println("ALGORITHM 1: Row & Column Aggregation");
        
        int[] rowSums = new int[rows];
        int[] colSums = new int[cols];
        
        for (int r = 0; r < rows; r++) {
            int sum = 0;
            for (int c = 0; c < cols; c++) {
                sum += grid[r][c];
            }
            rowSums[r] = sum;
        }
        
        for (int c = 0; c < cols; c++) {
            int sum = 0;
            for (int r = 0; r < rows; r++) {
                sum += grid[r][c];
            }
            colSums[c] = sum;
        }
        
        System.out.println("Row Sums:");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + i + ": " + rowSums[i]);
        }
        
        System.out.println("Column Sums:");
        for (int j = 0; j < cols; j++) {
            System.out.println("Col " + j + ": " + colSums[j]);
        }
        
        System.out.println("ALGORITHM 4: Row & Column Comparison");
        
        int maxRowSum = rowSums[0];
        int maxRowIndex = 0;
        for (int i = 1; i < rows; i++) {
            if (rowSums[i] > maxRowSum) {
                maxRowSum = rowSums[i];
                maxRowIndex = i;
            }
        }
        
        int mincolumnSum = colSums[0];
        int minColIndex = 0;
        for (int x = 1; x < cols; x++) {
            if (colSums[x] < mincolumnSum) {
                mincolumnSum = colSums[x];
                minColIndex = x;
            }
        }
        
        System.out.println("row with highest sum: Row " + maxRowIndex + " (Sum: " + maxRowSum + ")");
        System.out.println("column with lowest sum: Col " + minColIndex + " (Sum: " + mincolumnSum + ")");
    }
    
    //ALGORITHM 2: Global Max & Min with Position. finds maximum and minimum values and their exact positions
    public static void findGlobalMaxMin() {
        System.out.println("ALGORITHM 2: Global Max & Min with Position");
        
        int maxVal = grid[0][0];
        int maxRow = 0;
        int maxCol = 0;
        
        int minVal = grid[0][0];
        int minRow = 0;
        int minCol = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxRow = r;
                    maxCol = c;
                }
                if (grid[r][c] < minVal) {
                    minVal = grid[r][c];
                    minRow = r;
                    minCol = c;
                }
            }
        }
        
        System.out.println("max value: " + maxVal);
        System.out.println("position: (" + maxRow + ", " + maxCol + ")");
        System.out.println("min Value: " + minVal);
        System.out.println("position: (" + minRow + ", " + minCol + ")");
    }
    
    // ALGORITHM 3: Frequency Counter. counts the number of occurrences of a specific value and values above a certain specified threshold
    public static void frequencyCounter() {
        System.out.println("ALGORITHM 3: Frequency Counter");
        
        System.out.print("Enter specific value to count: ");
        int targetValue = scanner.nextInt();
        
        System.out.print("Enter threshold value: ");
        int threshold = scanner.nextInt();
        int specificCount = 0;
        int aboveThresholdCount = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == targetValue) {
                    specificCount++;
                }
                if (grid[r][c] > threshold) {
                    aboveThresholdCount++;
                }
            }
        }
        
        System.out.println("results:");
        System.out.println("occurrences of " + targetValue + ": " + specificCount);
        System.out.println("values greater than " + threshold + ": " + aboveThresholdCount);
    }
    
    // ALGORITHM 5: Pattern Detection (Increasing Sequence). checks if any row is strictly increasing, returns the row index or -1
    public static void patternDetection() {
        System.out.println("ALGORITHM 5: Pattern Detection");
        System.out.println("checking for strictly increasing rows");
        
        int increasingRowIndex = -1;
        
        for (int r = 0; r< rows; r++) {
            boolean isStrictlyIncreasing = true;
            
            for (int c = 0; c < cols - 1; c++) {
                if (grid[r][c] >= grid[r][c +1]) {
                    isStrictlyIncreasing = false;
                    break;
                }
            }
            
            if (isStrictlyIncreasing) {
                increasingRowIndex = r;
                break;
            }
        }
        
        if (increasingRowIndex != -1) {
            System.out.println("strictly increasing row found at index: " + increasingRowIndex);
            System.out.print("row contents: ");
            for (int i = 0; i< cols; i++) {
                System.out.print(grid[increasingRowIndex][i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("no strictly increasing row found, value -1 has been returned");
        }
    }
    
    //ALGORITHM 6: Grid Transformation. implements rotate row right
    public static void transformGrid() {
        System.out.println("ALGORITHM 6: Grid Transformation");
        
        System.out.println("Current Grid:");
        displayGrid();
        
        System.out.println("Transformation Options:");
        System.out.println("1. Rotate a row right by 1");
        System.out.print("Select transformation (1): ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            rotateRowRight();
        }
        else {
            System.out.println("invalid choice.");
            return;
        }
        
        System.out.println("grid after transformation:");
        displayGrid();
    }
    
    // this is a helper method: shifts a specific row to the right by 1 position
    public static void rotateRowRight() {
        System.out.print("Enter row index to rotate (0-" + (rows-1) + "): ");
        int rowIndex = scanner.nextInt();
        
        if (rowIndex < 0 || rowIndex >= rows) {
            System.out.println("invalid row index");
            return;
        }
        
        int lastElement = grid[rowIndex][cols - 1];
        
        for (int i = cols - 1; i > 0; i--) {
            grid[rowIndex][i] = grid[rowIndex][i - 1];
        }
        
        grid[rowIndex][0] = lastElement;
        
        System.out.println("row " + rowIndex + " shifted to the right by 1 position.");
    }
    
    //Helper method: displays the current state of the grid. used by menu option 1 and other methods
    public static void displayGrid() {
        System.out.println("current grid (" + rows + "x" + cols + ")");
        
        for (int j = 0; j < cols; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        for (int i = 0; i < rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
