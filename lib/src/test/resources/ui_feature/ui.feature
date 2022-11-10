Feature: Admin can sort players.
    Scenario: Login admin
        Given can get login and password inputs
        When enter login
        When enter password
        Then submit credentials

    Scenario: Go to players page
        Given admin home page is current
        Then  get to players page


    Scenario: Get single player and compare
        Given sort players by name
            |GORMSX	 |1481635fa3a2bd4bd|LXXTL@example.com|
        When only one player
        Then get player and compare
            |GORMSX	 |1481635fa3a2bd4bd|LXXTL@example.com|

    Scenario: Clean after
        Given clean context
