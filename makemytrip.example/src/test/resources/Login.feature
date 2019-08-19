Feature: To test Login with Myntra

Scenario Outline: To make the login and do assertion

 Given When i am on Myntra <URL> page
 Then i should enter my valid credentials <UN> and <Pass>
 Then i should be able to login
 
 Examples:
 
 |URL|UN|Pass|
 |"https://www.myntra.com/"|"InterviewTCTS1@gmail.com"|"Str@ongPassw0rd!"|
 |"https://www.myntra.com/"|"InterviewTCTS1@gmail.com"|"Str@ongPassward!"|
 