*** Settings ***
Library     SeleniumLibrary


*** Test Cases ***
Enter Student Grade
    Open Browser    http://localhost:8081    chrome
    Title Should Be    성적 입력
