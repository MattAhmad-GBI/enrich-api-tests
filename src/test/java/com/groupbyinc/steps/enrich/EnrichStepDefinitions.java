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
    private String strOrganizationId, strCategoryId;

    @Given("An organization is created in enrich")
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
                    " \"name\": \"Test Automation Inc 5\"" +
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

        @Given("A category is created in enrich")
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
                        " \"proprietaryId\": \"rxmt5NJ4\"," +
                        " \"title\": \"Metal\"" +
                        "}," +
                        " \"relationships\": " +
                        "{" +
                        " \"parent\": " +
                        "{" +
                        " \"data\": null" +
                        "}," +
                        " \"organization\": " +
                        "{" +
                        " \"data\": {}" +
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