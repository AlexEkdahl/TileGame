package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32;
    private static final int height = 32;
    public static BufferedImage down1, down2, down3;
    public static BufferedImage left1, left2, left3;
    public static BufferedImage right1, right2, right3;
    public static BufferedImage up1, up2, up3;

    public static void init() {
        SpriteSheet blackDog = new SpriteSheet(ImageLoader.loadImage("/textures/BlackDog.png"));
        down1 = blackDog.crop(0, 0, width, height);
        down2 = blackDog.crop(width, 0, width, height);
        down3 = blackDog.crop(width * 2, 0, width, height);
        left1 = blackDog.crop(0, height, width, height);
        left2 = blackDog.crop(width, height, width, height);
        left3 = blackDog.crop(width * 2, height, width, height);
        right1 = blackDog.crop(0, height*2,width,height);
        right2 = blackDog.crop(width, height*2,width,height);
        right3 = blackDog.crop(width*2, height*2,width,height);
        up1 = blackDog.crop(0,height*3,width,height);
        up2 = blackDog.crop(width,height*3,width,height);
        up3 = blackDog.crop(width*2,height*3,width,height);



    }

}
