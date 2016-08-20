package com.pump.ia.activity.form;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;
import com.pump.ia.adapter.FormTitlesAdapter;
import com.pump.ia.adapter.MyFragmentAdapter;
import com.pump.ia.fragment.form.business.BusinessInfoFragment;
import com.pump.ia.fragment.form.share.BankBusinessFragment;
import com.pump.ia.fragment.form.share.ConclusionFragment;
import com.pump.ia.fragment.form.share.FamilyAssetsFragment;
import com.pump.ia.fragment.form.share.FamilyFinanceFragment;
import com.pump.ia.fragment.form.share.FamilyLiabilitiesFragment;
import com.pump.ia.fragment.form.share.FamilyMemberFragment;
import com.pump.ia.fragment.form.share.PersonInfoFragment;
import com.pump.ia.fragment.form.share.PotentialDemandFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

@ContentView(R.layout.activity_business_form)
public class BusinessFormActivity extends BaseActivity {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.rv_business_form_titles)
    private RecyclerView rv_business_form_titles;

    @ViewInject(R.id.vvp_business_form_content)
    private VerticalViewPager vvp_business_form_content;

    private FormTitlesAdapter titlesAdapter;

    private MyFragmentAdapter contentAdapter;

    private static final String[] TITLES = {"个人信息","商业信息","家庭成员","家庭总资产","家庭总负债","家庭收支","银行业务","潜在需求","结论"};
    private List<Fragment> contentList;

    private PersonInfoFragment personInfoFragment = new PersonInfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        initData();
        initView();

    }
    @Override
    protected void initData() {


        titlesAdapter = new FormTitlesAdapter(TITLES, this);

        contentList = new ArrayList<>();
        contentList.add(personInfoFragment);
        contentList.add(new BusinessInfoFragment());
        contentList.add(new FamilyMemberFragment());
        contentList.add(new FamilyAssetsFragment());
        contentList.add(new FamilyLiabilitiesFragment());
        contentList.add(new FamilyFinanceFragment());
        contentList.add(new BankBusinessFragment());
        contentList.add(new PotentialDemandFragment());
        contentList.add(new ConclusionFragment());

        contentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), contentList);

    }

    @Override
    protected void initView() {
        title_middle.setText("个体工商户");
        title_left.setVisibility(View.VISIBLE);
        rv_business_form_titles.setHasFixedSize(true);
        rv_business_form_titles.setLayoutManager(new LinearLayoutManager(this));
        Log.e("---------------","setAdapter");
        rv_business_form_titles.setAdapter(titlesAdapter);
        Log.e("---------------","titlesAdapterSet");
        titlesAdapter.setOnItemClickListener(new FormTitlesAdapter.TitleClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                vvp_business_form_content.setCurrentItem(position);
            }
        });


        vvp_business_form_content.setOffscreenPageLimit(10);
        vvp_business_form_content.setAdapter(contentAdapter);
        vvp_business_form_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                List<TextView> textViewList = titlesAdapter.getTvList();
                for(int i=0;i<textViewList.size();i++){
                    if(i == position){
                        textViewList.get(i).setBackgroundColor(getResources().getColor(R.color.blue_band_dark3));
                    }else{
                        textViewList.get(i).setBackgroundColor(getResources().getColor(R.color.white));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
