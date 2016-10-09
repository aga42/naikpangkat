package com.barethitam.naikpangkat.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.MisiSayaModel;
import com.barethitam.naikpangkat.utils.Constant;
import com.barethitam.naikpangkat.utils.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiSayaAdapter extends RecyclerView.Adapter<MisiSayaAdapter.ViewHolder> {

    ArrayList<MisiSayaModel.Data> arrData;
    Context context;
    ItemSelectedListener listener;

    public MisiSayaAdapter(Context context, ArrayList<MisiSayaModel.Data> arrData, ItemSelectedListener listener) {
        this.arrData = arrData;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_misi_saya, parent, false), this.listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            MisiSayaModel.Data data = arrData.get(position);
            holder.data = data;

            /*String pp = data.getUser().getPicture();
            if (!pp.isEmpty()) {
                Glide.with(context)
                        .load(R.drawable.img_dummy)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.img);
            } else {
                //set default
            }*/

            Glide.with(context)
                    .load(data.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .into(holder.img);

            holder.txtMisi.setTypeface(Utils.getMyTypeface(context));
            holder.txtExp.setTypeface(Utils.getMyTypeface(context));
            holder.txtDate.setTypeface(Utils.getMyTypeface(context));

            holder.txtMisi.setText(data.getPam());
            holder.txtExp.setText(String.valueOf(data.getExp()+" Exp"));
            holder.txtDate.setText(data.getTahun());

            if(data.getStatus()==Constant.MISI_SELESAI){
                holder.imgStatus.setSelected(false);
            }else{
                holder.imgStatus.setSelected(true);
            }

        } catch (Exception e) {
            String sd = e.toString();
            Log.d("", "");
        }


    }

    @Override
    public int getItemCount() {
        return arrData.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSelectedListener listener;
        MisiSayaModel.Data data;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.img_status)
        ImageView imgStatus;
        @BindView(R.id.txt_misi)
        TextView txtMisi;
        @BindView(R.id.txt_exp)
        TextView txtExp;
        @BindView(R.id.txt_date)
        TextView txtDate;

        public ViewHolder(View view, ItemSelectedListener listener) {
            super(view);
            ButterKnife.bind(this, view);
            this.listener = listener;
        }

        @OnClick(R.id.cardView)
        public void onClick() {
            if (listener != null)
                listener.onItemSelected(this.data);
        }


    }

    public interface ItemSelectedListener {
        void onItemSelected(MisiSayaModel.Data data);
    }

}
