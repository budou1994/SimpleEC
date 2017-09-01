package com.budou.ec_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * package：com.budou.ec_core.app
 * author : 布兜小爱
 * e-mail : budou1994@qq.com
 * time   : 2017年08月31日 21:55
 * desc   ：管理各种配置项，各种配置文件的存储和管理。
 */

public class Configurator {

    /**
     * WeakHashMap 在键值不用的时候会进行自动回收资源
     */
    private static final HashMap<String, Object> EC_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList();

    /**
     * 初始化的时候，将配置未完成传递过去
     */
    private Configurator() {
        EC_CONFIGS.put(ConfigType.CONFIG_READY.name(), "false");
    }

    final HashMap<String, Object> getEcCONFIGS() {
        return EC_CONFIGS;
    }

    /**
     * 静态内部类完成单例实现，可保证线程安全
     */
    private static class Holder {
        private final static Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * 初始化字体库
     */
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 配置完成的方法
     */
    public void configure() {
        initIcons();
        EC_CONFIGS.put(ConfigType.CONFIG_READY.name(), "true");
    }

    /**
     * 对全局访问api进行配置
     *
     * @param host 配置api
     */
    public final Configurator withApiHost(String host) {
        EC_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    /**
     * 对文件配置完成进行检查，如果配置失败就抛出运行异常
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) EC_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready！Call Config");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) EC_CONFIGS.get(key.name());
    }


}
