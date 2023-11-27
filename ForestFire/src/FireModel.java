public class FireModel
{
    public static int SIZE = 2;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */
   void recursiveFire(int r, int c, boolean trouble, int counter){
       if(trouble || c == SIZE || c == -1 || r == SIZE || myGrid[r][c].getStatus() == FireCell.DIRT) // base cases
           return;
       System.out.println(counter);
       counter++;
        if(r == 0) { // reached Onnet
            trouble = true;
            return;
        }
        //if cell is green then burn
        if(myGrid[r][c].getStatus() == FireCell.GREEN)
            myGrid[r][c].setStatus(FireCell.BURNING);

       recursiveFire(r,c+1,trouble,counter); // right
       recursiveFire(r-1,c,trouble,counter); //  up
       recursiveFire(r,c-1,trouble,counter); // left
   }

    public void solve()
    {
        boolean trouble = false;
        for(int c = 0; c < SIZE ;c++)
            recursiveFire(SIZE-1,c,trouble,0);

        if (trouble) System.out.println("YESSS BURN ONETT BURRRRRRRRRRRN!");

        else System.out.println("aww maaan nothing ever fun happens");
        // student code here
        myView.updateView(myGrid);
    }

}
