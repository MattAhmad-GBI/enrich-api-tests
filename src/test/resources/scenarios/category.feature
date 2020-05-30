Feature: Category

          Background: Create Enrich test fixtures
          Given An organization is created
          #Then Expect organization creation has value 200 in response

          Scenario: Create an Enrich Category
            Given A category is created
            And A category is deleted
            And An organization is deleted
