package cn.hebut.hebut;

import android.os.Bundle;

import cn.hebut.hebut.base.BlockMenuFragment;
import cn.hebut.hebut.base.HebutFragmentActiviy;
import cn.hebut.hebut.base.WithScrollView;

public class MainActivity extends HebutFragmentActiviy
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushFragmentToBackStack(BlockMenuFragment.class, null);
    }

    @Override
    protected int getContainerId()
    {
        return R.id.id_fragment;
    }
}
