Feature:

# get guest token
# need var to hold token how long? final?
    Scenario: get guest token and get register new user.
        Given need guest token
        And request to register new user
        And  new user has token
        When request user profile
        Then must have user profile
        Then request other user profile get response 404

