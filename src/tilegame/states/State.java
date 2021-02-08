package tilegame.states;

import tilegame.Game;

import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public static State getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(State state) {
        currentState = state;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
