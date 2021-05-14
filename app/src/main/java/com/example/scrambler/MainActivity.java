package com.example.scrambler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> lines_for_work;
    ArrayList<Integer> lumps_for_work;
    int cur = 0;
    int clr = R.color.design_default_color_background; // конкретный цвет вЫключения
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lines_for_work = new ArrayList<>();
        lumps_for_work = new ArrayList<>();
    }

    public void button_all(View view) {
        MaterialRadioButton bt =  ((MaterialRadioButton) view);
        Object t = bt.getTag();
        String s = String.valueOf(t);
        if (s==null) return;
        int i = Integer.valueOf(s);
        // включена ли кнопка
        boolean on = bt.isChecked();
        if (on) {
        } else {
        }
        draw_lines(cur,false);
        draw_lines(i,true);
        set_color_out(cur,false);
        set_color_out(i,true);
        cur = i;
    }

    private void draw_lines(int i,boolean isOn) {
        // i - номер цифры, под которую менять цвет, isOn - цвет включения/выключения
        if (isOn) clr = getResources().getColor(R.color.orange); // конкретный цвет вКлючения
         else clr = getResources().getColor(R.color.black);
        View bot_line_vert  = (View) findViewById(get_res_id_by_num_vert_line(i));
        View lump = (View) findViewById(get_res_id_by_num_vert_line(i));
        bot_line_vert.setBackgroundColor(clr);
        fill_id_horiz(i);
        lines_for_work.forEach((Integer id) -> {
            View bot_line_horiz = (View) findViewById(id.intValue());
            bot_line_horiz.setBackgroundColor(clr);
        });

    }

    private void fill_id_horiz(int i) {
        lines_for_work.clear();
        if (i==9) {
            lines_for_work.add(R.id.scr1_line_9);
            lines_for_work.add(R.id.scr4_line_9);
        }
        if (i==8) {
            lines_for_work.add(R.id.scr4_line_8);
        }
        if (i==7) {
            lines_for_work.add(R.id.scr3_line_7);
            lines_for_work.add(R.id.scr2_line_7);
            lines_for_work.add(R.id.scr1_line_7);
        }
        if (i==6) {
            lines_for_work.add(R.id.scr2_line_6);
            lines_for_work.add(R.id.scr3_line_6);
        }
        if (i==5) {
            lines_for_work.add(R.id.scr1_line_5);
            lines_for_work.add(R.id.scr3_line_5);
        }
        if (i==4) {
            lines_for_work.add(R.id.scr3_line_4);
        }
        if (i==3) {
            lines_for_work.add(R.id.scr1_line_3);
            lines_for_work.add(R.id.scr2_line_3);
        }
        if (i==2) {
            lines_for_work.add(R.id.scr2_line_2);
        }
        if (i==1) {
            lines_for_work.add(R.id.scr1_line_1);
        }
    }
    private void set_color_out(int i,boolean IsOn) {
        if (IsOn) clr = getResources().getColor(R.color.orange); // конкретный цвет лампы
            else clr = getResources().getColor(R.color.grey);
        if (IsOn) txt="1";
            else txt="0";
        if (i==1 || i==3 || i==5 || i==7 || i==9){
            findViewById(R.id.lamp0).setBackgroundColor(clr);
            ToggleButton l = (ToggleButton) findViewById(R.id.lamp0);
            l.setText(txt);
        }
        if (i==2 || i==3 || i==7 || i==6){
            findViewById(R.id.lamp1).setBackgroundColor(clr);
            ToggleButton l = (ToggleButton) findViewById(R.id.lamp1);
            l.setText(txt);
        }
        if (i==4 || i==5 || i==6 || i==7){
            findViewById(R.id.lamp2).setBackgroundColor(clr);
            ToggleButton l = (ToggleButton) findViewById(R.id.lamp2);
            l.setText(txt);
        }
        if (i==8 || i==9){
            findViewById(R.id.lamp3).setBackgroundColor(clr);
            ToggleButton l = (ToggleButton) findViewById(R.id.lamp3);
            l.setText(txt);
        }
    }


    private int get_res_id_by_num_vert_line(int i) {
        // по номеру кнопки, возвращает ид. ресурса нужной линии
        if (i==0) return R.id.button_1_line;
        if (i==1) return R.id.button_2_line;
        if (i==2) return R.id.button_3_line;
        if (i==3) return R.id.button_4_line;
        if (i==4) return R.id.button_5_line;
        if (i==5) return R.id.button_6_line;
        if (i==6) return R.id.button_7_line;
        if (i==7) return R.id.button_8_line;
        if (i==8) return R.id.button_9_line;
        if (i==9) return R.id.button_10_line;

        return i;
    }

}