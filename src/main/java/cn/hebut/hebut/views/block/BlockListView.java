package cn.hebut.hebut.views.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by hzh on 2016/4/28.
 */
public class BlockListView extends RelativeLayout
{
    public interface OnItemClickListener
    {
        void onItemClick(View v, int position);
    }

    private static final int INDEX_TAG = 0x04 << 24;

    private LayoutInflater mLayoutInflater;

    private OnItemClickListener mOnItemClickListener;

    private BlockListAdapter<?> mBlockListAdapter;

    public BlockListView(Context context)
    {
        this(context, null, 0);
    }

    public BlockListView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public BlockListView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        mLayoutInflater = LayoutInflater.from(context);
    }

    private OnClickListener mOnClickListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int position = (Integer) v.getTag(INDEX_TAG);
            if(null != mOnItemClickListener)
            {
                mOnItemClickListener.onItemClick(v, position);
            }
        }
    };

    public void setOnItemCLickListener(OnItemClickListener listener)
    {
        mOnItemClickListener = listener;
    }

    public void setAdapter(BlockListAdapter adapter)
    {
        if(adapter != null)
        {
            mBlockListAdapter = adapter;
            mBlockListAdapter.registerView(this);
        }
    }

    public void onDataListChange()
    {
        removeAllViews();

        int len = mBlockListAdapter.getSize();
        int columnNum = mBlockListAdapter.getColumnNum();
        int w = mBlockListAdapter.getBlockWidth();
        int h = mBlockListAdapter.getBlockHeight();

        int horizontalSpace = mBlockListAdapter.getHorizontalSpace();
        int verticalSpace = mBlockListAdapter.getVerticalSpace();

        for(int i = 0; i < len; i++)
        {
            int row = i / columnNum;
            int col = i % columnNum;

            int left = 0;
            int top = 0;

            if(col > 0) {
                left = (w + horizontalSpace) * col;
            }
            if(row > 0) {
                top = (h + verticalSpace) * row;
            }
            RelativeLayout.LayoutParams lyp = new RelativeLayout.LayoutParams(w, h);
            lyp.setMargins(left, top, 0, 0);
            View view = mBlockListAdapter.getView(mLayoutInflater, i);
            view.setTag(INDEX_TAG, i);
            view.setOnClickListener(mOnClickListener);

            addView(view, lyp);
        }
        requestLayout();
    }

}
