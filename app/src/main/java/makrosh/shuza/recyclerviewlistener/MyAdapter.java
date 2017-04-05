package makrosh.shuza.recyclerviewlistener;

import java.util.ArrayList;

import makrosh.shuza.recyclerlibrary.RecyclerClickListener;
import makrosh.shuza.recyclerlibrary.RootAdapter;

/**
 * Created by Boka on 06-Apr-17.
 */

public class MyAdapter extends RootAdapter<MyViewHolder> {
    private ArrayList<String> data;

    public MyAdapter(RecyclerClickListener listener, int mLayout, ArrayList<String> date) {
        super(listener, mLayout, MyViewHolder.class);
        this.data = date;
    }

    @Override
    public void bindView(MyViewHolder holder, int position) {
        holder.tvRowMsg.setText(data.get(position));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }
}
