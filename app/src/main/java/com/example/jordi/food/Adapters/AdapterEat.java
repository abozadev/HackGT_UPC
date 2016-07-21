package com.example.jordi.food.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jordi.food.Info;
import com.example.jordi.food.R;

import java.util.List;

/**
 * Created by jordi on 21/07/16.
 */
public class AdapterEat extends ArrayAdapter<Eat> {
    Context context;

    public AdapterEat(Context context, List<Eat> data) {
        super(context, R.layout.layout_eat, data);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.layout_eat, parent, false);
        final Eat eatingMeal = getItem(position);

        ImageView imageFirstDish = (ImageView) row.findViewById(R.id.imageFirstDish);
        ImageView imageSecondDish = (ImageView) row.findViewById(R.id.imageSecondDish);
        ImageView imageThirdDish = (ImageView) row.findViewById(R.id.imageThirdDish);

        TextView textEatingTime = (TextView) row.findViewById(R.id.textEatingTime);
        TextView textFirstDish = (TextView) row.findViewById(R.id.textFirstDish);
        TextView textSecondDish = (TextView) row.findViewById(R.id.textSecondDish);
        TextView textThirdDish = (TextView) row.findViewById(R.id.textThirdDish);

        textEatingTime.setText(eatingMeal.getEatingTime());
        textFirstDish.setText(eatingMeal.getFirstDish());
        textSecondDish.setText(eatingMeal.getSecondDish());
        textThirdDish.setText(eatingMeal.getThirdDish());

        setImage(row, imageFirstDish, eatingMeal.getImgFirstDish());
        setImage(row, imageSecondDish, eatingMeal.getImgSecondDish());
        setImage(row, imageThirdDish, eatingMeal.getImgThirdDish());

        Button infoFirstDish = (Button) row.findViewById(R.id.infoFirstDish);
        Button infoSecondDish = (Button) row.findViewById(R.id.infoSecondDish);
        Button infoThirdDish = (Button) row.findViewById(R.id.infoThirdDish);

        setListeners(infoFirstDish, eatingMeal.getFirstDish());
        setListeners(infoSecondDish, eatingMeal.getSecondDish());
        setListeners(infoThirdDish, eatingMeal.getThirdDish());

        return row;
    }

    private void setListeners (Button info, final String dish) {
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create new Info activity
                Intent intent = new Intent(context, Info.class);
                intent.putExtra("name", dish);
                context.startActivity(intent);
            }
        });
    }

    private void setImage (View row, ImageView imageView, String strImg) {
        if (strImg != null && strImg.length() > 0) {
            if (strImg.charAt(0) == '@') {
                String uri = strImg;  // where myresource.png is the file
                // extension removed from the String
                int imageResource = row.getResources().getIdentifier(uri, null, getContext().getPackageName());
                Log.i("img", strImg);
                Drawable res = row.getResources().getDrawable(imageResource);
                imageView.setImageDrawable(res);
            } else {
                Bitmap img = BitmapFactory.decodeFile(strImg);
                imageView.setImageBitmap(img);
            }
        }
    }
}
