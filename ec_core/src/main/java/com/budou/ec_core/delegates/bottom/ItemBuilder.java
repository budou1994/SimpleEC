package com.budou.ec_core.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * package：com.budou.ec_core.delegates.bottom
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年09月08日 23:22
 * desc   ：
 */

public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDelegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDelegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public LinkedHashMap<BottomTabBean, BottomItemDelegate> Build(){
        return ITEMS;
    }
}
