package com.groupbyinc.steps.enrich;

import com.groupbyinc.Config;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;
import java.net.URL;
import org.junit.Assert;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.HttpRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

    public class EnrichStepDefinitions {

        private static final String JSON_TYPE = "application/json;charset=UTF-8";

        @Autowired
        private Config config;

        @Autowired
        private EnrichResults searchResults;
        private String strOrganizationId, strCategoryId, resViewCategory;

        @Given("The Customer creates an organization")
        public void createOrganization() {

        HttpClient httpClientCreateOrganization = HttpClients.createDefault();
        try {
            URIBuilder builderCreateOrganization = new URIBuilder(config.getUrl() + "/organizations");
            URI uriCreateOrganization = builderCreateOrganization.build();
            HttpPost requestCreateOrganization = new HttpPost(uriCreateOrganization);
            requestCreateOrganization.setHeader("Content-Type", "application/vnd.api+json");

            String payloadCreateOrganization = "{" +
                    " \"data\": " +
                    "{" +
                    " \"type\": \"Organization\"," +
                    " \"attributes\": " +
                    "{" +
                    " \"name\": \"Organization14\"" +
                    "}" +
                    "}" +
                    "}";

            StringEntity entityCreateOrganization = new StringEntity(payloadCreateOrganization);
            requestCreateOrganization.setEntity(entityCreateOrganization);
            HttpResponse resCreateOrganization = httpClientCreateOrganization.execute(requestCreateOrganization);

            Assert.assertEquals(201, resCreateOrganization.getStatusLine().getStatusCode());

            String strResponseOrganization = EntityUtils.toString(resCreateOrganization.getEntity());
            System.out.println("Create Organization Response is: " + strResponseOrganization);
            JSONObject jsonObjCreateOrganization = new JSONObject(strResponseOrganization);
            JSONObject jsonObjData = jsonObjCreateOrganization.getJSONObject("data");
            JSONArray jsonArrData = new JSONArray();
            jsonArrData.put(jsonObjData);

        for (int i = 0; i < jsonArrData.length(); i++) {
            JSONObject jsonObjId = jsonArrData.getJSONObject(0);
            strOrganizationId = jsonObjId.getString("id");
            System.out.println(strOrganizationId);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

        @Given("The Customer creates a category")
        public void createCategory() {

            HttpClient httpClientCreateCategory = HttpClients.createDefault();
            try {
                URIBuilder builderCreateCategory = new URIBuilder(config.getUrl() + "/categories");
                URI uriCreateCategory = builderCreateCategory.build();
                HttpPost requestCreateCategory = new HttpPost(uriCreateCategory);
                requestCreateCategory.setHeader("Content-Type", "application/vnd.api+json");

                String payloadCreateCategory = "{" +
                        " \"data\": " +
                        "{" +
                        " \"type\": \"Category\"," +
                        " \"attributes\": " +
                        "{" +
                        " \"proprietaryId\": \"rxmt5NJf\"," +
                        " \"title\": \"Propellant\"" +
                        "}," +
                        " \"relationships\": " +
                        "{" +
                        " \"parent\": " +
                        "{" +
                        " \"data\": null" +
                        "}," +
                        " \"organization\": " +
                        "{" +
                        " \"data\": {" +
                        " \"type\": \"Organization\"," +
                        " \"id\": \"" + strOrganizationId + "\"" +
                        "}" +
                        "}" +
                        "}" +
                        "}" +
                        "}";
                StringEntity entityCreateCategory = new StringEntity(payloadCreateCategory);
                requestCreateCategory.setEntity(entityCreateCategory);
                HttpResponse resCreateCategory = httpClientCreateCategory.execute(requestCreateCategory);

                Assert.assertEquals(201, resCreateCategory.getStatusLine().getStatusCode());

                String strResponseCategory = EntityUtils.toString(resCreateCategory.getEntity());
                System.out.println("Create Category Response is: " + strResponseCategory);
                JSONObject jsonObjCreateCategory = new JSONObject(strResponseCategory);
                JSONObject jsonObjData = jsonObjCreateCategory.getJSONObject("data");
                JSONArray jsonArrData = new JSONArray();
                jsonArrData.put(jsonObjData);

                for (int i = 0; i < jsonArrData.length(); i++) {
                    JSONObject jsonObjId = jsonArrData.getJSONObject(0);
                    strCategoryId = jsonObjId.getString("id");
                    System.out.println(strCategoryId);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @Given("The Customer views a category")
        public void viewCategory() {

              HttpClient httpClientViewCategory = HttpClients.createDefault();
              try {
                URIBuilder builderViewCategory = new URIBuilder(config.getUrl() + "/categories");
                URI uriViewCategory = builderViewCategory.build();
                //builderViewCategory.setParameter("criteria", "name =~ /^a/i OR email == \"matt.ahmad@groupbyinc.com\"");
                HttpGet requestViewCategory = new HttpGet(uriViewCategory);
                requestViewCategory.setHeader("Content-Type", "application/vnd.api+json");
                HttpResponse resViewCategory = httpClientViewCategory.execute(requestViewCategory);

                Assert.assertEquals(200, resViewCategory.getStatusLine().getStatusCode());

                String strResponseCategory = resViewCategory.toString();
                System.out.println("View Category Response is: " + strResponseCategory);

             } catch (Exception e) {
                System.out.println(e.getMessage());
             }
        }



        @Given("The Customer modifies a category")
        public void modifyCategory() {

            HttpClient httpClientModifyCategory = HttpClients.createDefault();
            try {
                URIBuilder builderModifyCategory = new URIBuilder(config.getUrl() + "/categories");
                URI uriModifyCategory = builderModifyCategory.build();
                HttpPatch requestModifyCategory = new HttpPatch(uriModifyCategory);
                requestModifyCategory.setHeader("Content-Type", "application/vnd.api+json");

                String payloadModifyCategory = "{" +
                        " \"data\": " +
                        "{" +
                        " \"id\": \"" + strOrganizationId + "\"" +
                        " \"type\": \"Category\"," +
                        " \"attributes\": " +
                        "{" +
                        " \"title\": \"Guidance System\"" +
                        "}" +
                        "}" +
                        "}";
        StringEntity entityModifyCategory = new StringEntity(payloadModifyCategory);
                requestModifyCategory.setEntity(entityModifyCategory);
        HttpResponse resModifyCategory = httpClientModifyCategory.execute(requestModifyCategory);

                Assert.assertEquals(201, resModifyCategory.getStatusLine().getStatusCode());

        String strResponseCategory = EntityUtils.toString(resModifyCategory.getEntity());
                System.out.println("Modify Category Response is: " + strResponseCategory);
        }
     catch (Exception e) {
        System.out.println(e.getMessage());
        }
        }




//      HttpClient httpClientEditEnrichUserEmail = HttpClients.createDefault();
//      try {
//        URIBuilder builderEditEnrichUserEmail = new URIBuilder(strEnrichBaseUrl + "/users");
//        URI uriEditEnrichUserEmail = builderEditEnrichUserEmail.build();
//        HttpPatch requestEditEnrichUserEmail = new HttpPatch(uriEditEnrichUserEmail);
//        requestEditEnrichUserEmail.setHeader("Content-Type", "application/vnd.api+json");
//
//        String payloadEditEnrichUserEmail = "{" +
//                " \"data\": " +
//                "{" +
//                " \"type\": \"User\"," +
//                " \"id\": \"" + strEnrichUserId + "\"," +
//                " \"attributes\": " +
//                "{" +
//                " \"email\": \"matt.ahmad@groupbyinc.com\"" +
//                "} " +
//                "} " +
//                "}";
//
//        StringEntity entityEditEnrichUserEmail = new StringEntity(payloadEditEnrichUserEmail);
//        requestEditEnrichUserEmail.setEntity(entityEditEnrichUserEmail);
//        HttpResponse resEditEnrichUserEmail = httpClientEditEnrichUserEmail.execute(requestEditEnrichUserEmail);
//
//        Assert.assertEquals(200, resEditEnrichUserEmail.getStatusLine().getStatusCode());
//      }
//      catch (Exception e)
//      {
//        System.out.println(e.getMessage());
//      }













        @Given("^The Customer deletes the category$")

        public void deleteCategory() throws Throwable {

            HttpClient httpClientDeleteCategory = HttpClients.createDefault();
            try {
                URIBuilder builderDeleteCategory = new URIBuilder(config.getUrl() + "/categories/" + strCategoryId.trim());
                URI uriDeleteCategory = builderDeleteCategory.build();
                HttpDelete requestDeleteCategory = new HttpDelete(uriDeleteCategory);
                requestDeleteCategory.setHeader("Content-Type", "application/vnd.api+json");
                HttpResponse resDeleteCategory = httpClientDeleteCategory.execute(requestDeleteCategory);

                Assert.assertEquals(204, resDeleteCategory.getStatusLine().getStatusCode());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        @Given("^The Customer deletes the organization$")

        public void deleteOrganization() throws Throwable {

            HttpClient httpClientDeleteOrganization = HttpClients.createDefault();
            try {
                URIBuilder builderDeleteOrganization = new URIBuilder(config.getUrl() + "/organizations/" + strOrganizationId.trim());
                URI uriDeleteOrganization = builderDeleteOrganization.build();
                HttpDelete requestDeleteOrganization = new HttpDelete(uriDeleteOrganization);
                requestDeleteOrganization.setHeader("Content-Type", "application/vnd.api+json");
                HttpResponse resDeleteOrganization = httpClientDeleteOrganization.execute(requestDeleteOrganization);

                Assert.assertEquals(204, resDeleteOrganization.getStatusLine().getStatusCode());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

//    @Then("Expect a record count of {int}")
//    public void assertResultRecordCount(int recordCount) {
//        assertEquals(searchResults.getRecordSize(), recordCount);
//    }
//
//    @Then("Expect Product Ids to return in order of relevancy:")
//    public void assertOrderedResults(List<String> productIds) {
//
//        List<String> expectedOrderedProductIds = searchResults.getAllMetaList()
//                .stream()
//                .map(record -> record.get("id").toString())
//                .collect(Collectors.toList());
//
//        assertEquals(expectedOrderedProductIds, productIds);
//    }

}