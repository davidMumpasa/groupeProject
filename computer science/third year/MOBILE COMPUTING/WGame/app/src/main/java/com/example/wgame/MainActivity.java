package com.example.wgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   // private WordViewModel mWordViewModel;
  //  private List<Word> wordsList;
    String word;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String>wordlist = extractWordList();

        int randomNum =generateRandomNum(wordlist);
         word= wordlist.get(randomNum);



        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        int intento = sharedPref.getInt("try", 0);
        // int hits = sharedPref.getInt("hits", 0);
        SharedPreferences.Editor editor2 = sharedPref.edit();
        editor2.putInt("try", 1);
        editor2.apply();



        Button jugarButton = findViewById(R.id.buttonJugar);
        Toast.makeText(this,word,Toast.LENGTH_LONG).show();
        jugarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //cojo la palabra
                TextInputLayout palabra = findViewById(R.id.palabraInput);
                String palabraString = palabra.getEditText().getText().toString();
                if(palabraString.length() != 5){
                    jugarButton.setText("Palabra no valida");
                }else {
                    jugarButton.setText("Comprobar");

                    //cojo los intentos que llevo
                    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                    int intento = sharedPref.getInt("try", 0);
                    int hits = 0;
                    //escribo la palabra en los cuadraditos
                    if (intento == 1){
                        TextView t1 = findViewById(R.id.textView11);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;

                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView12);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView13);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView14);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }

                        TextView t5 = findViewById(R.id.textView15);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    } else if(intento == 2){
                        TextView t1 = findViewById(R.id.textView21);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView22);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView23);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView24);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }


                        TextView t5 = findViewById(R.id.textView25);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    }else if(intento == 3){
                        TextView t1 = findViewById(R.id.textView31);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView32);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView33);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView34);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }

                        TextView t5 = findViewById(R.id.textView35);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    }else if(intento == 4){
                        TextView t1 = findViewById(R.id.textView41);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView42);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView43);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView44);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }

                        TextView t5 = findViewById(R.id.textView45);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    }else if(intento == 5){
                        TextView t1 = findViewById(R.id.textView51);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView52);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView53);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView54);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }

                        TextView t5 = findViewById(R.id.textView55);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    }else if(intento == 6){
                        TextView t1 = findViewById(R.id.textView61);
                        t1.setText(palabraString.substring(0, 1));
                        t1.setAllCaps(true);
                        if(palabraString.substring(0, 1).equals(word.substring(0, 1)))
                        {
                            t1.setBackgroundColor(Color.GREEN);
                            t1.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(0, 1))){
                            t1.setBackgroundColor(Color.YELLOW);
                        }else {
                            t1.setBackgroundColor(Color.GRAY);
                            t1.setTextColor(Color.WHITE);
                        }

                        TextView t2 = findViewById(R.id.textView62);
                        t2.setText(palabraString.substring(1, 2));
                        t2.setAllCaps(true);
                        if(palabraString.substring(1, 2).equals(word.substring(1, 2)))
                        {
                            t2.setBackgroundColor(Color.GREEN);
                            t2.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(1, 2))){
                            t2.setBackgroundColor(Color.YELLOW);
                        }else {
                            t2.setBackgroundColor(Color.GRAY);
                            t2.setTextColor(Color.WHITE);
                        }

                        TextView t3 = findViewById(R.id.textView63);
                        t3.setText(palabraString.substring(2, 3));
                        t3.setAllCaps(true);
                        if(palabraString.substring(2, 3).equals(word.substring(2, 3)))
                        {
                            t3.setBackgroundColor(Color.GREEN);
                            t3.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(2, 3))){
                            t3.setBackgroundColor(Color.YELLOW);
                        }else {
                            t3.setBackgroundColor(Color.GRAY);
                            t3.setTextColor(Color.WHITE);
                        }

                        TextView t4 = findViewById(R.id.textView64);
                        t4.setText(palabraString.substring(3, 4));
                        t4.setAllCaps(true);
                        if(palabraString.substring(3, 4).equals(word.substring(3, 4)))
                        {
                            t4.setBackgroundColor(Color.GREEN);
                            t4.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(3, 4))){
                            t4.setBackgroundColor(Color.YELLOW);
                        }else {
                            t4.setBackgroundColor(Color.GRAY);
                            t4.setTextColor(Color.WHITE);
                        }

                        TextView t5 = findViewById(R.id.textView65);
                        t5.setText(palabraString.substring(4, 5));
                        t5.setAllCaps(true);
                        if(palabraString.substring(4, 5).equals(word.substring(4, 5)))
                        {
                            t5.setBackgroundColor(Color.GREEN);
                            t5.setTextColor(Color.WHITE);
                            hits ++;
                        }else if(word.contains(palabraString.substring(4, 5))){
                            t5.setBackgroundColor(Color.YELLOW);
                        }else {
                            t5.setBackgroundColor(Color.GRAY);
                            t5.setTextColor(Color.WHITE);
                        }
                    }
                    intento ++;
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("try", intento);
                    editor.apply();
                    palabra.getEditText().setText("");

                    if (intento > 6){
                        jugarButton.setText("Juego finalizado");
                        jugarButton.setEnabled(false);
                    }
                    if (hits == 5){
                        jugarButton.setText("Juego finalizado");
                        jugarButton.setEnabled(false);
                    }
                }
            }
        });

    }

    public int generateRandomNum(List<String>wordlist){


        Random rn = new Random();
        int max = wordlist.size()-1;
        int min =0;

        int num =rn.nextInt(max-min+1)+min;



        return num;
    }
    public List<String>extractWordList(){


        List<String> wordlist= new ArrayList<>();
        try{
        InputStream file = getAssets().open("wrdl5.txt");
        int size = file.available();
        byte[] buffer = new byte[size];
        file.read(buffer);
            file.close() ;
            String words[] = new String(buffer).split("\n");
            wordlist= Arrays.asList(words);


        }catch (IOException ex){
        ex.printStackTrace();
        }




        return wordlist;
    }



}