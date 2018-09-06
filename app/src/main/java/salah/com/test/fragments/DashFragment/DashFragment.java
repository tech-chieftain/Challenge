package salah.com.test.fragments.DashFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import salah.com.test.R;

public class DashFragment extends Fragment {
    private View rootView;
    private String[] words = {"Book", "Apple", "School", "Keep", "Enlarge", "Trouble", "Bask", "Able", "Loot", "Lore"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dash, container, false);

        ListView listview = rootView.findViewById(R.id.list_view);

        listview.setAdapter(new ListAdapter(rootView.getContext()));

        return rootView;
    }
    private class ListAdapter extends BaseAdapter {
        private Context mContext;
        private ListAdapter(Context context){
            mContext = context;

        }


        @Override
        public int getCount() {
            return words.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            View row = layoutInflater.inflate(R.layout.lv_row, viewGroup, false);

            TextView word = row.findViewById(R.id.txt_word);
            word.setText("Word is: " + words[position]);




            return row;
        }
    }

}
