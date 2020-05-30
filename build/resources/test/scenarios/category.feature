Feature: Category

          Background: Create Enrich test fixtures
          Given The Customer creates an organization
          #Then Expect organization creation has value 200 in response

          Scenario: Create an Enrich Category
            Given The Customer creates a category
            And The Customer views a category
            And The Customer deletes the category
            And The Customer deletes the organization
