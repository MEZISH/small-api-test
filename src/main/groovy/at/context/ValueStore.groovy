package at.context

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class ValueStore {

    static Map valueStore = new HashMap<String, Object>()

    static clean() {
        valueStore = new HashMap<String, Object>()
    }

    static void store(String key, Object value) {
        valueStore.remove(key)
        valueStore.put(key, value)
    }

    static Object get(String key) {
        valueStore.get(key)
    }
}