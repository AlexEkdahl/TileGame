package game.entities.creatures;

import game.Handler;
import game.entities.Entity;
import game.tiles.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;

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
            } else {
                x = tempX * Tile.TILE_WIDTH - collisionBounds.x - collisionBounds.width -1;
            }
        } else if (xMove < 0) {
            int tempX = (int) (x + xMove + collisionBounds.x) / Tile.TILE_WIDTH;
            if (isNoCollisionWithBounderiesRightOrLeft(tempX)) {
                x += xMove;
            }else {
                x = tempX * Tile.TILE_WIDTH + Tile.TILE_WIDTH -collisionBounds.x;
            }
        }
    }

    public void moveY() {
        //moving up
        if (yMove < 0) {
            int tempY = (int) (y + yMove + collisionBounds.y) / Tile.TILE_HEIGHT;
            if (IsNoCollisionWithBounderiesTopOrDown(tempY)) {
                y += yMove;
            } else {
                y = tempY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - collisionBounds.y;
            }
        } else if (yMove > 0) {
            int tempY = (int) (y + yMove + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT;
            if (IsNoCollisionWithBounderiesTopOrDown(tempY)) {
                y += yMove;
            } else {
                y = tempY * Tile.TILE_HEIGHT - collisionBounds.y - collisionBounds.height -1;
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
