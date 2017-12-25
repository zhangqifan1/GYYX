package com.v.gyyx.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.v.gyyx.R;
import com.v.gyyx.adapter.SearchRecAdapter_Author;
import com.v.gyyx.beans.EventBusBean;
import com.v.gyyx.beans.HuaTi7Bean;
import com.v.gyyx.beans.MultipleItem;
import com.v.gyyx.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {

    private ImageView imageBack;
    private SearchView searchview;
    private TextView ToSearch;
    private RecyclerView recyclerView;
    List<HuaTi7Bean.DataBean.ArticleBean> listNew = new ArrayList<>();
    List<HuaTi7Bean.DataBean.ArticleBean> listNewAdapter = new ArrayList<>();
    private SearchRecAdapter_Author searchRecAdapter_author;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initView(view);

        EventBus.getDefault().register(this);
        new AsyncTask<String,Integer,Object>(){
            @Override
            protected Object doInBackground(String... strings) {
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }
        }.execute();
        return view;
    }

    private void initView(View view) {
        imageBack = (ImageView) view.findViewById(R.id.imageBack);
        searchview = (SearchView) view.findViewById(R.id.searchview);
        ToSearch = (TextView) view.findViewById(R.id.ToSearch);
        recyclerView = view.findViewById(R.id.recycler_search);
        imageBack.setOnClickListener(this);
        ToSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageBack:
                searchview.setQuery("",false);
                if (listNewAdapter.size() > 0) {
                    listNewAdapter.clear();
                    searchRecAdapter_author.notifyDataSetChanged();
                }
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.nullanim, R.anim.translatexzuoyou).hide(this).commit();
                break;
            case R.id.ToSearch:
                String query = searchview.getQuery().toString();
                if(query.equals("") || query==null){
                    return;
                }
                if (listNew.size() == 0) {
                    ToastUtils.Toast("No");
                    return;
                }
                listNewAdapter.clear();
                for (int i = 0; i < listNew.size(); i++) {
                    HuaTi7Bean.DataBean.ArticleBean articleBean = listNew.get(i);
                    if (articleBean.getTitle().contains(query)) {
                        listNewAdapter.add(articleBean);
                    }
                }
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                searchRecAdapter_author = new SearchRecAdapter_Author(R.layout.author, listNewAdapter);
                recyclerView.setAdapter(searchRecAdapter_author);
                recyclerView.setLayoutManager(manager);
                break;
            default:
                break;
        }
    }

    @Subscribe(sticky = true)
    public void onReceiveBean(EventBusBean eventBusBean) {
        List<MultipleItem> list = eventBusBean.getList();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            MultipleItem multipleItem = list.get(i);
            if (multipleItem.itemType == MultipleItem.Type3) {
                listNew.addAll(multipleItem.getHuaTi7Bean().getData().getArticle());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
