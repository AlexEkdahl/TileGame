package tilegame.states;

import tilegame.Handler;
import tilegame.entities.creatures.Player;
import tilegame.maps.WorldMap;

import java.awt.*;

public class GameState extends State {

    private final Player player;
    private final WorldMap worldMap;

    public GameState(Handler handler) {
        super(handler);
        worldMap = new WorldMap(handler, "res/world/world1.txt");
        handler.setWorldMap(worldMap);
        player = new Player(handler, 100, 100);
    }

    @Override
    public void tick() {
        worldMap.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        worldMap.render(g);
        player.render(g);
    }

}
