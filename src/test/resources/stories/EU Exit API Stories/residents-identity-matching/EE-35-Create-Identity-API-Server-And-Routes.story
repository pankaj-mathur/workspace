
Scenario: Response when all parameters provided


When user hit the CIS endpoint with a GET request using the parameters, [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
Then the API responds with a 200 response
And the API responds with a body

Examples:
| ninoQ 	 | surnameQ 	| dateOfBirthQ | firstnameQ | corrIdH |
| AA123456A | 	Adamson 	| 01-Jan-1900    | 	Adam  	|   1     |
| 200		 | 	McTestface  | 10-Apr-2018    | 	Testy  	|   -    |

