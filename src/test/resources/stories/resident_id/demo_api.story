Scenario: Verifu tha twe can find the country using country code

Meta:
@issue #EE-89

Given the user try to call API to find country using country code [countryCode]
When the user search is executed successfully
Then user should find country [countryName]

Examples:
|countryCode|countryName			 |
|BR			|Brazil					 |
|IN			|India					 |
|US			|United States of America|

Scenario: Verifu tha twe can find the country using country code

Meta:
@issue #EE-89

Given the user try to call API to find country using country code [countryCode]
When the user search is executed successfully
Then user should find country [countryName]

Examples:
|countryCode|countryName			 |
|BR			|Brazil					 |
|IN			|India					 |
|US			|United States of America|



