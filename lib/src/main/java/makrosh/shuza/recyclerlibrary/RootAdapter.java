package makrosh.shuza.recyclerlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Boka on 06-Apr-17.
 */

public abstract class RootAdapter<VH extends RootViewHolder> extends RecyclerView.Adapter<VH> {
    private RecyclerClickListener listener;
    private int mLayout;
    Class<VH> mViewHolderClass;

    public RootAdapter(RecyclerClickListener listener, int mLayout, Class<VH> mViewHolderClass) {
        this.listener = listener;
        this.mLayout = mLayout;
        this.mViewHolderClass = mViewHolderClass;
    }

    public RootAdapter(int mLayout, Class<VH> mViewHolderClass) {
        this.listener = null;
        this.mLayout = mLayout;
        this.mViewHolderClass = mViewHolderClass;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
        try {
            Constructor<VH> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(mView);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bind(listener, position);
        bindView(holder, position);
    }

    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }

    public abstract void bindView(VH holder, int position);

    @Override
    public int getItemCount() {
        return getRowCount();
    }

    public abstract int getRowCount();
}
