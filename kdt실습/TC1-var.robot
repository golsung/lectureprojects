*** Settings ***
Library     SeleniumLibrary


*** Variables ***
${URL}          http://localhost:8081
${BROWSER}      chrome
${TITLE}        성적 입력


*** Test Cases ***
Enter Student Grade
    Open Browser    ${URL}    ${BROWSER}
    Title Should Be    ${TITLE}
