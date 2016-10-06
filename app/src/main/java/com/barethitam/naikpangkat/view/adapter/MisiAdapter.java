package com.barethitam.naikpangkat.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barethitam.naikpangkat.R;
import com.barethitam.naikpangkat.model.MisiModel;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LTE on 10/6/2016.
 */
public class MisiAdapter extends RecyclerView.Adapter<MisiAdapter.ViewHolder> {

    //ArrayList<MisiModel.Data> arrData;
    Context context;
    ItemSelectedListener listener;

    public MisiAdapter(Context context, ItemSelectedListener listener) {
        //ArrayList<MisiModel.Data> arrData,
        //this.arrData = arrData;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_misi, parent, false), this.listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            /*CommentModel.Data data = arrData.get(position);

            int s = arrData.size();
            holder.data = data;

            String pp = data.getUser().getPicture();
            if (!pp.isEmpty()) {
                Glide.with(context).load(pp).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.imgPhoto) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        final RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        super.getView().setImageDrawable(circularBitmapDrawable);
                    }
                });
            } else {
                //set default
            }

            holder.txtUsername.setText(data.getUser().getUsername());
            holder.txtComment.setText(data.getText());

            holder.txtDate.setText(Utils.getTimeFormat(data.getCreated_at()));*/

        } catch (Exception e) {
            String sd = e.toString();
            Log.d("", "");
        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSelectedListener listener;
        //CommentModel.Data data;

        public ViewHolder(View view, ItemSelectedListener listener) {
            super(view);
            ButterKnife.bind(this, view);
            this.listener = listener;
        }

        @OnClick(R.id.cardView)
        public void onClick() {
            if (listener != null)
                listener.onItemSelected();
        }


    }

    public interface ItemSelectedListener {
        void onItemSelected();
    }

}
