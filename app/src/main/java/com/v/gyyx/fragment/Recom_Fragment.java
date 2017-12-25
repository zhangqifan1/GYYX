package com.v.gyyx.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.v.gyyx.R;
import com.v.gyyx.beans.EventBusBean;
import com.v.gyyx.beans.MultipleItem;
import com.v.gyyx.adapter.MultipleItemAdapter;
import com.v.gyyx.adapter.MyDecoration;
import com.v.gyyx.areaRecom.Presenter;
import com.v.gyyx.areaRecom.iview;
import com.v.gyyx.utils.ToastUtils;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recom_Fragment extends Fragment implements iview {

    private Object cancelSign = new Object();
    private RecyclerView recyclerview;

    private MultipleItemAdapter multipleItemAdapter;
    private Presenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_recom_, container, false);

        initView(inflate);
        if (presenter == null) {
            presenter = new Presenter(this);
        }

        presenter.mvp();
        return inflate;
    }

    private void initView(View inflate) {
        recyclerview = (RecyclerView) inflate.findViewById(R.id.recyclerview);
    }

    @Override
    public Object getObject() {
        return cancelSign;
    }

    @Override
    public void setList(List<MultipleItem> list) {
        EventBusBean busBean=new EventBusBean();
        busBean.setList(list);
        EventBus.getDefault().postSticky(busBean);
        multipleItemAdapter = new MultipleItemAdapter(list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerview.addItemDecoration(new MyDecoration(R.drawable.my_list_divider_colorqianhui, getContext(), manager.getOrientation()));
        recyclerview.setAdapter(multipleItemAdapter);
        recyclerview.setLayoutManager(manager);
// 开启滑动删除
        multipleItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.image_addcare:
                        ToastUtils.Toast("添加关注0");
                        break;
                    case R.id.image_addcare_i1:
                        ToastUtils.Toast("添加关注1");
                        break;
                    default:
                        break;
                }


            }
        });
    }

    @Override
    public Context getContext1() {
        return getActivity();
    }
}
