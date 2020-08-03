package com.example.lenovo.dyslexianew;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.MyViewHolder> {


    private List<CardData> list;
    private static final String TAG = "ChoiceAdapter";

    ChoiceAdapter(List<CardData> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardData cardData = list.get(position);
        final CardData finalCardData = cardData;
        holder.activityName.setText(cardData.getActivityName());
        holder.activityType.setText(cardData.getActivityType());
        holder.activityInfo.setText(cardData.getActivityInfo());

        holder.rlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (finalCardData.getActivityName()) {
                    case "SpeechAid": {
                        Intent intent = new Intent(view.getContext(), Speech1.class);
                        view.getContext().startActivity(intent);
                        break;
                    }
                    case "SpellAid": {
                        Intent intent = new Intent(view.getContext(), Spell.class);
                        view.getContext().startActivity(intent);
                        break;
                    }
                    case "Learn": {
                        Intent intent = new Intent(view.getContext(), Info.class);
                        view.getContext().startActivity(intent);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView activityName, activityType, activityInfo;
        RelativeLayout rlCard;

        MyViewHolder(View itemView) {
            super(itemView);

            activityName = itemView.findViewById(R.id.activityName);
            activityType = itemView.findViewById(R.id.activityType);
            activityInfo = itemView.findViewById(R.id.activityInfo);
            rlCard = itemView.findViewById(R.id.rl_card);
        }
    }
}
