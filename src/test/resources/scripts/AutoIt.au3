;ControlSetText("Open", "", "Edit1", "E:\Official\Automation Projects\Dinesh Project\SeleniumTwitter\src\test\resources\Photo.png")
WinWait("Open")
ControlSetText("Open", "", "Edit1", $CmdLine[1])
Sleep(2000)
ControlClick("Open", "","Button1")
;Sleep(2000)