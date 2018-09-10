package at.utils

import org.apache.commons.validator.routines.EmailValidator

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */
class ValidationUtils {

    static boolean isValidEmail(String email) {
        EmailValidator.getInstance().isValid(email.trim())
    }

    static boolean isValidPost(Map postData) {
        isValidId(postData.id as String) && isValidTitle(postData.title as String) && isValidBody(postData.body as String)
    }

    static boolean isValidBody(String body) {
        body != null && body.length() <= Integer.MAX_VALUE
    }

    static boolean isValidTitle(String title) {
        title != null && title.length() <= 255
    }

    static boolean isValidId(String id) {
        def isValid = true
        try {
            Integer.parseInt(id)
        } catch (NumberFormatException exc) {
            isValid = false
        }
        isValid
    }
}
