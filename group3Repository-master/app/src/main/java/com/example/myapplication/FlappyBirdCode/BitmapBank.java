package com.example.myapplication.FlappyBirdCode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.myapplication.R;

public class BitmapBank {
    private static BitmapBank instance;
    private Bitmap background;
    private Bitmap[] bird;
    private Bitmap tubeTop, tubeBottom;

    private BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background_horizontal);
        background = scaleImage(background);

        bird = new Bitmap[4];
        if (InitialConfigurationScreenFlappybird.color) {
            bird[0] = BitmapFactory.decodeResource(res, R.drawable.blueflappy1);
            bird[1] = BitmapFactory.decodeResource(res, R.drawable.blueflappy2);
            bird[2] = BitmapFactory.decodeResource(res, R.drawable.blueflappy3);
            bird[3] = BitmapFactory.decodeResource(res, R.drawable.blueflappy3);
        } else {
            bird[0] = BitmapFactory.decodeResource(res, R.drawable.redflappy1);
            bird[1] = BitmapFactory.decodeResource(res, R.drawable.redflappy2);
            bird[2] = BitmapFactory.decodeResource(res, R.drawable.redflappy3);
            bird[3] = BitmapFactory.decodeResource(res, R.drawable.redflappy3);
        }

        tubeTop = BitmapFactory.decodeResource(res, R.drawable.toppillar);
        tubeBottom = BitmapFactory.decodeResource(res, R.drawable.bottompillar);
    }

    public static BitmapBank getInstance(Resources res) {
        if (instance == null) {
            instance = new BitmapBank(res);
        }
        return instance;
    }
    public Bitmap getTubeTop() {
        return tubeTop;
    }
    public Bitmap getTubeBottom() {
        return tubeBottom;
    }
    public int getTubeHeight() {
        return tubeTop.getHeight();
    }
    public int getTubeWidth() {
        return tubeTop.getWidth();
    }
    public Bitmap getBird(int frame) {
        return bird[frame];
    }
    public int getBirdHeight() {
        return bird[0].getHeight();
    }
    public int getBirdWidth() {
        return bird[0].getWidth();
    }
    public Bitmap getBackground() {
        return background;
    }
    public int getBackgroundWidth() {
        return background.getWidth();
    }
    public int getBackgroundHeight() {
        return background.getHeight();
    }
    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaleWidth = (int) (widthHeightRatio * AppConstants.SCREEN_HEIGHT);
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
