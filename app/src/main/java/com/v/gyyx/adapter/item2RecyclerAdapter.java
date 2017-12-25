package com.v.gyyx.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.gyyx.R;
import com.v.gyyx.beans.HuatiBean;
import com.v.gyyx.utils.glideutils.GlideLoadImageUtil.GlideLoadImageUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class item2RecyclerAdapter extends BaseQuickAdapter<HuatiBean.DataBean.TopicBean,BaseViewHolder> {

    public item2RecyclerAdapter(int layoutResId, @Nullable List<HuatiBean.DataBean.TopicBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HuatiBean.DataBean.TopicBean topicBean) {

        ImageView imageView = helper.getView(R.id.image_item_item);
        helper.setText(R.id.text1_item_item,topicBean.getTitle())
                .setText(R.id.text2_item_item,topicBean.getComment_count()+"人参与");
        GlideLoadImageUtil.load(mContext,topicBean.getLogo(),imageView);
    }
}
