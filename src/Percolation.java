import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final boolean[][] grid;
    private final int n;
    private int openSitesCount;
    private final WeightedQuickUnionUF uf;
    private final int topVirtualSite;
    private final int bottomVirtualSite;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        openSitesCount = 0;
        uf = new WeightedQuickUnionUF(n * n + 2);
        topVirtualSite = n * n;
        bottomVirtualSite = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IndexOutOfBoundsException("Indices are out of bounds");
        }

        int givenSite = row*this.n + col;
        if (!isOpen(row,col)){
            openSitesCount++;
            // Connect to virtual top site if in the top row
            if (row == 0) {
                uf.union(givenSite, topVirtualSite);
            }

            // Connect to virtual bottom site if in the bottom row
            if (row == n - 1) {
                uf.union(givenSite, bottomVirtualSite);
            }

            grid[row][col] = true;
            if (col+1 < this.n){
                this.uf.union(givenSite,givenSite+1 );
            }
            if (col-1 >= 0) {
                this.uf.union(givenSite,givenSite-1 );
            }
            if (row+1 < this.n) {
                this.uf.union(givenSite,givenSite+this.n );
            }
            if (col-1 >= 0) {
                this.uf.union(givenSite,givenSite-this.n );
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IndexOutOfBoundsException("Indices are out of bounds");
        }
        return grid[row][col];}

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IndexOutOfBoundsException("Indices are out of bounds");
        }

    }

    // returns the number of open sites
    public int numberOfOpenSites(){return openSitesCount;}

    // does the system percolate?
    public boolean percolates(){
        return uf.find(topVirtualSite) == uf.find(bottomVirtualSite);
    }



    // Method to print the grid (for visualization purposes)
    public void printGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((grid[i][j] ? "O" : "X") + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        Percolation perc = new Percolation(3);
        perc.printGrid(); // Print the initial state of the grid
    }

}
