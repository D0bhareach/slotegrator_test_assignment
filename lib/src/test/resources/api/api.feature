Feature:

# get guest token
# need var to hold token how long? final?
    Scenario:
        Given need guest token
        When request guest token 
        Then have guest token
#
# register new_user
# need to create request must get new user credentials as response
    Scenario:
        Given have guest token
        When request to register 
        Then have user token
#
# login as registered new_user
##
# request new_user data
# send request with users token and get response
#
# request other user data
# find out how actually user is getting profile change something
# that must return 404. Take saved user and get new login tocken, need save token
    Scenario:
        Given have user token
        When request user profile
        Then must have user profile
        When request other user profile
        Then get response 404

