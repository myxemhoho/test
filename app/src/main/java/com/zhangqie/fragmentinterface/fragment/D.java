package com.zhangqie.fragmentinterface.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zhangqie.fragmentinterface.R;
import com.zhangqie.fragmentinterface.function.FunctionException;

/**
 * Created by zhangqie on 2017/9/26.
 */

public class D extends BaseFragment{

    public static final  String INTERFCE=A.class.getName() +"D";

    private Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.a,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn=(Button)getView().findViewById(R.id.btn);
        btn.setText("有参数有返回");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }

    public void onButtonPressed(){
        try {
            //得到返回值
            String result = mFunctionManager.invokeFunction(INTERFCE,"666",String.class);
            Toast.makeText(getActivity(),result,Toast.LENGTH_LONG).show();
        } catch (FunctionException e) {
            e.printStackTrace();
        }
    }

}
