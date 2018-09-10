package at.utils

import groovy.json.JsonSlurper
import org.apache.http.HttpResponse

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class DataUtils {

    static Map httpResponseToMap(HttpResponse response) {
        def bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
        def jsonResponse = bufferedReader.getText()

        new JsonSlurper().parseText(jsonResponse) as Map
    }

    static String prettyFormatAddress(Map address) {
        def prettyAddress = ""
        if (address != null) {
            address.keySet().each { String key ->
                prettyAddress += "$key:${address.get(key)}\n"
            }
        } else {
            prettyAddress = "N/A"
        }
        prettyAddress
    }
}