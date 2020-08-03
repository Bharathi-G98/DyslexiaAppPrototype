package com.example.lenovo.dyslexianew;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ChoiceAdapter choiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);


        List<CardData> list;
        list = getData();



        recyclerView = findViewById(R.id.my_recycler_view);
        choiceAdapter = new ChoiceAdapter(list);
        recyclerView.setAdapter(choiceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        choiceAdapter.notifyDataSetChanged();
    }


    // sample data for RecyclerView
    private List<CardData> getData() {
        List<CardData> list = new ArrayList<>();
        list.add(new CardData("SpeechAid", "improve comprehension and speech skills", "Read out words to improve comprehension"));
        list.add(new CardData("SpellAid", "Improve your spelling skills", "Spell out the words on hearing thier pronunciations."));
        list.add(new CardData("Learn", "More info on Dyslexia", "Understand more about Dyslexia"));
        return list;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}