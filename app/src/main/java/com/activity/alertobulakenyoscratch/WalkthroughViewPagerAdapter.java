package com.activity.alertobulakenyoscratch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class WalkthroughViewPagerAdapter extends PagerAdapter {

    Context context;
    List<ScreenItem> listScreen;

    public WalkthroughViewPagerAdapter(Context context, List<ScreenItem> listScreen) {
        this.context = context;
        this.listScreen = listScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.imgWT);
        TextView title = layoutScreen.findViewById(R.id.tvWTtitle);
        TextView description = layoutScreen.findViewById(R.id.tvWTdescription);

        imgSlide.setImageResource(listScreen.get(position).getScreenImg());
        title.setText(listScreen.get(position).getTitle());
        description.setText(listScreen.get(position).getDescription());

        container.addView(layoutScreen);

        return layoutScreen;
    }

    @Override
    public int getCount() {
        return listScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
