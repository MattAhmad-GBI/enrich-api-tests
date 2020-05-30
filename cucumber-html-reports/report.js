$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/scenarios/category.feature");
formatter.feature({
  "name": "Categories",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create an Enrich Category",
  "description": "",
  "keyword": "Scenario"
});
formatter.uri("file:src/test/resources/scenarios/organization.feature");
formatter.feature({
  "name": "Organizations",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create an Enrich Organization",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "An organization is created in enrich",
  "keyword": "Given "
});
formatter.match({
  "location": "com.groupbyinc.steps.enrich.EnrichStepDefinitions.createOrganization()"
});
formatter.result({
  "status": "passed"
});
});