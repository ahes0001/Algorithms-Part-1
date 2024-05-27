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
    public void open(int row, int col)

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)

    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
//    public static void main(String[] args)


}
