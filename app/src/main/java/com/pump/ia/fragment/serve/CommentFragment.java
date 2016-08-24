package com.pump.ia.fragment.serve;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pump.ia.R;
import com.pump.ia.adapter.CommentAdapter;
import com.pump.ia.domain.serve.Comment;
import com.pump.ia.utils.DateUtil;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment {

    @ViewInject(R.id.rv_comment)
    private RecyclerView rv_comment;

    @ViewInject(R.id.iv_add_comment)
    private ImageView iv_add_comment;

    @ViewInject(R.id.et_new_comment)
    private EditText et_new_comment;

    @ViewInject(R.id.title_left)
    private TextView title_left;

    @ViewInject(R.id.title_middle)
    private TextView title_middle;

    private CommentAdapter commentAdapter;

    private List<Comment> commentList;

    private Comment newComment;

    private int answerId;
    private String answerName;

    public CommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comment, container, false);
        x.view().inject(this, v);

        initData();
        initView();

        return v;
    }

    private void initData(){
        commentList = new ArrayList<>();
        commentAdapter = new CommentAdapter(commentList, getContext(), null);
    }

    private void initView(){
        title_left.setVisibility(View.VISIBLE);
        title_middle.setText("评论");
        rv_comment.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_comment.setAdapter(commentAdapter);
        commentAdapter.setCommentListener(new CommentAdapter.CommentListener() {
            @Override
            public void onItemClick(View view, int position) {
                answerId = commentList.get(position).getId();
                answerName = commentList.get(position).getName();
                et_new_comment.setHint("回复: "+ answerName );
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

    }

    @Event(value = R.id.iv_add_comment)
    private void addComment(View view){
        if(et_new_comment.getText().length() == 0){
            return;
        }
        newComment = new Comment();
        newComment.setName("小约");
        newComment.setAnswerId(answerId);
        newComment.setAnswerName(answerName);
        newComment.setContent(et_new_comment.getText().toString());
        newComment.setId(commentList.size()+1);
        newComment.setTime(DateUtil.toMonthDay(new Date()) + "   " + DateUtil.toHourMinString(new Date()));
        commentList.add(newComment);
        commentAdapter.notifyDataSetChanged();
        et_new_comment.setHint("添加评论");
        et_new_comment.setText("");
    }

    @Event(value = R.id.title_left)
    private void goBack(View view){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(this);
        ft.commit();
    }

}
