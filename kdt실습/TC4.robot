*** Settings ***
Library           SeleniumLibrary

*** Variables ***
${URL}            http://localhost:8081
${BROWSER}        chrome
${TITLE}          성적 입력

*** Test Cases ***
Enter Student Grade
    Visit Grader Home Page
    Input Student Grade

*** Keywords ***
Visit Grader Home Page
    Open Browser    ${URL}    ${BROWSER}
    Title Should Be    ${TITLE}

Input Student Grade
    Input Name

Input Name
    Input Text    id:name    정인상
