import java.util.ArrayList;

public class Bot implements Player
{
	int [] hand;
    ArrayList<Goal> goals;
    Goal g;
    Bot(int[] hand, Goal g ){
        init(hand, g);

    }

    public void setG(Goal g) {
        if( g instanceof MultiGoal){ //performs if x is a AllSameGoal
            MultiGoal temp = (MultiGoal) g; // You can now cast safely
        }
    }

    public void init(int[] h, Goal g)
    {
        G 
        hand = h;
    }

    @Override
    public void maybeReplaceCard(int card) {

    }
}