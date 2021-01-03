$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Testcase1.feature");
formatter.feature({
  "line": 1,
  "name": "Redfin Application",
  "description": "",
  "id": "redfin-application",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "UseCase1",
  "description": "",
  "id": "redfin-application;usecase1",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the redfin application is launched for \"\u003ctestName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the home page using \"\u003chomePageTitle\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the \"\u003ccityName\u003e\" in searchbox and press the enter button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "validate pop up appears",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "On the pop up select the entry \"\u003cSelectionFromPopUp\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the city Real Estate page using \"\u003cestatePageHeader\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "assert the Search box on the top left side has \"\u003ccityName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Select the min price as \"\u003cMinPriceIndex\u003e\" and max price as \"\u003cMaxPriceIndex\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify all the homes listed are from \"\u003csearchResult\u003e\", if no homes listed throw an errorMessage",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "redfin-application;usecase1;",
  "rows": [
    {
      "cells": [
        "testName",
        "homePageTitle",
        "cityName",
        "SelectionFromPopUp",
        "estatePageHeader",
        "MinPriceIndex",
        "MaxPriceIndex",
        "searchResult"
      ],
      "line": 17,
      "id": "redfin-application;usecase1;;1"
    },
    {
      "cells": [
        "test1",
        "Real Estate, Homes for Sale, MLS Listings, Agents",
        "Sunnyvale",
        "https://www.redfin.com/city/19457/CA/Sunnyvale",
        "Sunnyvale Homes for Sale",
        "25",
        "3",
        "/CA/Sunnyvale/"
      ],
      "line": 18,
      "id": "redfin-application;usecase1;;2"
    },
    {
      "cells": [
        "test2",
        "Real Estate, Homes for Sale, MLS Listings, Agents",
        "Sunnyvale",
        "https://www.redfin.com/neighborhood/338644/TX/Dallas/Sunnyvale",
        "Sunnyvale Homes for Sale",
        "21",
        "4",
        "/TX/Dallas"
      ],
      "line": 19,
      "id": "redfin-application;usecase1;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 18356795900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "UseCase1",
  "description": "",
  "id": "redfin-application;usecase1;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the redfin application is launched for \"test1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the home page using \"Real Estate, Homes for Sale, MLS Listings, Agents\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the \"Sunnyvale\" in searchbox and press the enter button",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "validate pop up appears",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "On the pop up select the entry \"https://www.redfin.com/city/19457/CA/Sunnyvale\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the city Real Estate page using \"Sunnyvale Homes for Sale\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "assert the Search box on the top left side has \"Sunnyvale\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Select the min price as \"25\" and max price as \"3\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify all the homes listed are from \"/CA/Sunnyvale/\", if no homes listed throw an errorMessage",
  "matchedColumns": [
    7
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
  "location": "Stepdefinition.the_redfin_application_is_launched_for(String)"
});
formatter.result({
  "duration": 74495700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Real Estate, Homes for Sale, MLS Listings, Agents",
      "offset": 28
    }
  ],
  "location": "Stepdefinition.verify_the_home_page_using(String)"
});
formatter.result({
  "duration": 23683900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale",
      "offset": 11
    }
  ],
  "location": "Stepdefinition.enter_the_in_searchbox_and_press_the_enter_button(String)"
});
formatter.result({
  "duration": 145429300,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.validate_pop_up_appears()"
});
formatter.result({
  "duration": 151046700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.redfin.com/city/19457/CA/Sunnyvale",
      "offset": 32
    }
  ],
  "location": "Stepdefinition.on_the_pop_up_select_the_entry(String)"
});
formatter.result({
  "duration": 2298627200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale Homes for Sale",
      "offset": 40
    }
  ],
  "location": "Stepdefinition.verify_the_city_Real_Estate_page_using(String)"
});
formatter.result({
  "duration": 28898700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale",
      "offset": 48
    }
  ],
  "location": "Stepdefinition.assert_the_Search_box_on_the_top_left_side_has(String)"
});
formatter.result({
  "duration": 24266500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "25",
      "offset": 25
    },
    {
      "val": "3",
      "offset": 47
    }
  ],
  "location": "Stepdefinition.select_the_min_price_as_and_max_price_as(String,String)"
});
formatter.result({
  "duration": 16196072800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/CA/Sunnyvale/",
      "offset": 38
    }
  ],
  "location": "Stepdefinition.verify_all_the_homes_listed_are_from_if_no_homes_listed_throw_an_errorMessage(String)"
});
formatter.result({
  "duration": 30652734300,
  "status": "passed"
});
formatter.after({
  "duration": 234997300,
  "status": "passed"
});
formatter.before({
  "duration": 6886429900,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "UseCase1",
  "description": "",
  "id": "redfin-application;usecase1;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "the redfin application is launched for \"test2\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "verify the home page using \"Real Estate, Homes for Sale, MLS Listings, Agents\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "enter the \"Sunnyvale\" in searchbox and press the enter button",
  "matchedColumns": [
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "validate pop up appears",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "On the pop up select the entry \"https://www.redfin.com/neighborhood/338644/TX/Dallas/Sunnyvale\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "verify the city Real Estate page using \"Sunnyvale Homes for Sale\"",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "assert the Search box on the top left side has \"Sunnyvale\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Select the min price as \"21\" and max price as \"4\"",
  "matchedColumns": [
    5,
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Verify all the homes listed are from \"/TX/Dallas\", if no homes listed throw an errorMessage",
  "matchedColumns": [
    7
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "test2",
      "offset": 40
    }
  ],
  "location": "Stepdefinition.the_redfin_application_is_launched_for(String)"
});
formatter.result({
  "duration": 150400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Real Estate, Homes for Sale, MLS Listings, Agents",
      "offset": 28
    }
  ],
  "location": "Stepdefinition.verify_the_home_page_using(String)"
});
formatter.result({
  "duration": 4500200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale",
      "offset": 11
    }
  ],
  "location": "Stepdefinition.enter_the_in_searchbox_and_press_the_enter_button(String)"
});
formatter.result({
  "duration": 142339300,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.validate_pop_up_appears()"
});
formatter.result({
  "duration": 137675900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.redfin.com/neighborhood/338644/TX/Dallas/Sunnyvale",
      "offset": 32
    }
  ],
  "location": "Stepdefinition.on_the_pop_up_select_the_entry(String)"
});
formatter.result({
  "duration": 1400914600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale Homes for Sale",
      "offset": 40
    }
  ],
  "location": "Stepdefinition.verify_the_city_Real_Estate_page_using(String)"
});
formatter.result({
  "duration": 57007400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sunnyvale",
      "offset": 48
    }
  ],
  "location": "Stepdefinition.assert_the_Search_box_on_the_top_left_side_has(String)"
});
formatter.result({
  "duration": 19070000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "21",
      "offset": 25
    },
    {
      "val": "4",
      "offset": 47
    }
  ],
  "location": "Stepdefinition.select_the_min_price_as_and_max_price_as(String,String)"
});
formatter.result({
  "duration": 16195579300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "/TX/Dallas",
      "offset": 38
    }
  ],
  "location": "Stepdefinition.verify_all_the_homes_listed_are_from_if_no_homes_listed_throw_an_errorMessage(String)"
});
formatter.result({
  "duration": 30592764500,
  "status": "passed"
});
formatter.after({
  "duration": 74019200,
  "status": "passed"
});
});