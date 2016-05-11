package cn.hebut.hebut.views.block;

import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * Created by hzh on 2016/4/28.
 */
public abstract class BlockListAdapter<T>
{
    private int mColumnNum = 0;

    private int mWidhtSpace = 0;
    private int mHeightSpace = 0;

    //默认是wrap_content
    private int mBlockWidth = -2;
    private int mBlockHeight = -2;

    private BlockListView mView;
    private List<T> mItemList;

    public BlockListAdapter()
    {

    }

    public T getItem(int position)
    {
        return mItemList.get(position);
    }

    public void registerView(BlockListView observer)
    {
        mView = observer;
    }

    public abstract View getView(LayoutInflater inflater, int position);

    public void setSpace(int w, int h)
    {
        mWidhtSpace = w;
        mHeightSpace = h;
    }

    public void setBlockSize(int w, int h)
    {
        mBlockWidth = w;
        mBlockHeight = h;
    }

    public void setColumnNum(int num)
    {
        mColumnNum = num;
    }

    public void displayBlocks(List<T> itemList)
    {
        if(itemList == null) {
            return;
        }
        mItemList = itemList;
        if(mView == null) {
            throw new IllegalArgumentException("Adapter has not been attacked to any block view");
        }
        mView.onDataListChange();
    }

    public int getSize()
    {
        return mItemList.size();
    }

    public int getHorizontalSpace()
    {
        return mWidhtSpace;
    }

    public int getVerticalSpace()
    {
        return mHeightSpace;
    }

    public int getColumnNum()
    {
        return mColumnNum;
    }

    public int getBlockWidth()
    {
        return mBlockWidth;
    }

    public int getBlockHeight()
    {
        return mBlockHeight;
    }
}
