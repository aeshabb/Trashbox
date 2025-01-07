package org.itmo;

import com.fastcgi.FCGIInterface;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        while (new FCGIInterface().FCGIaccept() >= 0) {

            long startTime = System.currentTimeMillis(); // Track start time
            try {
                log.info("Processing request...");

                // Get QUERY_STRING from request
                String queryString = FCGIInterface.request.params.getProperty("QUERY_STRING");
                if (queryString == null || queryString.isEmpty()) {
                    JsonProcessing.sendError("{\"error\": \"No query parameters received\"}");
                    continue;
                }

                log.info("Received query string: " + queryString);

                // Parse query parameters
                Map<String, String> params = parseQueryString(queryString);

                // Extract x, y, and r from params
                double x = Double.parseDouble(params.getOrDefault("x", "NaN"));
                double y = Double.parseDouble(params.getOrDefault("y", "NaN"));
                double r = Double.parseDouble(params.getOrDefault("r", "NaN"));

                // Validate data
                String responseJson;
                if (Validate.validateX(x) && Validate.validateY(y) && Validate.validateR(r)) {
                    boolean hit = Validate.check(x, y, r);
                    responseJson = String.format("{\"hit\": %b}", hit);
                    log.info("Result sent");
                } else {
                    responseJson = "{\"error\": \"Invalid data\"}";
                    log.info("Error sent");
                }

                JsonProcessing.sendJson(startTime, responseJson);

            } catch (Exception e) {
                JsonProcessing.sendError(String.format("{\"error\": \"%s\"}", e.getMessage()));
            }
        }

    }

    private static Map<String, String> parseQueryString(String queryString) throws UnsupportedEncodingException {
        Map<String, String> queryParams = new HashMap<>();
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            if (idx > 0) {
                String key = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
                String value = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
                queryParams.put(key, value);
            }
        }
        return queryParams;
    }
}
