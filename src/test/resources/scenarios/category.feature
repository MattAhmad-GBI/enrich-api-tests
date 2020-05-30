Feature: Category

          Background: Create Enrich test fixtures
          Given The Customer creates an organization
          #Then Expect organization creation has value 200 in response

          Scenario: Create an Enrich Category
            Given The Customer creates a category

          Scenario: List Enrich Categories
            Given The Customer lists categories

          Scenario: Delete Enrich Category
            Given The Customer deletes the category

          Scenario: Delete Enrich Organization
            Given The Customer deletes the organization
