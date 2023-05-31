package com.jgrburke.charttest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Layout;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jgrburke.charttest.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    protected LinearLayout DrawLayout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

    //    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
   //     appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
   //     NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawLayout = findViewById(R.id.draw);

        final ChartTestView view1 = new ChartTestView(this);
        DrawLayout.addView(view1);
        view1.setBackgroundColor(Color.WHITE);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        /*
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();

         */
        return true;
    }


    public class ChartTestView extends View {
        Paint paintBlack = new Paint();
        Paint paintBlack2 = new Paint();
        Paint paintBlack3 = new Paint();
        Paint paintBlack4 = new Paint();
        Paint paintBlackLine = new Paint();
        Paint paintWhiteLine = new Paint();
        Paint paintRed = new Paint();
        Paint paintBlue= new Paint();
        Paint paintDkGrey = new Paint();
        Paint paintLtGrey = new Paint();
        Paint paintWhite = new Paint();
        Paint paintWhiteGC = new Paint();
        Paint paintWhite3 = new Paint();
        Paint paintYellow = new Paint();
        Paint paintYellow2 = new Paint();
        Paint paintOrange = new Paint();
        Paint paintGreen = new Paint();
        //      Paint paintLine = new Paint();
        Paint paintShade = new Paint();
        Paint paintDOTTEDLINE = new Paint();




        boolean buttonPressed;
        boolean sizeChanged;
        int width,height;


        float sx,sy;

        float endPreviousX;
        float endPreviousY;
        float yTop,yBottom;
        float previousX,previousY;






        public ChartTestView(Context context) {
            super(context);
            paintBlack.setColor(Color.BLACK);
            paintBlack2.setColor(Color.BLACK);
            paintBlack3.setColor(Color.BLACK);

            paintDkGrey.setColor(Color.DKGRAY);
            paintLtGrey.setColor(Color.LTGRAY);
            paintWhite.setColor(Color.WHITE);
            paintWhiteGC.setColor(Color.WHITE);
            paintWhite3.setColor(Color.WHITE);

            paintYellow2.setColor(Color.YELLOW);


            paintGreen.setColor(Color.parseColor("#4eb400"));
            paintYellow.setColor(Color.parseColor("#f7e400"));
            paintOrange.setColor(Color.parseColor("#f88700"));
            paintRed.setColor(Color.parseColor("#e82c0e"));
            paintBlue.setColor(Color.parseColor("#998cff"));

            buttonPressed=false;
            sizeChanged=false;

            paintGreen.setStyle(Paint.Style.FILL_AND_STROKE);
            paintGreen.setAntiAlias(true);
            paintYellow.setStyle(Paint.Style.FILL_AND_STROKE);
            paintYellow.setAntiAlias(true);
            paintOrange.setStyle(Paint.Style.FILL_AND_STROKE);
            paintOrange.setAntiAlias(true);
            paintRed.setStyle(Paint.Style.FILL_AND_STROKE);
            paintRed.setAntiAlias(true);
            paintBlue.setStyle(Paint.Style.FILL_AND_STROKE);
            paintBlue.setAntiAlias(true);
            paintBlackLine.setColor(Color.BLACK);
            paintBlackLine.setStrokeWidth(8f);
            paintBlackLine.setStyle(Paint.Style.STROKE);
            paintWhiteLine.setColor(Color.WHITE);
            paintWhiteLine.setStrokeWidth(8f);
            paintWhiteLine.setStyle(Paint.Style.STROKE);

            paintLtGrey.setStrokeWidth(2f);
            paintDkGrey.setStrokeWidth(2f);
            paintWhiteGC.setStrokeWidth(3f);



        }






        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);

            if (widthSize < heightSize) {
                width = widthSize;
                height = widthSize;
            } else {
                width = heightSize;
                height = heightSize;
            }

            setMeasuredDimension(width,height);
        }


        @Override
        public void onDraw(Canvas canvas) {
       //    float width,height;
            float textSize;
            float lineLength;
            float lineSegment;
            int ii,jj,kk;
            String color1,color2;

            String badStartTime,badEndTime;



            float rightJustifiedX;
            float verticalAdjustedY;
            Log.i(String.valueOf(width),"**");
       //     float l=width * .25;
          //  float r=(float)width * .75;
            float l = (float)width * 1 / 4;
            float r = (float)width * 3 / 4;
            float t = (float)width * 1 / 4;
            float b = (float)width * 3 / 4;
            RectF rect1 = new RectF(l,t,r,b);
            canvas.drawArc(rect1,-90F,90F,true,paintRed);

         //   RectF rect2 = new RectF(20,20,800,800);
            canvas.drawArc(rect1,0F,45F,true,paintBlue);

        //    RectF rect3 = new RectF(20,20,800,800);
            canvas.drawArc(rect1,45F,225F,true,paintGreen);

            textSize=paintBlack.getTextSize();
            paintBlack.setTextSize(textSize * 2.5f);

            canvas.drawRect(10,width - 100,800,width-70,paintOrange);
            canvas.drawText("aaaa%", 810,width-70,paintBlack);
            canvas.drawRect(10,width - 60,700,width-30,paintYellow);
            canvas.drawText("bbbb%", 707,width-30,paintBlack);














        }





    }




}