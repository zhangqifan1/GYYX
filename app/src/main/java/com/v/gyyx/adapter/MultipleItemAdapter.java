package com.v.gyyx.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.v.gyyx.R;
import com.v.gyyx.beans.MultipleItem;
import com.v.gyyx.utils.DrawTextMixUtils;

import java.util.List;

public class MultipleItemAdapter extends BaseQuickAdapter<MultipleItem, BaseViewHolder> {

    public MultipleItemAdapter(@Nullable List<MultipleItem> data) {
        super(data);

        setMultiTypeDelegate(new MultiTypeDelegate<MultipleItem>() {
            @Override
            protected int getItemType(MultipleItem multipleItem) {
                return multipleItem.itemType;
            }
        });
        getMultiTypeDelegate()
                .registerItemType(MultipleItem.Type0, R.layout.recom_recycler_item0)
                .registerItemType(MultipleItem.Type1, R.layout.recom_recycler_item1)
                .registerItemType(MultipleItem.Type2, R.layout.recom_recycler_item2)
                .registerItemType(MultipleItem.Type3, R.layout.recom_recycler_item3)
                .registerItemType(MultipleItem.Type4, R.layout.recom_recycler_item4)
                .registerItemType(MultipleItem.Type5, R.layout.recom_recycler_item5);

    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.Type0:
                ImageView image_i0 = helper.getView(R.id.image_i0);
                TextView text_i0 = helper.getView(R.id.text_i0);
                TextView tvNum1 = helper.getView(R.id.tvNum1);
                TextView tvNum2 = helper.getView(R.id.tvNum2);
                TextView tvDate = helper.getView(R.id.tvDate);
                image_i0.setImageResource(item.getTitleImageResID());
                text_i0.setText(item.getTitleText());
                tvNum1.setText(item.getTitleNum1());
                tvNum2.setText(item.getTitleNum2());
                tvDate.setText(item.getTitleDate());
                helper.addOnClickListener(R.id.image_addcare);
                break;
            case MultipleItem.Type1:
                TextView tvTest = helper.getView(R.id.tvTest);
                ImageView image1_i1 = helper.getView(R.id.image1_i1);
                ImageView image2_i1 = helper.getView(R.id.image2_i1);
                ImageView image3_i1 = helper.getView(R.id.image3_i1);
                helper.addOnClickListener(R.id.image_addcare_i1);
                Spanned spanned = Html.fromHtml(DrawTextMixUtils.descString(), DrawTextMixUtils.getImageGetterInstance(), null);
                tvTest.setText(spanned);
                image1_i1.setImageResource(item.getImage1_i1());
                image2_i1.setImageResource(item.getImage2_i1());
                image3_i1.setImageResource(item.getImage3_i1());
                break;
            case MultipleItem.Type2:
                RecyclerView recyclerView = helper.getView(R.id.recycler_item);
                //创建布局管理
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                item2RecyclerAdapter item2RecyclerAdapter = new item2RecyclerAdapter(R.layout.item2_item, item.getHuatiBean().getData().getTopic());
                recyclerView.setAdapter(item2RecyclerAdapter);
                break;
            case MultipleItem.Type3:
                RecyclerView recycler_item3 = helper.getView(R.id.recycler_item3);
                //创建布局管理
                LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                recycler_item3.setLayoutManager(manager);
                item3RecyclerAdapter item3Adapter = new item3RecyclerAdapter(R.layout.item3_item, item.getHuaTi7Bean().getData().getArticle());
                recycler_item3.setAdapter(item3Adapter);
                recycler_item3.addItemDecoration(new MyDecoration(R.drawable.my_list_divider, mContext, manager.getOrientation()));


                ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(item3Adapter);
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
                itemTouchHelper.attachToRecyclerView(recycler_item3);

// 开启拖拽
                item3Adapter.enableDragItem(itemTouchHelper, R.id.item3, true);
//                item3Adapter.setOnItemDragListener(onItemDragListener);

// 开启滑动删除
                item3Adapter.enableSwipeItem();
//                item3Adapter.setOnItemSwipeListener(onItemSwipeListener);


                break;
            case MultipleItem.Type4:

                break;
            case MultipleItem.Type5:
                break;
            default:
                break;
        }
    }

}
