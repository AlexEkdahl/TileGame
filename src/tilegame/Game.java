package tilegame;

import tilegame.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public int width;
    public int height;
    private Display display;
    private Thread thread;
    private boolean running = false;
    private String title;

    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
    }

    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }

    private void tick() {
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //Draw here
        g.fillRect(0,0,width,height);



        //End drawing
        bs.show();
        g.dispose();

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
