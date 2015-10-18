package com.kanitkorn.android.kuhiw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantDescriptionFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public static RestaurantDescriptionFragment newInstance(String param1) {
        RestaurantDescriptionFragment fragment = new RestaurantDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RestaurantDescriptionFragment() {

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_description, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView tags = (TextView) view.findViewById(R.id.tags);
        switch (mParam1) {
            case "ร้านก๋วยเตี๋ยวหมูน้ำตก":
                description.setText("มีเส้นเล็ก เส้นใหญ่ วุ้นเส้น หมี่ขาว บะหมี่ มีหมูสด หมูตุ๋น หมูแดง ตับ ลูกชิ้นปลา ลูกชิ้นหมู เพิ่มน่องไก่ 15 บาท");
                tags.setText("ก๋วยเตี๋ยว บะหมี่ ตามสั่ง มาม่า น้ำตก เย็นตาโฟ เกาเหลา");
                break;
            case "ร้านข้าวไข่เจียว":
                description.setText("ไข่เจียวทรงเครื่อง (เลือกได้ 3 อย่าง) กับข้าวมีดังนี้ หมูหวาน ไก่แซ่บ ไก่กรอบ แกงเขียวหวาน ไส้กรอก แกงส้ม รับทำอาหารกล่อง");
                tags.setText("ไข่เจียว ข้าวราดแกง ข้าว");
                break;
            case "ร้านข้าวราดแกง":
                description.setText("กับข้าว 1 อย่าง 25 2 อย่าง 30");
                tags.setText("ข้าวราดแกง");
                break;
            case "ร้านอาหารญี่ปุ่น":
                description.setText("ราเมน แกงกะหรี่ ทงคัตสึ ซุปสาหร่าย ไก่เทอริยากิ ยากิโซบะ");
                tags.setText("ก๋วยเตี๋ยว อาหารญี่ปุ่น ตามสั่ง ทะเล");
                break;
            case "ร้านบะหมี่":
                description.setText("มีบะหมี่หมูแดง ต้มยำ เย็นตาโฟ ; เมนูเส้น บะหมี่ บะหมี่แบน บะหมี่หยก เส้นเล็ก เส้นใหญ่ วุ้นเส้น มาม่า เส้นหมี่ หมี่กรอบ");
                tags.setText("ก๋วยเตี๋ยว บะหมี่ ตามสั่ง มาม่า น้ำตก เย็นตาโฟ เกาเหลา หมูแดง หมูกรอบ");
                break;
        }
    }
}
