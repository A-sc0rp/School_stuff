import cv2 as cv

def goBackDown(h, w):
    h-=1
    w-=1
    return h, w
def goBackUp(h, w):
    h-=1
    w+=1
    return h, w
def goForwardUp(h, w):
    h+=1
    w+=1
    return h, w
def goForwardDown(h, w):
    h+=1
    w-=1
    return h, w

img = cv.imread('img3.webp', cv.IMREAD_GRAYSCALE)
assert img is not None, "file could not be read, check with os.path.exists()"
h=0
w=0

while True:
    cv.imshow("You're doomed", img)
   # h=700
    #w=320
    go=goForwardDown(h, w)
    cv.moveWindow("You're doomed",go )

    if h==700:  
        if go==goForwardUp():
            go=goBackUp(h, w);
    elif w==0:
        if go==goForwardDown():
            go=goForwardUp(h, w)
        else: go=goBackUp(h, w)



    if cv.waitKey(0) == 113:
        cv.destroyAllWindows()
        break