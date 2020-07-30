$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GETAPI.feature");
formatter.feature({
  "line": 1,
  "name": "Validating GetAPI for IG",
  "description": "",
  "id": "validating-getapi-for-ig",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify getapi is working as expected",
  "description": "",
  "id": "validating-getapi-for-ig;verify-getapi-is-working-as-expected",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@getapi"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "We are at demo site",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user calls APItest with GET http request",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the API call got success with status code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "\"status\" in response body is 200",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "\"message\" in response body is \"data retrieved successful\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "\"id\" in response list is \"101209986\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.we_are_at_demo_site()"
});
formatter.result({
  "duration": 934294100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_calls_apitest_with_get_http_request()"
});
formatter.result({
  "duration": 1467406100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.the_api_call_got_success_with_status_code()"
});
formatter.result({
  "duration": 31067800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "status",
      "offset": 1
    }
  ],
  "location": "StepDefinition.something_in_response_body_is_200(String)"
});
formatter.result({
  "duration": 576093300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "message",
      "offset": 1
    },
    {
      "val": "data retrieved successful",
      "offset": 31
    }
  ],
  "location": "StepDefinition.something_in_response_body_is_something(String,String)"
});
formatter.result({
  "duration": 17165300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "id",
      "offset": 1
    },
    {
      "val": "101209986",
      "offset": 26
    }
  ],
  "location": "StepDefinition.something_in_response_list_is_something(String,String)"
});
formatter.result({
  "duration": 15977000,
  "status": "passed"
});
});