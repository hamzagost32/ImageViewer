package com.hamza.imageviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv_display;
    private Button btn_right, btn_left;
    private int current_image_index;
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayImage();
        SwitchButton();
    }

    void DisplayImage(){
        iv_display = (ImageView)findViewById(R.id.iv_display);
    }

    void SwitchButton(){
        btn_right = (Button)findViewById(R.id.btn_right);
        btn_left = (Button)findViewById(R.id.btn_left);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index++;
                current_image_index = current_image_index % images.length;
                iv_display.setImageResource(images[current_image_index]);
            }
        });

        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_image_index--;

                if(current_image_index < 0){
                    current_image_index = images.length - 1;
                }
                iv_display.setImageResource(images[current_image_index]);
            }
        });
    }
}
