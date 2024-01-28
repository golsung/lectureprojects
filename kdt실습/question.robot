*** Settings ***
Suite Setup       Log To Console 	Hello
Suite Teardown   Log To Console 	See u later
Test Setup       Log To Console 	Hi
Test Teardown   Log To Console 	Good Bye
Test Template	Print Console

*** Test Cases ***
Helloinsang1  insang1
Helloinsang2  insang2

*** Keywords ***
Print Console
   [Arguments]	${msg}
   LOG TO CONSOLE  ${msg}

