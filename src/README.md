Purpose of the project is to smoke test integrated Seachandiser modules including Authentication, Ingestion, Command Center, Search etc.

Smoke testing uses Cucumber Testing framework along with SpringBoot.
Cucumber follows BDD (Behaviour Driven Driven). See https://cucumber.io/ for instructions how to work with Cucumber.
In particular, see https://github.com/cucumber/cucumber-jvm/tree/v5.5.0/spring on how project was original setup.

To Run Locally:
./gradlew cleanTest test

How to use:
To create Test Scenarios
1. Create a scenario under /src/resources/scenarios
2. Try to reuse Steps defined in com/groupbyinc. For example, AuthenticationServiceStepDefinitions.java contains
   a reusable step for authenticating a user given credentials.
3. If need be create a new StepDefinition class and add required Steps.

Best practices
For best practices and anti-patterns see.
https://cucumber.io/docs/gherkin/step-organization/
https://cucumber.io/docs/guides/anti-patterns/

Sharing state:
Steps defined in scenarios can share and communicate state using Spring Injection.
The scope of the beans will be scenario scoped. This means beans will be reset for each
scenario to ensure beans are not affecting other scenario test cases.
See the following https://cucumber.io/docs/cucumber/state/#dependency-injection
