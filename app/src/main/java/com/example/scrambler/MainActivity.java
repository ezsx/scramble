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
    int cur = 0;
    int clr = R.color.design_default_color_background; // конкретный цвет вЫключения

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lines_for_work = new ArrayList<>();
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
        cur = i;
    }

    private void draw_lines(int i,boolean isOn) {
        // i - номер цифры, под которую менять цвет, isOn - цвет включения/выключения
        if (isOn) clr = R.color.orange; // конкретный цвет вКлючения
         else clr = R.color.design_default_color_background;
        View bot_line_vert  = (View) findViewById(get_res_id_by_num_vert_line(i));
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
        if (i==1) {
            lines_for_work.add(R.id.scr1_line_1);
        }
        if (i==2) {
            lines_for_work.add(R.id.scr2_line_2);
        }
        if (i==3) {
            lines_for_work.add(R.id.scr1_line_3);
            lines_for_work.add(R.id.scr2_line_3);
        }

    }

    private int get_res_id_by_num_vert_line(int i) {
        // по номеру кнопки, возвращает ид. ресурса нужной линии
        if (i==0) return R.id.button_1_line;
        if (i==1) return R.id.button_2_line;
        if (i==2) return R.id.button_3_line;
        if (i==3) return R.id.button_4_line;

        return i;
    }

}