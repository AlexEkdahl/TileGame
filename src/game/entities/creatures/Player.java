package game.entities.creatures;

import game.Handler;
import game.gfx.Animation;
import game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Player extends Creature {

    private Animation animDown, animLeft, animRight, animUp;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        speed = 5.0f;
        collisionBounds.x = 14;
        collisionBounds.y = 28;
        collisionBounds.width = 36;
        collisionBounds.height = 36;

        animDown = new Animation(200, Assets.player_down);
        animLeft = new Animation(200, Assets.player_left);
        animRight = new Animation(200, Assets.player_right);
        animUp = new Animation(200, Assets.player_up);

    }

    @Override
    public void tick() {
        animDown.tick();
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

//        g.setColor(Color.red);
//        g.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
//                collisionBounds.width,
//                collisionBounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if (xMove < 0){
            return animLeft.getCurrentFrame();
        } else if (xMove > 0){
            return animRight.getCurrentFrame();
        } else if (yMove < 0){
            return animUp.getCurrentFrame();
        } else if (yMove > 0){
            return animDown.getCurrentFrame();
        } else {
            return animUp.getCurrentFrame();
        }
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
