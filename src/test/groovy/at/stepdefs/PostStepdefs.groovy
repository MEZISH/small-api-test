package at.stepdefs

import at.operations.PostOperations
import cucumber.api.DataTable
import cucumber.api.groovy.EN

import static at.context.StaticContext.*
import static at.utils.ValidationUtils.isValidPost

/**
 * Created by Kristaps Mezavilks on 05.03.2017.
 */

this.metaClass.mixin(EN)

When(~/^posts of the user are retrieved$/) { ->
    def userPostData = PostOperations.getUserPosts(activeUser)

    Map temp = new HashMap()
    temp.put("posts", userPostData as ArrayList<Map>)
    storeLastResponse(temp)
}

Then(~/^user should have valid posts$/) { ->
    def postArrayData = lastResponse.posts as ArrayList<Map>
    postArrayData.each { Map post -> assert isValidPost(post) }
}

When(~/^the user creates following valid post:$/) { DataTable rawPostData ->
    def postData = rawPostData.asMap(String.class, String.class)
    def newPostData = PostOperations.createNewPost(activeUser, postData)

    Map temp = new HashMap()
    temp.put("id", newPostData.id)
    storeLastResponse(temp)
}

Then(~/^post should be posted$/) { ->
    assert lastResponse.id != null: "Failed to create a post!"
}

