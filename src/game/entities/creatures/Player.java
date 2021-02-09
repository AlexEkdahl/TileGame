package game.entities.creatures;

import game.Handler;
import game.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        speed = 5.0f;
        collisionBounds.x = 7;
        collisionBounds.y = 14;
        collisionBounds.width = 18;
        collisionBounds.height = 18;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.panda, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        g.setColor(Color.red);
        g.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
                collisionBounds.width,
                collisionBounds.height);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }
    }

}
