package at.operations

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class UserOperations extends ApiOperations {

    private static final USER_ENDPOINT = "users"

    static Map getUserData(String userId) {
        def response = api()
                .target("$USER_ENDPOINT/$userId")
                .get()

        response
    }
}
