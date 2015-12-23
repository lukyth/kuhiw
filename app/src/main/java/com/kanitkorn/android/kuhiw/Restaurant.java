package com.kanitkorn.android.kuhiw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lukyth on 12/10/2015 AD.
 */
public class Restaurant {
    /**
     * An array of sample (dummy) items.
     */
    public static final List<RestaurantItem> ITEMS = new ArrayList<RestaurantItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, RestaurantItem> ITEM_MAP = new HashMap<String, RestaurantItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(RestaurantItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static RestaurantItem createDummyItem(int position) {
        if (position == 1) {
            return new RestaurantItem(String.valueOf(position), "ร้านก๋วยเตี๋ยวหมูน้ำตก", "มีเส้นเล็ก เส้นใหญ่ วุ้นเส้น หมี่ขาว บะหมี่ มีหมูสด หมูตุ๋น หมูแดง ตับ ลูกชิ้นปลา ลูกชิ้นหมู เพิ่มน่องไก่ 15 บาท");
        }
        else if (position == 2) {
            return new RestaurantItem(String.valueOf(position), "ร้านข้าวไข่เจียว", "ไข่เจียวทรงเครื่อง (เลือกได้ 3 อย่าง) กับข้าวมีดังนี้ หมูหวาน ไก่แซ่บ ไก่กรอบ แกงเขียวหวาน ไส้กรอก แกงส้ม รับทำอาหารกล่อง");
        }
        else if (position == 3) {
            return new RestaurantItem(String.valueOf(position), "ร้านข้าวราดแกง", "กับข้าว 1 อย่าง 25 2 อย่าง 30");
        }
        else if (position == 4) {
            return new RestaurantItem(String.valueOf(position), "ร้านอาหารญี่ปุ่น", "ราเมน แกงกะหรี่ ทงคัตสึ ซุปสาหร่าย ไก่เทอริยากิ ยากิโซบะ");
        }
        return new RestaurantItem(String.valueOf(position), "ร้านบะหมี่", "มีบะหมี่หมูแดง ต้มยำ เย็นตาโฟ ; เมนูเส้น บะหมี่ บะหมี่แบน บะหมี่หยก เส้นเล็ก เส้นใหญ่ วุ้นเส้น มาม่า เส้นหมี่ หมี่กรอบ");
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class RestaurantItem {
        public final String id;
        public final String title;
        public final String description;

        public RestaurantItem(String id, String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
