package at.context

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class StaticContext extends ValueStore {

    private static final String ACTIVE_USER_KEY = "activeUser"
    private static final String LAST_REQUEST_KEY = "lastReq"

    static storeActiveUser(String userId) {
        store(ACTIVE_USER_KEY, userId)
    }

    static String getActiveUser() {
        get(ACTIVE_USER_KEY) as String
    }

    static storeLastResponse(Map response) {
        store(LAST_REQUEST_KEY, response)
    }

    static Map getLastResponse() {
        get(LAST_REQUEST_KEY) as Map
    }
}
