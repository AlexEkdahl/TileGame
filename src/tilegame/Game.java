package tilegame;

import tilegame.display.Display;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private final String title;
    public int width;
    public int height;
    int x = 0;
    int fps = 60;
    private Display display;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();
    }

    private void tick() {
        x++;
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, width, height);
        //Draw here
        g.drawImage(Assets.down1, x, 0, null);
        //End drawing
        bs.show();
        g.dispose();
    }

    @Override
    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    public void run() {
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        init();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            //Prints fps
            if (timer >= 1000000000) {
                System.out.println("Frames per seconds " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
