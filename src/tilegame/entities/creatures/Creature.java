package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 32;
    public static final int DEFAULT_CREATURE_HEIGHT = 32;

    protected int health;
    protected float speed;
    protected float xMove;
    protected float yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        moveX();
        moveY();
    }

    public void moveX() {
        //moving right
        if (xMove > 0) {
            int tempX = (int) (x + xMove + collisionBounds.x + collisionBounds.width) / Tile.TILE_WIDTH;
            if (isNoCollisionWithBounderiesRightOrLeft(tempX)) {
                x += xMove;
            }
        } else if (xMove < 0) {
            int tempX = (int) (x + xMove + collisionBounds.x) / Tile.TILE_WIDTH;
            if (isNoCollisionWithBounderiesRightOrLeft(tempX)) {
                x += xMove;
            }
        }
    }

    public void moveY() {
        //moving up
        if (yMove < 0) {
            int tempY = (int) (y + yMove + collisionBounds.y) / Tile.TILE_HEIGHT;
            if (IsNoCollisionWithBounderiesTopOrDown(tempY)) {
                y += yMove;
            }
        } else if (yMove > 0) {
            int tempY = (int) (y + yMove + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT;
            if (IsNoCollisionWithBounderiesTopOrDown(tempY)) {
                y += yMove;
            }
        }
    }

    private boolean isNoCollisionWithBounderiesRightOrLeft(int tempX) {
        return isNoCollisionWithTile(tempX, (int) (y + collisionBounds.y) / Tile.TILE_HEIGHT) &&
               isNoCollisionWithTile(tempX, (int) (y + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT);
    }

    private boolean IsNoCollisionWithBounderiesTopOrDown(int tempY) {
        return isNoCollisionWithTile((int) (x + collisionBounds.x) / Tile.TILE_WIDTH, tempY) &&
               isNoCollisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / Tile.TILE_WIDTH, tempY);
    }

    protected boolean isNoCollisionWithTile(int x, int y) {
        return !handler.getWorldMap().getTile(x, y).isSolid();
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
