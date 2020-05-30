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
  "name": "An organization is created",
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
  "name": "A category is created",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.createCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A category is deleted",
  "keyword": "And "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An organization is deleted",
  "keyword": "And "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteOrganization()"
});
formatter.result({
  "status": "passed"
});
});