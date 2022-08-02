package com.workshop.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class DecoderURL {

    public static String urlDecoder(String url) {
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }
}
