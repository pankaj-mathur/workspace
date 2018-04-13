Scenario: Verify Demographic Endpoint Call Speed

Given user call the Churchill Demographic Endpoint with a benefit of [subject], a metric of [metric], a geography type of [geoType], a year of [year], and a month of [month]
When the call is [outcome]
Then I expect the response to be recieved within [seconds]



Examples:
|subject			|metric		|geoType|year	|month		|outcome 	|seconds|
|UC Claimants 		|Number		|LA		|2017	|February	|Successful	|	5	|
|UC Claimants 		|Percentage	|LA		|2017	|January	|Successful	|	5	|
|Active Enterprises |Number		|LA		|2016	|January	|Successful |	5	|

