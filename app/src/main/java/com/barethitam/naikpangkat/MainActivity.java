package com.barethitam.naikpangkat;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.barethitam.naikpangkat.utils.Utils;
import com.barethitam.naikpangkat.view.fragment.MisiFragment;
import com.barethitam.naikpangkat.view.fragment.MisiSayaFragment;
import com.barethitam.naikpangkat.view.fragment.ProfilFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.txt_toolbar)
    TextView txtToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        txtToolbar.setTypeface(Utils.getMyTypeface(MainActivity.this));
        MainPageAdapter adapter = new MainPageAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(adapter.getCount());
        tab.setupWithViewPager(viewpager);
        setupTab();
        viewpager.addOnPageChangeListener(this);
    }

    private void setupTab() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        ImageView img_tab1 = (ImageView) view1.findViewById(R.id.img_tab);
        TextView text_title1 = (TextView) view1.findViewById(R.id.txt_title);
        text_title1.setText(getResources().getString(R.string.tab_misi));
        text_title1.setTypeface(Utils.getMyTypeface(MainActivity.this));
        img_tab1.setImageResource(R.drawable.ic_misi);
        tab.getTabAt(0).setCustomView(view1);

        View view2 = LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        ImageView img_tab2 = (ImageView) view2.findViewById(R.id.img_tab);
        TextView text_title2 = (TextView) view2.findViewById(R.id.txt_title);
        text_title2.setText(getResources().getString(R.string.tab_misisaya));
        text_title2.setTypeface(Utils.getMyTypeface(MainActivity.this));
        img_tab2.setImageResource(R.drawable.ic_misi_saya);
        tab.getTabAt(1).setCustomView(view2);

        View view3 = LayoutInflater.from(this).inflate(R.layout.tab_custom, null);
        ImageView img_tab3 = (ImageView) view3.findViewById(R.id.img_tab);
        TextView text_title3 = (TextView) view3.findViewById(R.id.txt_title);
        text_title3.setText(getResources().getString(R.string.tab_profil));
        text_title3.setTypeface(Utils.getMyTypeface(MainActivity.this));
        img_tab3.setImageResource(R.drawable.ic_profil);
        tab.getTabAt(2).setCustomView(view3);

        viewpager.setCurrentItem(0);
    }

    protected class MainPageAdapter extends FragmentPagerAdapter {
        private Fragment[] fragments;
        Bundle bundle = new Bundle();

        private MainPageAdapter(FragmentManager fm) {
            super(fm);

            //bundle.putString(Constant.USER_ID, App.getFromPreference(Constant.USER_ID));

            this.fragments = new Fragment[]{
                    MisiFragment.getInstance(bundle),
                    MisiSayaFragment.getInstance(bundle),
                    ProfilFragment.getInstance(bundle)};
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
