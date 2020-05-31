Feature: Category

#          Background: Create Enrich test fixtures
#          Given The Customer creates an organization
          #Then Expect status code has value 200 in response

          Scenario: Create an Enrich Organization
            Given The Customer creates an organization

          Scenario: List Enrich Organizations
            Given The Customer lists organizations

          Scenario: Modify an Enrich Organization
            Given The Customer modifies an organization

          Scenario: View an Enrich Organization
            Given The Customer views an organization

          Scenario: Create an Enrich Category
            Given The Customer creates a category

          Scenario: List Enrich Categories
            Given The Customer lists categories

          Scenario: Modify an Enrich Category
            Given The Customer modifies a category

          Scenario: View an Enrich Category
            Given The Customer views a category

          Scenario: Delete Enrich Category
            Given The Customer deletes the category

          Scenario: Delete Enrich Organization
            Given The Customer deletes the organization
