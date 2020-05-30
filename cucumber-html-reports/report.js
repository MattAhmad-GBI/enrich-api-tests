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
  "name": "List Enrich Categories",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The Customer lists categories",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.viewCategory()"
});
formatter.result({
  "status": "passed"
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
  "name": "Delete Enrich Category",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The Customer deletes the category",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteCategory()"
});
formatter.result({
  "status": "passed"
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
  "name": "Delete Enrich Organization",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "The Customer deletes the organization",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.deleteOrganization()"
});
formatter.result({
  "status": "passed"
});
});