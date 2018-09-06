package salah.com.test.fragments.HomeFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import salah.com.test.R;

public class HomeFragment extends Fragment {
    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    private static List<item> demoData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);


    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.rv_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        demoData = new ArrayList<item>();
        for (int i = 0; i < 40; i++) {
            item item = new item();
            item.name = "Text ";
            item.age = (byte) (20 + i);
            demoData.add(item);
        }
        adapter = new RecyclerViewAdapter(demoData);
        recyclerView.setAdapter(adapter);
    }

}
