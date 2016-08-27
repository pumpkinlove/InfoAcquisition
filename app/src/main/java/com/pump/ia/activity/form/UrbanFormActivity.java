package com.pump.ia.activity.form;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.pump.ia.R;
import com.pump.ia.activity.BaseActivity;
import com.pump.ia.adapter.FormTitlesAdapter;
import com.pump.ia.adapter.MyFragmentAdapter;
import com.pump.ia.fragment.form.share.BankBusinessFragment;
import com.pump.ia.fragment.form.share.ConclusionFragment;
import com.pump.ia.fragment.form.share.FamilyAssetsFragment;
import com.pump.ia.fragment.form.share.FamilyFinanceFragment;
import com.pump.ia.fragment.form.share.FamilyLiabilitiesFragment;
import com.pump.ia.fragment.form.share.FamilyMemberFragment;
import com.pump.ia.fragment.form.share.PersonInfoFragment;
import com.pump.ia.fragment.form.share.PotentialDemandFragment;
import com.pump.ia.fragment.form.urban.CareerFragment;
import com.pump.ia.view.RvDividerDecoration;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

@ContentView(R.layout.activity_urban_form)
public class UrbanFormActivity extends BaseActivity {

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.rv_urban_form_titles)
    private RecyclerView rv_urban_form_titles;

    @ViewInject(R.id.vvp_urban_form_content)
    private VerticalViewPager vvp_urban_form_content;

    private FormTitlesAdapter titlesAdapter;

    private MyFragmentAdapter contentAdapter;

    private static final String[] TITLES = {"个人信息","工作信息","家庭成员","家庭总资产","家庭总负债","家庭收支","银行业务","潜在需求","结论"};
    private List<Fragment> contentList;

    private PersonInfoFragment personInfoFragment = new PersonInfoFragment();
    private CareerFragment careerFragment = new CareerFragment();
    private FamilyMemberFragment familyMemberFragment = new FamilyMemberFragment();
    private FamilyAssetsFragment familyAssetsFragment = new FamilyAssetsFragment();
    private FamilyLiabilitiesFragment familyLiabilitiesFragment = new FamilyLiabilitiesFragment();
    private FamilyFinanceFragment familyFinanceFragment = new FamilyFinanceFragment();
    private BankBusinessFragment bankBusinessFragment = new BankBusinessFragment();
    private PotentialDemandFragment potentialDemandFragment = new PotentialDemandFragment();
    private ConclusionFragment conclusionFragment = new ConclusionFragment();

    private int flagPosition = 0;

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
        contentList.add(careerFragment);
        contentList.add(familyMemberFragment);
        contentList.add(familyAssetsFragment);
        contentList.add(familyLiabilitiesFragment);
        contentList.add(familyFinanceFragment);
        contentList.add(bankBusinessFragment);
        contentList.add(potentialDemandFragment);
        contentList.add(conclusionFragment);

        contentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), contentList);

    }

    @Override
    protected void initView() {
        title_middle.setText("城镇居民");
        title_left.setVisibility(View.VISIBLE);
        rv_urban_form_titles.setHasFixedSize(true);
        rv_urban_form_titles.setLayoutManager(new LinearLayoutManager(this));
        rv_urban_form_titles.addItemDecoration(new RvDividerDecoration(this,RvDividerDecoration.VERTICAL_LIST));
        rv_urban_form_titles.setAdapter(titlesAdapter);
        titlesAdapter.setOnItemClickListener(new FormTitlesAdapter.TitleClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                vvp_urban_form_content.setCurrentItem(position);
            }
        });

        vvp_urban_form_content.setOffscreenPageLimit(10);
        vvp_urban_form_content.setAdapter(contentAdapter);
        vvp_urban_form_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                List<TextView> textViewList = titlesAdapter.getTvList();
                textViewList.get(flagPosition).setBackgroundColor(getResources().getColor(R.color.white));
                textViewList.get(flagPosition).setTextColor(getResources().getColor(R.color.gray_light));
                textViewList.get(position).setBackgroundColor(getResources().getColor(R.color.blue_band_light));
                textViewList.get(position).setTextColor(getResources().getColor(R.color.black));
                flagPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Event(value = R.id.title_left)
    private void goBack(View view){
        finish();
    }

}
