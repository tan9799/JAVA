package com.hdu.historianai.util;

import java.util.Random;

public class StyleRandomizer {
    private static final String[] STYLES = {
            "复古胶片风",
            "赛博朋克风",
            "水墨国风",
            "像素游戏风"
    };
    private static final Random random = new Random();

    public static String getRandomStyle() {
        return STYLES[random.nextInt(STYLES.length)];
    }
}