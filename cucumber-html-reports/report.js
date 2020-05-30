$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/scenarios/category.feature");
formatter.feature({
  "name": "Category",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Create Enrich test fixtures",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "The Customer creates an organization",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.createOrganization()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create an Enrich Category",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The Customer creates a category",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.createCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Customer views a category",
  "keyword": "And "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.viewCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Customer deletes the category",
  "keyword": "And "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Customer deletes the organization",
  "keyword": "And "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteOrganization()"
});
formatter.result({
  "status": "passed"
});
});