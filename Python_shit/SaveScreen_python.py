import cv2 as cv
import tkinter as tk

def motion(verse, h, w):
    if verse == "fdown":
         h+=1
         w-=1
         return [h, w]
    elif verse == "fup":
         h+=1
         w+=1
         return [h, w]
    elif verse == "bdown":
         h-=1
         w-=1
         return [h, w]
    elif verse == "bup":
         h-=1
         w+=1
         return [h, w]
    else: print("Error, invalid argument for motion() function")
    
root = tk.Tk()
screen_width = root.winfo_screenwidth()
screen_height = root.winfo_screenheight()

path=input("Insert here your path to the image you want to display ")
while True:
    flag_in=input("Choose the color scale of the image: grayscale or BGR scale? ")
    if flag_in == "grayscale" or flag_in == "gray":
        flag=cv.IMREAD_GRAYSCALE
        break
    elif flag_in == "BGR" or flag_in == "BGR scale" or flag_in == "bgr":
        flag=cv.IMREAD_COLOR
        break
    else: print("Wrong input, retry")
text=input("Would you like to insert something on top of the window? (hit the space if nothing) ")
img = cv.imread(path, flag)
assert img is not None, "File could not be read, check with os.path.exists()"

h=0
w=0
go="fdown"
hmax=screen_height
wmax=screen_width

while True:
    cv.imshow(text, img)
    cv.moveWindow(text, (motion(go, h, w)[0], motion(go, h, w)[1]))

    if h==hmax:  
        if go=="fdown":
            go="bdown"
        else: go="bup"
    elif h==0:
        if go=="bup":
            go="fup"
        else: go="fdown"
    elif w==0:
        if go=="fup":
            go="fdown"
        else: go="bdown"
    elif w==wmax:
        if go=="fdown":
            go="fup"
        else: go="bup"



    if cv.waitKey(0) == 113:
        cv.destroyAllWindows()
        break