*** Settings ***
Library     SeleniumLibrary


*** Variables ***
${URL}          http://localhost:8081
${BROWSER}      chrome
${TITLE}        성적 입력
${TOTAL}        6
${GRADE}        7


*** Test Cases ***
Enter Student Grade
    Visit Grader Home Page
    Input Student Grade    정인상    컴퓨터공학    80    90    95
    Total Score Should Be    88.0
    Student Grade Should Be    B
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
    RETURN    ${count}

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
