*** Settings ***
Library           SeleniumLibrary

*** Variables ***
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력
${TOTAL}          6
${GRADE}          7

*** Test Cases ***
Students with more than 90 points should get A
    Visit Grader Home Page
    Input Student Grade    정인상1    컴퓨터공학    90    90    95
    Total Score Should Be    91.5
    Student Grade Should Be    A
    Delete All Students In Table
    Close Browser

Students with more than 80 points should get B
    Visit Grader Home Page
    Input Student Grade    정인상2    기계공학    85    85    80
    Total Score Should Be    83.5
    Student Grade Should Be    B
    Delete All Students In Table
    Close Browser

Students with more than 70 points should get C
    Visit Grader Home Page
    Input Student Grade    정인상3    컴퓨터공학    78    72    76
    Total Score Should Be    75.3
    Student Grade Should Be    C
    Delete All Students In Table
    Close Browser

Students with more than 60 points should get D
    Visit Grader Home Page
    Input Student Grade    정인상4    전자공학    66    67    60
    Total Score Should Be    64.55
    Student Grade Should Be    D
    Delete All Students In Table
    Close Browser

Students with less than 60 points should get F
    Visit Grader Home Page
    Input Student Grade    정인상5    컴퓨터공학    40    25    13
    Total Score Should Be    26.6
    Student Grade Should Be    F
    Delete All Students In Table
    Close Browser

*** Keywords ***
Visit Grader Home Page
    Open Browser    ${URL}    ${BROWSER}
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