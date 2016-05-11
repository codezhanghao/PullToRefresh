package cn.hebut.hebut.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.hebut.hebut.R;
import cn.hebut.hebut.util.LocalDisplay;
import cn.hebut.hebut.views.block.BlockListAdapter;
import cn.hebut.hebut.views.block.BlockListView;

/**
 * Created by hzh on 2016/4/28.
 */
public class BlockMenuFragment extends MenuItemFragment
{
    private BlockListView mBlockListView;

    private BlockListAdapter<MenuItemInfo> mBlockListAdapter = new BlockListAdapter<MenuItemInfo>()
    {
        @Override
        public View getView(LayoutInflater inflater, int position)
        {
            MenuItemInfo itemInfo = mBlockListAdapter.getItem(position);
            View view = inflater.inflate(R.layout.block_menu_item, null);
            if(itemInfo != null) {
                TextView title = (TextView) view.findViewById(R.id.block_menu_item_title);
                title.setText(itemInfo.getTitle());
                view.setBackgroundColor(itemInfo.getColor());
            }
            return view;
        }
    };

    @Override
    public int getLayoutId()
    {
        return R.layout.fragment_classic_header_with_block_menu;
    }

    @Override
    public void addItemInfos(ArrayList<MenuItemInfo> itemInfos)
    {
        itemInfos.add(newItemInfo(R.color.colorPrimary, "List View", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getContext().pushFragmentToBackStack(WithListView.class, null);
            }
        }));

        itemInfos.add(newItemInfo(R.color.colorPrimary, "Grid View", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getContext().pushFragmentToBackStack(WithGridView.class, null);
            }
        }));

        itemInfos.add(newItemInfo(R.color.colorPrimary, "Scroll View", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getContext().pushFragmentToBackStack(WithScrollView.class, null);
            }
        }));

        itemInfos.add(newItemInfo(R.color.colorPrimary, "Text View", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getContext().pushFragmentToBackStack(WithTextView.class, null);
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "Image View", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getContext().pushFragmentToBackStack(WithImageView.class, null);
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(null);
        itemInfos.add(null);
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
        itemInfos.add(newItemInfo(R.color.colorPrimary, "To be continued", new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getContext(), "To be continued", Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void setupViews(View view)
    {
        setHeaderTitle("Block Menu");

        mBlockListView = (BlockListView) view.findViewById(R.id.block_list_view);
        mBlockListView.setOnItemCLickListener(new BlockListView.OnItemClickListener()
        {
            @Override
            public void onItemClick(View v, int position)
            {
                MenuItemInfo itemInfo = mBlockListAdapter.getItem(position);
                if(itemInfo != null) {
                    itemInfo.onClick(v);
                }
            }
        });

        LocalDisplay.init(getContext());
        int size = (LocalDisplay.SCREEN_WIDTH_PIXELS - LocalDisplay.dp2px(25 + 5 + 5)) / 3;
        int horizontalSpace = LocalDisplay.dp2px(5);
        int verticalSpace = LocalDisplay.dp2px(10.5f);
        mBlockListAdapter.setColumnNum(3);
        mBlockListAdapter.setBlockSize(size, size);
        mBlockListAdapter.setSpace(horizontalSpace, verticalSpace);

        mBlockListView.setAdapter(mBlockListAdapter);
        mBlockListAdapter.displayBlocks(mItemInfos);
    }

    @Override
    protected boolean enableDefaultBack()
    {
        return false;
    }
}
