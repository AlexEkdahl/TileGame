package game.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile stoneTile = new StoneTile(1);
    public static Tile waterTile = new WaterTile(2);
    public static Tile CactusTile = new CactusTile(3);

    protected BufferedImage texture;
    protected final int id;
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public int getId() {
        return id;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture,x,y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }
}
