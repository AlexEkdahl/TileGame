package game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32;
    private static final int height = 32;
    public static BufferedImage grass, stone, water, cactus;
    public static BufferedImage[] player_down, player_left, player_right, player_up, player_idle;

    public static void init() {
        SpriteSheet redPanda = new SpriteSheet(ImageLoader.loadImage("/textures/Panda.png"));
        SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/Tiles.png"));
        player_down = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_idle = new BufferedImage[2];
        player_down[0] = redPanda.crop(0, 0, width, height);
        player_down[1] = redPanda.crop(width, 0, width, height);
        player_down[2] = redPanda.crop(width * 2, 0, width, height);
        player_down[3] = redPanda.crop(width, 0, width, height);

        player_left[0] = redPanda.crop(0, height, width, height);
        player_left[1] = redPanda.crop(width, height, width, height);
        player_left[2] = redPanda.crop(width * 2, height, width, height);
        player_left[3] = redPanda.crop(width, height, width, height);

        player_right[0] = redPanda.crop(0, height * 2, width, height);
        player_right[1] = redPanda.crop(width, height * 2, width, height);
        player_right[2] = redPanda.crop(width * 2, height * 2, width, height);
        player_right[3] = redPanda.crop(width, height * 2, width, height);

        player_up[0] = redPanda.crop(0, height*3, width, height);
        player_up[1] = redPanda.crop(width, height * 3, width, height);
        player_up[2] = redPanda.crop(width * 2, height * 3, width, height);
        player_up[3] = redPanda.crop(width, height * 3, width, height);

        player_idle[0] = redPanda.crop(0,height * 4,width,height);
        player_idle[1] = redPanda.crop(width,height * 4,width,height);


        //        grass[1] = tiles.crop(width, height * 2, width, height);
//        grass[2] = tiles.crop(width*2, height * 3, width, height);
//        grass[3] = tiles.crop(width*2, height * 5, width, height);

        grass = tiles.crop(width, height, width, height);
        stone = tiles.crop(width * 3, height, width, height);
        water = tiles.crop(0, height * 16, width, height);
        cactus = tiles.crop(0, height * 11, width, height);
    }

}
