$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Testcase1.feature");
formatter.feature({
  "line": 1,
  "name": "Zoopla Application",
  "description": "",
  "id": "zoopla-application",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "UseCase1",
  "description": "",
  "id": "zoopla-application;usecase1",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the Zoopla application is launched for \"\u003ctestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the home page using \"\u003chomePageTitle\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the \"\u003cLocation\u003e\" in searchbox and press the search button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "validate list of properties page \"\u003cpropertiespagetitle\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "print all the price values in sorted order(descending order) on the console",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "select the fifth property on the list of properties",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "verify the property list page with logo,agentname and telephone",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "click on the agentname link to get into agents page",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify the properties listed  belong to the same mentioned \"\u003cagentname\u003e\" on the agents page.",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "zoopla-application;usecase1;",
  "rows": [
    {
      "cells": [
        "testName",
        "homePageTitle",
        "Location",
        "propertiespagetitle",
        "agentname"
      ],
      "line": 18,
      "id": "zoopla-application;usecase1;;1"
    },
    {
      "cells": [
        "test1",
        "Zoopla \u003e Search Property to Buy, Rent, House Prices, Estate Agents",
        "London",
        "Property for Sale in London - Buy Properties in London - Zoopla",
        "Panther International Properties"
      ],
      "line": 19,
      "id": "zoopla-application;usecase1;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 7426080000,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "UseCase1",
  "description": "",
  "id": "zoopla-application;usecase1;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the Zoopla application is launched for \"test1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the home page using \"Zoopla \u003e Search Property to Buy, Rent, House Prices, Estate Agents\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the \"London\" in searchbox and press the search button",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "validate list of properties page \"Property for Sale in London - Buy Properties in London - Zoopla\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "print all the price values in sorted order(descending order) on the console",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "select the fifth property on the list of properties",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "verify the property list page with logo,agentname and telephone",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "click on the agentname link to get into agents page",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify the properties listed  belong to the same mentioned \"Panther International Properties\" on the agents page.",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "test1",
      "offset": 40
    }
  ],
  "location": "Stepdefinition.the_Zoopla_application_is_launched_for(String)"
});
formatter.result({
  "duration": 70397400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Zoopla \u003e Search Property to Buy, Rent, House Prices, Estate Agents",
      "offset": 28
    }
  ],
  "location": "Stepdefinition.verify_the_home_page_using(String)"
});
formatter.result({
  "duration": 21125200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "London",
      "offset": 11
    }
  ],
  "location": "Stepdefinition.enter_the_in_searchbox_and_press_the_search_button(String)"
});
formatter.result({
  "duration": 9184529000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Property for Sale in London - Buy Properties in London - Zoopla",
      "offset": 34
    }
  ],
  "location": "Stepdefinition.validate_list_of_properties_page(String)"
});
formatter.result({
  "duration": 7428800,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.print_all_the_price_values_in_sorted_order_descending_order_on_the_console()"
});
formatter.result({
  "duration": 5248555400,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.select_the_fifth_property_on_the_list_of_properties()"
});
formatter.result({
  "duration": 4107117200,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.verify_the_property_list_page_with_logo_agentname_and_telephone()"
});
formatter.result({
  "duration": 28938400,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.click_on_the_agentname_link_to_get_into_agents_page()"
});
formatter.result({
  "duration": 6415010600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Panther International Properties",
      "offset": 60
    }
  ],
  "location": "Stepdefinition.verify_the_properties_listed_belong_to_the_same_mentioned_on_the_agents_page(String)"
});
formatter.result({
  "duration": 5039551700,
  "status": "passed"
});
formatter.after({
  "duration": 148520800,
  "status": "passed"
});
});