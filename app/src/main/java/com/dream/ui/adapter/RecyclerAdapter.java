package com.dream.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dream.ui.R;

import java.util.List;

/**
 * @author 孙康
 * @date 2018/3/15
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> implements View.OnClickListener, View.OnLongClickListener {
    private List<String> list;
    private Context context;

    public RecyclerAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new VH(itemView);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.itemView.setTag(position);
        holder.tv.setText(list.get(position));
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView tv;

        private VH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
