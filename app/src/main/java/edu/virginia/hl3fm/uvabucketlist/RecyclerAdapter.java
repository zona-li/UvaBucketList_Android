package edu.virginia.hl3fm.uvabucketlist;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Adapter for the RecyclerView and pass the list of object to the adapter
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private List<ListItems> mLists;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView listDateView;
        private CheckBox listCheckBox;
        public ViewHolder(View itemView) {
            super(itemView);
            listDateView = (TextView) itemView.findViewById(R.id.item_date);
            listCheckBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    // MARK: Constructor
    public RecyclerAdapter(Context context, List<ListItems> lists) {
        mLists = lists;
        mContext = context;
    }

    // Inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflatedListView = inflater.inflate(R.layout.recyclerview_item_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflatedListView);
        return viewHolder;
    }

    // Populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        ListItems listItem = mLists.get(position);

        TextView dateView = holder.listDateView;
        CheckBox checkBx = holder.listCheckBox;

        dateView.setText(listItem.getDate());
        checkBx.setChecked(listItem.isCompleted());
        checkBx.setText(listItem.getTitle());


        checkBx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    // Todo: Move it to the bottom of the lists
                    Toast.makeText(mContext, "List " + pos + " completed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }



}
