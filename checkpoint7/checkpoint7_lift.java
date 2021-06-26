        /*********************************Some texts you may use (Checkpoint7) ********************************
         * Typos isn't to blame for the zero, here are the text you'll need.
         * "Now it's on idle state."
         * "Moving,lift is on floor==>"
         * "Now it's on loading/unloading state."
         * Noted that if you change the name of a file, you may also need to check if the code that isn't 
         * marked as TODO may need to be modified as well.
         *****************************************************************************************************/
import java.util.*;    

public class checkpoint7_lift implements Runnable{

    //Description : Define all states of the lift.
    checkpoint7_baseState loading, idle, moving, current;

    //Description : Define the destination list.
    ArrayList<Integer> dList = new ArrayList<>();

    //Description : Define the current destination floor.
    protected Integer targetFloor;

    //Description : Define the current floor at which the lift is.
    protected Integer currentFloor;

    //Description : Set the idel state to current state and the lift is on first floor.
    //This is a constructor
    public checkpoint7_lift(ArrayList<Integer> destination){
    /*********************************The TODO This Time (Checkpoint7) ********************************
     * 
     * TODO(1): Here you have to set up the constructor.
     * Hint1: First you need to create objects of three states, and set the current state to idle state.
     * Hint2: Set up the dList bases on destination be passed in.
     * Hint3: Set the current floor to 1, and set the target floor by method next().
     * 
     **********************************The End of the TODO**************************************/

    /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/

    idle  = new checkpoint7_idleState();
    loading = new checkpoint7_loadingState();
    moving = new checkpoint7_movingState();

    for (int i = 0; i < destination.size(); i ++){

        dList.add(destination.get(i));

    }
    current = idle;
    this.currentFloor = 1;
    this.targetFloor = this.next();

        
    /********************************************************************************************
     END OF YOUR CODE
     ********************************************************************************************/

    }

    //Description : Define the run method for this thread.
    @Override
    public void run(){

        while(targetFloor != null){
            current = current.doState(this);
            doNothing();
        }
        //After the lift stop, it will print out this line.
        System.out.println("Now it's on idle state.");
    }

    //Description : Offer a new destination from the list.
    protected Integer next(){
    /*********************************The TODO This Time (Checkpoint7) ********************************
     * 
     * TODO(2): Here you have to offer a new destination from the list once this method is called.
     * Hint1: You have to alway return the first element from the destination list, also remove the first
     * element upon returning.
     * Hint2: Return null if the dList has nothing left.
     * 
     **********************************The End of the TODO**************************************/

    /********************************************************************************************
     START OF YOUR CODE
     ********************************************************************************************/

    if(dList.isEmpty())
        return null;
    else{

        int a = dList.get(0);
        dList.remove(0);
        return a;

    }



    /********************************************************************************************
     END OF YOUR CODE
     ********************************************************************************************/

    }


    //Description : Make the thread pause for seconds.
    public void doNothing(){

        try{Thread.sleep(500);}
        catch(InterruptedException err){}

    }
    

}
