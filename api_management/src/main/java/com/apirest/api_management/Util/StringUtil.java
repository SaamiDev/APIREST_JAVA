package com.apirest.api_management.Util;

import java.util.Objects;

public class StringUtil {

    public static String safeToString(String input) { return Objects.toString(input, ""); }

    public static String safeToLong(Long input) { return input != null ? input.toString() : ""; }
}
