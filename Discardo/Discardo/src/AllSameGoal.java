public class AllSameGoal implements Goal
{
    private int n;
	AllSameGoal(int n){
        this.n = n;
    }

    @Override
    public boolean hasWon(int[] hand) {
        for(int x: hand)
            if(x!=n)
                return false;
        return true;

    }
}