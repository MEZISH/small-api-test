package at.operations

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class PostOperations extends ApiOperations {

    private static final String POSTS_ENDPOINT = "posts"

    static Map getUserPosts(String userId) {
        def response = api()
                .target(POSTS_ENDPOINT)
                .param("userId", userId)
                .get()

        response
    }

    static Map createNewPost(String userId, Map postData) {
        def response = api()
                .target("$POSTS_ENDPOINT/$userId")
                .put(postData)

        response
    }
}
