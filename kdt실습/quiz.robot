*** Settings ***
Suite Setup       Visit Grader Home Page
Suite Teardown    Close Browser
Test Template     Should Not Accept Invalid Negative Points
Library           SeleniumLibrary

*** Variables ***
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력
${TOTAL}          6
${GRADE}          7

*** Test Cases ***
Negative Middle Exam Points
    정인상1    컴퓨터공학    -90    90    95

Negative Final Exam Points
    정인상2    기계공학    60    -90    75

Negative Hw Points
    정인상3    컴퓨터공학    85    70    -70

*** Keywords ***
Should Not Accept Invalid Negative Points
    [Arguments]    ${name}    ${major}    ${mid}    ${final}    ${hw}
    Input Student Grade    ${name}    ${major}    ${mid}    ${final}    ${hw}
    Student Should Not Be Stored

Visit Grader Home Page
    Open Browser    ${URL}    ${BROWSER}
    Set Selenium Implicit Wait    1 second
    Title Should Be    ${TITLE}

Get Number Of Students In Table
    ${count}=    Get Element Count    xpath://table[2]//tr
    [Return]    ${count}

Delete All Students In Table
    Click Button    id:btnDeleteAll

Input Student Grade
    [Arguments]    ${name}    ${major}    ${mid}    ${final}    ${hw}
    Input Name    ${name}
    Input Major    ${major}
    Input Middle Score    ${mid}
    Input Final Score    ${final}
    Input Homework Score    ${hw}
    Submit Grade

Input Name
    [Arguments]    ${name}
    Input Text    id:name    ${name}

Input Major
    [Arguments]    ${major}
    Input Text    id:major    ${major}

Input Middle Score
    [Arguments]    ${mid}
    Input Text    id: midScore    ${mid}

Input Final Score
    [Arguments]    ${final}
    Input Text    id:finalScore    ${final}

Input Homework Score
    [Arguments]    ${hw}
    Input Text    id:hwScore    ${hw}

Submit Grade
    Click Button    id:btnAddStudentGrade

Student Should Not Be Stored
    ${count}=    Get Element Count    xpath://table[2]//tr
    Should Be True    ${count}==0
