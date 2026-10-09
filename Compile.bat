@echo off

set message="----"

set msg=Main.java
:while

    if %message% leq 1 (
        echo Compiled: %msg%
        java src/Main.java
        exit
        goto :break
    )

:break
