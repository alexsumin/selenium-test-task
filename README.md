## Test task for Wrike

### Test case scenario:

* Open url: wrike.com;
* Click "Get started for free" button near "Login" button;
* Fill in the email field with random generated value of email with mask “<random_text>+wpt@wriketask.qaa”​ (e.g. “​abcdef+wpt@wriketask.qaa”​ );
* Click on "Create my Wrike account" button + check with assertion that you are moved to the next page;
* Fill in the Q&A section at the left part of page (like random generated answers) + check with assertion that your answers are submitted;
* Click on "Resend email" + check it with assertion;
* Check that section "Follow us" at the site footer contains the "Twitter" button that leads to the correct url and has the correct icon.

(you may close all needless tooltips on your way) 

 

### Stack of technologies for implementation:

* Platform: java8
* Build: maven
* Test framework: junit4
* UI test framework: selenium 3 (without wrappers)
* Pattern: pageObject (test -> steps -> pages)

### How to use (windows)
1. Clone this project
2. Make sure the Сhrome browser is installed (versions 71-73)
3. And then you're ready to run tests

`mvn clean verify`

In other operating systems, you need to specify the path to the chrome driver and change the property in the file TestCase.java

