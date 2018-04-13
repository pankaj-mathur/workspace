Scenario: Verify Demographic Endpoint Values

Given user call the Churchill Demographic Endpoint with a benefit of [subject], a metric of [metric], a geography type of [geoType], a year of [year], and a month of [month]
When the call is [outcome]
Then user expect the total for [geoArea] to be [value]

Examples:
|subject			|metric		|geoType|year	|month		|outcome	|geoArea	|value|
|UC Claimants 		|Number		|LA		|2017	|February	|Successful	|Doncaster	|2472|
|UC Claimants 		|Percentage	|LA		|2017	|January	|Successful	|Thanet		|1.3|
|Active Enterprises |Number		|LA		|2016	|January	|Successful	|Doncaster	|10895|


Scenario: Verify Demographic Endpoint Headers

Given user call the Churchill Demographic Endpoint with a benefit of [subject], a metric of [metric], a geography type of [geoType], a year of [year], and a month of [month]
When the call is [outcome]
Then user expect the header attribute [attribute] to have a value of [value]

Examples:
|subject			|metric		|geoType|year	|month		|outcome	|attribute	| value		   |
|UC Claimants 		|Number		|LA		|2017	|February	|Successful	|Content-Type| application/json; charset=utf-8 | 
|UC Claimants 		|Percentage	|LA		|2017	|January	|Successful	|server		| nginx/1.10.1 |
|Active Enterprises |Number		|LA		|2016	|January	|Successful	|server		| nginx/1.10.0 |


