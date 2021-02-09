package game.tiles;

import game.gfx.Assets;
import game.utils.Utils;

import java.awt.*;

public class GrassTile extends Tile {

    public GrassTile(int id) {
        super(Assets.grass, id);
    }

//    @Override
//    public void render(Graphics g, int x, int y){
//        g.drawImage(Assets.grass[Utils.randomGenerator(0,3)],x,y, TILE_WIDTH, TILE_HEIGHT, null);
//    }



}
