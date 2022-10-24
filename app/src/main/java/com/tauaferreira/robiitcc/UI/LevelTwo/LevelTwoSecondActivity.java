package com.tauaferreira.robiitcc.UI.LevelTwo;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tauaferreira.robiitcc.R;
import com.tauaferreira.robiitcc.UI.LevelOne.LevelOneFourActivity;
import com.tauaferreira.robiitcc.Utils.BluetoothSocketClass;

public class LevelTwoSecondActivity extends AppCompatActivity {
    ImageView pccBlue,pccGreen,pccPink,pccYellow;
    TextView txtColors;
    Integer countCompleteLevel = 0;

    public boolean verifyColor(View v, String str){
        if (v.getId() == R.id.pccc_blue) {

            return str == "blue" ;

        } else if (v.getId() == R.id.pccc_yellow) {

            return str == "yellow" ;
        } else if (v.getId() == R.id.pccc_pink) {

            return str == "pink" ;
        } else if (v.getId() == R.id.pccc_green) {

            return str == "green" ;
        }
        return false;
    }


    public void SetViewColor(View v,Drawable drawable) {

        if (v.getId() == R.id.pccc_blue) {
            pccBlue.setImageDrawable(drawable);
        } else if (v.getId() == R.id.pccc_yellow) {
            pccYellow.setImageDrawable(drawable);
        } else if (v.getId() == R.id.pccc_pink) {
            pccPink.setImageDrawable(drawable);
        } else if (v.getId() == R.id.pccc_green) {
            pccGreen.setImageDrawable(drawable);
        }
    }

    View.OnDragListener dragListener = (v, event) -> {
        int dragEvent = event.getAction();

        BluetoothSocketClass btSocket = new BluetoothSocketClass();
        switch (dragEvent) {
            case DragEvent.ACTION_DRAG_ENTERED:

                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                final View view = (View) event.getLocalState();
                if (view.getId() == R.id.shape_blue) {

                    boolean verify = verifyColor(v, "blue");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_circle_blue_fill);

                        SetViewColor(v,drawable);
                        countCompleteLevel++;
                        if(countCompleteLevel > 3){

                            boolean sendMessage = btSocket.sendCommandToArduino("c");
                            startActivity(new Intent(getBaseContext(), LevelTwoThreeActivity.class));
                        }

                    }



//                    mTxt.setText("EI! Arraste a estrela, não o triângulo !!!!");

//                    boolean sendMessage = btSocket.sendCommandToArduino("e");


                } else if (view.getId() == R.id.shape_green) {
                    boolean verify = verifyColor(v, "green");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {

                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_circle_green_fill);
                        SetViewColor(v, drawable);
                        countCompleteLevel++;

                        if(countCompleteLevel > 3){

                            boolean sendMessage = btSocket.sendCommandToArduino("c");
                            startActivity(new Intent(getBaseContext(), LevelTwoThreeActivity.class));
                        }

                    }
                } else if (view.getId() == R.id.shape_orange) {
                    boolean verify = verifyColor(v, "orange");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {
//                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_shape_orange);
//                        SetViewColor(v, drawable);
                    }
                } else if (view.getId() == R.id.shape_pink) {
                    boolean verify = verifyColor(v, "pink");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_circle_pink_fill);
                        SetViewColor(v, drawable);
                        countCompleteLevel++;
                        if(countCompleteLevel > 3){

                            boolean sendMessage = btSocket.sendCommandToArduino("c");
                            startActivity(new Intent(getBaseContext(), LevelTwoThreeActivity.class));
                        }
                    }
                } else if (view.getId() == R.id.shape_violet) {
                    boolean verify = verifyColor(v, "violet");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {
//                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_shape_violet);
//                        SetViewColor(v, drawable);
                    }
                } else if (view.getId() == R.id.shape_yellow) {
                    boolean verify = verifyColor(v, "yellow");

                    if(!verify){
                        txtColors.setText("Ei! Arraste a cor certa para o lugar certo!");

                        boolean sendMessage = btSocket.sendCommandToArduino("e");
                    } else {
                        Drawable drawable = getResources().getDrawable(R.drawable.phases_create_connection_circle_yellow_fill);
                        SetViewColor(v, drawable);
                        countCompleteLevel++;
                        if(countCompleteLevel > 3){

                            boolean sendMessage = btSocket.sendCommandToArduino("c");
                            startActivity(new Intent(getBaseContext(), LevelTwoThreeActivity.class));
                        }
                    }
                }

                break;
        }
        return true;
    };

    View.OnLongClickListener longClickListener = v -> {
        ClipData data = ClipData.newPlainText("", "");
        View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);

        v.startDrag(data, myShadowBuilder, v, 0);

        return false;
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_phases_create_colors);

        ImageView btBack = findViewById(R.id.button_backArrow);
        btBack.setOnClickListener(v->{
            this.finish();
        });

        ImageView colorBlue = findViewById(R.id.shape_blue);
        ImageView colorGreen = findViewById(R.id.shape_green);
        ImageView colorOrange = findViewById(R.id.shape_orange);
        ImageView colorPink = findViewById(R.id.shape_pink);
        ImageView colorViolet = findViewById(R.id.shape_violet);
        ImageView colorYelow = findViewById(R.id.shape_yellow);

        txtColors = findViewById(R.id.txt_phrase_colors);
        txtColors.setText("Arraste a cor para seu nome!");

        colorBlue.setOnLongClickListener(longClickListener);
        colorGreen.setOnLongClickListener(longClickListener);
        colorOrange.setOnLongClickListener(longClickListener);
        colorPink.setOnLongClickListener(longClickListener);
        colorViolet.setOnLongClickListener(longClickListener);
        colorYelow.setOnLongClickListener(longClickListener);


         pccBlue = findViewById(R.id.pccc_blue);
         pccGreen = findViewById(R.id.pccc_green);
         pccPink = findViewById(R.id.pccc_pink);
         pccYellow = findViewById(R.id.pccc_yellow);

        pccBlue.setOnDragListener(dragListener);
        pccGreen.setOnDragListener(dragListener);
        pccPink.setOnDragListener(dragListener);
        pccYellow.setOnDragListener(dragListener);


    }
}
