package com.tyut.himusic.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tyut.himusic.R;
import com.tyut.himusic.adapter.HotAdapter;
import com.tyut.himusic.util.ImageUrlTestUtils;
import com.tyut.himusic.view.SpacesItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HiVideoMainNewFragment extends BaseFragment
{
    @Bind(R.id.frag_hivideo_new_recyclerview)
    RecyclerView hiVideoNewRecyclerView;

    private HotAdapter videoNewAdapter;
    private String[] imgUrls;

    public static HiVideoMainNewFragment getInstance()
    {

        return new HiVideoMainNewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        imgUrls = ImageUrlTestUtils.getImageUrls();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_hivideo_main_new, container, false);
        return view;

    }

    void initView()
    {

        hiVideoNewRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        hiVideoNewRecyclerView.setHasFixedSize(true);
        videoNewAdapter = new HotAdapter(imgUrls, getContext());
        hiVideoNewRecyclerView.setAdapter(videoNewAdapter);
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        hiVideoNewRecyclerView.addItemDecoration(decoration);
        log.d("");
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}



