
import easygui
import sys
#easygui.msgbox("hello world")

#带有快捷键的
#r=easygui.buttonbox(msg='This is msg', title='this is title ', choices=('Button[1]', 'Button[2]', 'Button[3]'), image=None, root=None, default_choice=None, cancel_choice=None)
#print('click: ',r);

while 1:
    easygui.msgbox("Hello, world!")

    msg ="What is your favorite flavor?"
    title = "Ice Cream Survey"
    choices = ["Vanilla", "Chocolate", "Strawberry", "Rocky Road"]
    choice = easygui.choicebox(msg, title, choices)

    # note that we convert choice to string, in case
    # the user cancelled the choice, and we got None.
    easygui.msgbox("You chose: " + str(choice), "Survey Result")

    msg = "Do you want to continue?"
    title = "Please Confirm"
    if easygui.ccbox(msg, title):     # show a Continue/Cancel dialog
        pass  # user chose Continue
    else:
        sys.exit(0)           # user chose Cancel