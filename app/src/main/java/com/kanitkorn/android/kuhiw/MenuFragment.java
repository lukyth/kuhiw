package com.kanitkorn.android.kuhiw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuFragment extends Fragment {

    private ListView mListView;

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MenuFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Construct the data source
        ArrayList<Menu> arrayOfMenus = new ArrayList<>();
        // Create the adapter to convert the array to views
        MenusAdapter mAdapter = new MenusAdapter(getActivity(), arrayOfMenus);
        // Attach the adapter to a ListView
        mListView = (ListView) view.findViewById(android.R.id.list);

        mAdapter.add(new Menu("Test1", 10, 20));
        mAdapter.add(new Menu("Test2", 20, 30));
        mAdapter.add(new Menu("Test3", 30, 40));
        mAdapter.add(new Menu("Test1", 10, 20));
        mAdapter.add(new Menu("Test2", 20, 30));
        mAdapter.add(new Menu("Test3", 30, 40));
        mAdapter.add(new Menu("Test1", 10, 20));
        mAdapter.add(new Menu("Test2", 20, 30));
        mAdapter.add(new Menu("Test3", 30, 40));
        mAdapter.add(new Menu("Test1", 10, 20));
        mAdapter.add(new Menu("Test2", 20, 30));
        mAdapter.add(new Menu("Test3", 30, 40));

        mListView.setAdapter(mAdapter);

        return view;
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }


}
