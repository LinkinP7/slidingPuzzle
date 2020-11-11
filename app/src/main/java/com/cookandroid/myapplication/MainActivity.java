package com.cookandroid.myapplication;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.graphics.Canvas;
        import android.graphics.EmbossMaskFilter;
        import android.graphics.Paint;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("B584020 박진성 - 슬라이드 게임");

    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap puzzlePic[][] = new Bitmap[3][3];
            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.star1);
            int puzzleW = picture.getWidth() / 3;
            int puzzleH = picture.getHeight() / 3;
            int startPointW = 80;
            int startPointH = 600;

            Paint paint = new Paint();
            EmbossMaskFilter emboss=new EmbossMaskFilter(new float[]{1, 1, 1}, 0.5f, 1, 1);
            paint.setMaskFilter(emboss);

            puzzlePic[0][0] = Bitmap.createBitmap(picture, 0, 0, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[1][0] = Bitmap.createBitmap(picture, picture.getWidth() / 3, 0, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[2][0] = Bitmap.createBitmap(picture, picture.getWidth() / 3 * 2, 0, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[0][1] = Bitmap.createBitmap(picture, 0, picture.getHeight() / 3, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[1][1] = Bitmap.createBitmap(picture, picture.getWidth() / 3, picture.getHeight() / 3, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[2][1] = Bitmap.createBitmap(picture, picture.getWidth() / 3 * 2, picture.getHeight() / 3, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[0][2] = Bitmap.createBitmap(picture, 0, picture.getHeight() / 3 * 2, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[1][2] = Bitmap.createBitmap(picture, picture.getWidth() / 3, picture.getHeight() / 3 * 2, picture.getWidth() / 3, picture.getHeight() / 3);
            puzzlePic[2][2] = Bitmap.createBitmap(picture, 0, 0, 1, 1);

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    canvas.drawBitmap(puzzlePic[i][j], startPointW+i*puzzleW ,startPointH+j*puzzleH, paint);
                }
            }
        }
    }
}