Feature: Admin can sort players.
    Scenario: Login admin
        Given can get login and password inputs
        When enter login
        When enter password
        Then submit credentials

    Scenario: Go to players page
        Given admin home page is current
        Then  get to players page

        # Scenario: Get fisrt of many and check
        #     Given driver on players page
        #     When number of rows more then one
        #     Then compare several players
        #         |TPEFVO	 |2692635fa3a311bbf|ZOWKD@example.com|
        #         |ONXNXZ	 |1425635fa3a2cc30a|FDDJH@example.com|
        #         |GORMSX	 |1481635fa3a2bd4bd|LXXTL@example.com|
        #         |OAUBYU	 |6970635fa3a2af7b5|OBRBX@example.com|
        #         |XJDBSV	 |5563635fa3a260cff|SNEIB@example.com|


    Scenario: Get single player and compare
        Given sort players by name
            |GORMSX	 |1481635fa3a2bd4bd|LXXTL@example.com|
        When only one player
        Then get player and compare
            |GORMSX	 |1481635fa3a2bd4bd|LXXTL@example.com|

    Scenario: Clean after
        Given clean context
