package makrosh.shuza.recyclerviewlistener;

import android.view.View;
import android.widget.TextView;

import makrosh.shuza.recyclerlibrary.RootViewHolder;

/**
 * Created by Boka on 06-Apr-17.
 */

public class MyViewHolder extends RootViewHolder {
    public TextView tvRowMsg;

    public MyViewHolder(View itemView) {
        super(itemView);
        tvRowMsg = (TextView) itemView.findViewById(R.id.tvRowMessage);
    }
}
