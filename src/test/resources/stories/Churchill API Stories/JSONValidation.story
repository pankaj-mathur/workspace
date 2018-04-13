Scenario: Verify Full JSON Resonse

Meta:
@Manual 

Given user call the Churchill Demographic Endpoint with a benefit of [subject], a metric of [metric], a geography type of [geoType], a year of [year], and a month of [month]
When the call is [outcome]
Then user expect the called JSON to match the stored JSON file

Examples:
|subject			|metric		|geoType|year	|month		|outcome	|
|UC Claimants 		|Number		|LA		|2017	|February	|Successful	|	

