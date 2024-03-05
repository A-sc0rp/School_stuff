import cv2 as cv
import pyautogui as ui
from multiprocessing import Process, freeze_support

def movement(verse, img, text, h, w):
    while True:
    
        screen_width, screen_height =ui.size()
        wmax=screen_height-img.shape[1]+1
        hmax=screen_width-img.shape[0]+1

        if h == hmax or h == -1:
            verse = "b" + verse[1:] if verse[0] == "f" else "f" + verse[1:]
        elif w == -1 or w == wmax:
            verse = verse[0] + "up" if verse[1:] == "down" else verse[0] + "down"

        h=motion(verse, h, w)[0]
        w=motion(verse, h, w)[1]
        cv.imshow(text, img)
        cv.moveWindow(text, h, w)
        print(h, hmax, w, wmax, )

        if cv.waitKey(2):
            cv.destroyAllWindows()


def motion(verse, h, w):

    if verse == "fdown":
        h += 2
        w += 2
    elif verse == "fup":
        h += 2
        w -= 2
    elif verse == "bdown":
        h -= 2
        w += 2
    elif verse == "bup":
        h -= 2
        w -= 2
    else:
        print("Error, invalid argument for motion() function")

    return [h, w]

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

h=1
w=1
verse="fdown"

Pros=[]
movement(verse, img, text, h, w)
while True:
    
    if cv.waitKey(0)== 110:
        p = Process(target=movement, args=(verse, img, text, h, w))
        Pros.append(p)
        p.start()

    if cv.waitKey(0)==113:
        for t in Pros:
            t.join()
            cv.destroyAllWindows()
            break

    if __name__ == '__main__':
        freeze_support()

