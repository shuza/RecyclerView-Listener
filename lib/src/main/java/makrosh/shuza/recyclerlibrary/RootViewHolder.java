package makrosh.shuza.recyclerlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Boka on 06-Apr-17.
 */

public class RootViewHolder extends RecyclerView.ViewHolder {

    public RootViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(final RecyclerClickListener listener, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRowClickListener(position);
                }
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (listener != null) {
                    listener.onRowLongClickListener(position);
                    return true;
                }
                return false;
            }
        });
    }
}
