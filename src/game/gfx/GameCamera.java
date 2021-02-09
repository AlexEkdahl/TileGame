package game.gfx;

import game.Game;
import game.Handler;
import game.entities.Entity;
import game.tiles.Tile;

public class GameCamera {

    private Handler handler;
    private float xOffset;
    private float yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void checkUnrenderedSpace(){
        if (xOffset < 0){
            xOffset = 0;
        } else if (xOffset > handler.getWorldMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOffset = handler.getWorldMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }
        if (yOffset < 0){
            yOffset = 0;
        } else if (yOffset > handler.getWorldMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOffset = handler.getWorldMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public void centerEntity(Entity entity) {
        xOffset = entity.getX() - handler.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - handler.getHeight() / 2 + entity.getHeight() / 2;
        checkUnrenderedSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkUnrenderedSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;


    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;


    }

}
