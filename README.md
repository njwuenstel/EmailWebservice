### Team Members:
- Lanny Wong
- Nathan Wuenstel
- Brandon Ciancio

### Project Goal: 
Create a web-service that sends an email to one or many users. The email recipients and email contents are based on parameters. The parameters that we would require are: a collection of emails, a subjectLine, and messageContent.
				   
### Knownbugs / Limitations
	* If the subject line exceeds X than it will be truncated.
	* If the body + recipient(s) exceede 1800 characters than the url length cap will be reached and the email will not be sent.
	
### Rest url + paths
* BASE URL: http://tomcat-mademailservice.rhcloud.com/NewEmailWebservice_war
* /rest/sendEmail/test
	* This returns a string "Hey it Worked"
* /rest/sendEmail/{sbj}/{msg}/{recipient}"
	* sbj / msg / recipient = normal string. 
* /rest/sendEmail/personalize/{sbj}/{msg}/{"recipients":[{"email":"A_EMAIL","name":"A_NAME"},{"email":"A_EMAIL","name":"A_NAME"}]}
	* sbj / msg = normal string
	* recipients = a jsonString follow the template.
	
### How to use our Email Webservice:
- Two different URL path options 
	- one takes an arrary of recipients' address in string form
	- one takes an array of reciptient objects
