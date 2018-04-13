import cucumber.api.PendingException

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

Then(~/^User is not present in bank$/) { ->
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException()
}