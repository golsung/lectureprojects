*** Settings ***
Library     Collections


*** Variables ***
@{USER}             insang1    insang2
${NAME}             insang2
&{STUDENT INFO}     name=insang1    university=hansung


*** Test Cases ***
Test Case One
    Should Not Be Equal As Strings    ${USER}[0]    ${USER}[1]
    Should Be Equal As Strings    ${USER}[-1]    ${NAME}
    Log To Console    ${STUDENT INFO}[name]

Test Case Two
    ${scalar var1}    Set Variable    insang1
    ${scalar var2}    Create List    ${scalar var1}    insang2
    @{list var}    Create List    insang2    insang3
    ${dic var}    Create Dictionary    name=insang4    univ=hansung
    LOG TO CONSOLE    ${scalar var2}[-2]
    LOG TO CONSOLE    ${list var}[-1]
    LOG TO CONSOLE    ${dic var}[name]
