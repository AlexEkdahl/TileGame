package tilegame.gfx;

import tilegame.Game;
import tilegame.entities.Entity;

public class GameCamera {

    private Game game;
    private float xOffset;
    private float yOffset;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public void centerEntity(Entity entity) {
        xOffset = entity.getX() - game.getWidth() / 2 + entity.getWidth() / 2;
        yOffset = entity.getY() - game.getHeight() / 2 + entity.getHeight() / 2;
    }

    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
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
