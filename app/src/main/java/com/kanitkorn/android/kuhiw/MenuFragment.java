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

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MenuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
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

        switch (mParam1) {
            case "ร้านก๋วยเตี๋ยวหมูน้ำตก":
                mAdapter.add(new Menu("หมูน้ำตก", 30, 30));
                mAdapter.add(new Menu("หมูต้มยำน้ำข้น", 30, 30));
                mAdapter.add(new Menu("หมูต้มยำน้ำใส", 30, 30));
                mAdapter.add(new Menu("บะหมี่", 30, 30));
                mAdapter.add(new Menu("เกี๊ยว", 30, 30));
                mAdapter.add(new Menu("บะหมี่เกี๊ยว", 30, 35));
                mAdapter.add(new Menu("หมูตุ๋น(อย่างเดียว)", 30, 35));
                mAdapter.add(new Menu("เกาเหลา", 30, 35));
                mAdapter.add(new Menu("มาม่า", 30, 40));
                mAdapter.add(new Menu("ก๋วยเตี๊ยวไก่ทอด", 30, 35));
                mAdapter.add(new Menu("เย็นตาโฟ", 30, 30));
                mAdapter.add(new Menu("เย็นตาโฟต้มยำ", 30, 30));
                mAdapter.add(new Menu("หมูน้ำตกต้มยำ", 30, 30));
                mAdapter.add(new Menu("เส้นเซี่ยงไฮต้มยำ", 30, 30));
                mAdapter.add(new Menu("ไข่ต้ม, ไข่ลวก", 6, 6));
                mAdapter.add(new Menu("ไข่ตานี", 7, 7));
                mAdapter.add(new Menu("แคปหมู", 5, 5));
                mAdapter.add(new Menu("ข้าวเปล่า", 5, 5));
                break;
            case "ร้านข้าวไข่เจียว":
                mAdapter.add(new Menu("ไข่เจียวฟองเดียว", 20, 20));
                mAdapter.add(new Menu("ไข่เจียวสองฟอง", 25, 25));
                mAdapter.add(new Menu("เพิ่มกับข้าว(1,2 อย่าง)", 10, 10));
                mAdapter.add(new Menu("ข้าวราดแกง(ไม่เอาไข่)", 25, 25));
                mAdapter.add(new Menu("ข้าวคลุกกะปิ", 35, 35));
                break;
            case "ร้านข้าวราดแกง":
                mAdapter.add(new Menu("หมูหวาน", 0, 0));
                mAdapter.add(new Menu("หมูทอดกระเทียม", 0, 0));
                mAdapter.add(new Menu("ตับหมูอบ", 0, 0));
                mAdapter.add(new Menu("ไก่อบ", 0, 0));
                mAdapter.add(new Menu("ไก่อบ", 0, 0));
                mAdapter.add(new Menu("ลาบหมู", 0, 0));
                mAdapter.add(new Menu("ลาบไก่", 0, 0));
                mAdapter.add(new Menu("ตุ๋นมะระยัดไส้หมูสับ", 15, 30));
                mAdapter.add(new Menu("ตุ๋นฟักน่องไก่", 15, 15));
                mAdapter.add(new Menu("ไข่ดาว", 7, 7));
                mAdapter.add(new Menu("ไข่ตุ๋น", 10, 10));
                mAdapter.add(new Menu("ต้มเเซ่บกระดูกอ่อน", 20, 30));
                break;
            case "ร้านอาหารญี่ปุ่น":
                mAdapter.add(new Menu("ทงคัตสึราเมน", 33, 33));
                mAdapter.add(new Menu("ชาชูเมน", 33, 33));
                mAdapter.add(new Menu("ต้มยำกุ้ง ราเมน", 40, 40));
                mAdapter.add(new Menu("ต้ำยำชาชู ราเมน", 28, 28));
                mAdapter.add(new Menu("ต้มยำทงคัตสึ ราเมน", 33, 33));
                mAdapter.add(new Menu("ยากิโซบะ", 33, 33));
                mAdapter.add(new Menu("ข้าวหน้าหมูทงคัตสึ", 30, 30));
                mAdapter.add(new Menu("ข้าวหน้าหมูชาชู", 30, 30));
                mAdapter.add(new Menu("ชุดข้าวต้มยำ", 35, 35));
                mAdapter.add(new Menu("เกี๊ยวซ่า", 30, 30));
                mAdapter.add(new Menu("ข้าวต้มไข่ออนเซนชุบโชยุ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าปลาซาบะ", 35, 35));
                mAdapter.add(new Menu("ต้มยำทะเลราเมนแห้ง", 40, 40));
                mAdapter.add(new Menu("ต้มยำหมูสับราเมน", 33, 33));
                mAdapter.add(new Menu("หมูบูตะทรงเครื่องราเมนซุปโอตะ", 35, 35));
                mAdapter.add(new Menu("ปูอัดราเมนซุปโชยุ", 35, 35));
                mAdapter.add(new Menu("หมูบูตะราเมนซุปแกงกะหรี่", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าแกงกะหรี่ทงคัตสึ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าแกงกะหรี่หมูบูตะ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าไก่ซี้ด", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าเบคอน", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าไก่เทอริยากิ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าหมูเทอริยากิ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าไก่คาราเกะ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าไก่โอยาโกะต้ง", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าหมูบูตะ", 35, 35));
                mAdapter.add(new Menu("ข้าวหน้าไก่ทัตซึต้ง", 35, 35));
                break;
            case "ร้านบะหมี่":
                mAdapter.add(new Menu("ข้าวเปล่า", 5, 5));
                mAdapter.add(new Menu("เพิ่มไข่ลวก", 7, 7));
                mAdapter.add(new Menu("หมูน้ำใส", 30, 35));
                mAdapter.add(new Menu("หมูต้มยำ", 30, 35));
                mAdapter.add(new Menu("หมูสาหร่าย", 30, 35));
                mAdapter.add(new Menu("ไก่ทอดต้มยำ", 30, 35));
                mAdapter.add(new Menu("หมูกรอบต้มยำ", 30, 35));
                mAdapter.add(new Menu("หมูตุ๋น", 30, 40));
                mAdapter.add(new Menu("ไก่ตุ๋น", 30, 40));
                mAdapter.add(new Menu("สุกี้หมู-ทะเล", 30, 40));
                mAdapter.add(new Menu("ลูกชิ้นแคระ", 30, 35));
                mAdapter.add(new Menu("ทะเลต้มยำ", 35, 40));
                mAdapter.add(new Menu("บะหมี่หมูแดง", 30, 35));
                mAdapter.add(new Menu("เกี๊ยวน้ำ", 30, 35));
                mAdapter.add(new Menu("เกาเหลา", 30, 35));
                mAdapter.add(new Menu("เย็นตาโฟ", 30, 35));
                break;
        }

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
