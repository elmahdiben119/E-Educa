package com.educa.ebenbrahimkbenazzou.educa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFrag extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        return view;

    }
}
/*list.add("دروس");
        list.add("دروس فيديو");
        list.add("تمارين خْطْوَخْطْوَ");
        list.add("اختبارات");*/