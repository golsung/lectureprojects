** Settings ***
Suite Setup       Visit Grader Home Page
Suite Teardown    Run Keywords    Delete All Students In Table    Close Browser
Test Template     Should get credits according to their points
Library           SeleniumLibrary

*** Variables ***
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력
${TOTAL}          6
${GRADE}          7
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력
${TOTAL}          6
${GRADE}          7

*** Test Cases ***
A Grade		정인상1    컴퓨터공학    90    90    95    91.5    A
B Grade		정인상2    기계공학    85    85    80    83.5    B
C Grade		정인상3    컴퓨터공학    78    72    76    75.3    C
D Grade		정인상4    전자공학    66    67    60    64.55    D
F Grade		정인상5    컴퓨터공학    40    25    13    26.65    F

*** Keywords ***
Should get credits according to their points
    [Arguments]    ${name}    ${major}    ${mid}    ${final}    ${hw}    ${tot}    ${gr}
    Input Student Grade    ${name}    ${major}    ${mid}    ${final}    ${hw}
    Total Score Should Be    ${tot}
    Student Grade Should Be    ${gr}


Visit Grader Home Page
    Open Browser    ${URL}    ${BROWSER}
    Set Selenium Implicit Wait    1 second
    Title Should Be    ${TITLE}

Total Score Should Be
    [Arguments]    ${tot}
    ${rows}=    Get Number Of Students In Table
    Table Cell Should Contain    xpath://table[2]    ${rows}    ${TOTAL}    ${tot}

Student Grade Should Be
    [Arguments]    ${gr}
    ${rows}=    Get Number Of Students In Table
    Table Cell Should Contain    xpath://table[2]    ${rows}    ${GRADE}    ${gr}

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


