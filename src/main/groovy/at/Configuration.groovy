package at
/**
 * Created by Kristaps Mezavilks on 05/03/2017.
 */
class Configuration {

    static
    final String API_URL = System.getProperty("api.url") == null ? System.getenv("api.url") : System.getProperty("api.url")
}
