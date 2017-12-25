package com.v.gyyx.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.v.gyyx.R;
import com.v.gyyx.beans.HuaTi7Bean;
import com.v.gyyx.utils.glideutils.GlideLoadImageUtil.GlideLoadImageUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */

public class SearchRecAdapter_Author extends BaseQuickAdapter<HuaTi7Bean.DataBean.ArticleBean, BaseViewHolder> {


    public SearchRecAdapter_Author(int layoutResId, @Nullable List<HuaTi7Bean.DataBean.ArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HuaTi7Bean.DataBean.ArticleBean item) {
        ImageView imageAuthor = helper.getView(R.id.imageAuthor);
        TextView tvAuthor1 = helper.getView(R.id.tvAuthor1);
        TextView tvAuthor2 = helper.getView(R.id.tvAuthor2);
        GlideLoadImageUtil.load(mContext,item.getFace(),imageAuthor);
        tvAuthor1.setText(item.getTitle());
        tvAuthor2.setText(item.getSummary());
    }
}
