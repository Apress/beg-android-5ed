package com.artifexdigital.android.colorfragmentsexample.color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Helper class for a color list - could easily replace with a content provider
 */

public class ColorContent {

    public static List<ColorItem> ITEMS = new ArrayList<ColorItem>();

    public static Map<String, ColorItem> ITEM_MAP = new HashMap<String, ColorItem>();

    static {
        addItem(new ColorItem("1", "Red"));
        addItem(new ColorItem("2", "Orange"));
        addItem(new ColorItem("3", "Yellow"));
        addItem(new ColorItem("4", "Green"));
        addItem(new ColorItem("5", "Blue"));
        addItem(new ColorItem("6", "Indigo"));
        addItem(new ColorItem("7", "Violet"));
        addItem(new ColorItem("8", "White"));
        addItem(new ColorItem("9", "Black"));
    }

    private static void addItem(ColorItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class ColorItem {
        public String id;
        public String content;

        public ColorItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
