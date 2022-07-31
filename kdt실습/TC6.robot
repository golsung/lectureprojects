*** Settings ***
Library           SeleniumLibrary

*** Variables ***
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력

*** Test Cases ***
Enter Student Grade
    Visit Grader Home Page
    Input Student Grade    정인상    컴퓨터공학    80    90    95

*** Keywords ***
Visit Grader Home Page
    Open Browser    ${URL}    ${BROWSER}
    Title Should Be    ${TITLE}

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
