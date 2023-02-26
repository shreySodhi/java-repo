import java.util.*;

public class MultiGoal implements Goal
{
    private List<Goal> goals;
    MultiGoal(){
        goals = new ArrayList<>();
    }

    @Override
    public boolean hasWon(int[] hand) {
        for(Goal g : goals)
            if(g.hasWon(hand))
                return true;
        return false;

    }

    void addGoal(Goal g ){
    goals.add(g);
}

}