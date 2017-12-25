package com.v.gyyx.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.gyyx.R;
import com.v.gyyx.beans.HuaTi7Bean;
import com.v.gyyx.utils.glideutils.GlideLoadImageUtil.GlideLoadImageUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class item3RecyclerAdapter extends BaseItemDraggableAdapter<HuaTi7Bean.DataBean.ArticleBean,BaseViewHolder> {

    public item3RecyclerAdapter(int layoutResId, @Nullable List<HuaTi7Bean.DataBean.ArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final HuaTi7Bean.DataBean.ArticleBean item) {

        final ImageView image_item3 = helper.getView(R.id.image_item3);
        ImageView imagecare_item3 = helper.getView(R.id.imagecare_item3);
        ImageView titleimg_item3 = helper.getView(R.id.titleimg_item3);
        TextView tvContent_item3 = helper.getView(R.id.tvContent_item3);
        TextView tvNum2_item3 = helper.getView(R.id.tvNum2_item3);
        TextView tvNum1_item3 = helper.getView(R.id.tvNum1_item3);
        TextView tvDate_i3 = helper.getView(R.id.tvDate_i3);
        tvDate_i3.setText(item.getUpdate_time()+"");
        tvNum1_item3.setText(item.getComment_count()+"");
        tvNum2_item3.setText(item.getRead_count()+"");
        tvContent_item3.setText(item.getSummary()+"");
        GlideLoadImageUtil.load(mContext,item.getFace(),image_item3);

    }


}
