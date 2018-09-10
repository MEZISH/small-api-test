package at.stepdefs

import at.operations.UserOperations
import cucumber.api.groovy.EN

import static at.context.StaticContext.*
import static at.utils.DataUtils.prettyFormatAddress
import static at.utils.ValidationUtils.isValidEmail

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */

this.metaClass.mixin(EN)

When(~/^random user data is retrieved$/) { ->
    def randomUserId = "${new Random().nextInt(9) + 1}"
    storeActiveUser(randomUserId)
    def userData = UserOperations.getUserData(randomUserId)
    storeLastResponse(userData)
}

Then(~/^user address should be present$/) { ->
    def activeUserAddress = lastResponse.address as Map
    println "\nUser $activeUser address is following:\n${prettyFormatAddress(activeUserAddress)}"
}

Then(~/^user e-mail should be valid$/) { ->
    assert isValidEmail(lastResponse.email as String)
}