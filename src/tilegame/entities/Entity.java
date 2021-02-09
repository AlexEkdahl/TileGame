package tilegame.entities;

import tilegame.Game;

import java.awt.*;
import tilegame.Handler;


public abstract class Entity {

    protected Handler handler;
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle collisionBounds;

    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;

        collisionBounds = new Rectangle(0,0,width,height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
