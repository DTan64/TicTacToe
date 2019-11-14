import kotlin.Pair;


// This class actually plays the game


public class Game {


    private Board state;


    public Game(Board initialState) {
        state = initialState;

    }


    public Board getState() {return state;}




    // Hypothetical result of move in state
    public Board result(Pair<Integer, Integer> move, Board state) {

//        Board newState = new Board(state);
//
//        newState.makeMove(move);
//
//        return newState;
        return state;






    }


    public static void main(String[] args) {
        //Game newGame = new Game(new Board());







    }






}
