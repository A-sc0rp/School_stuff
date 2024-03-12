import cv2 as cv
import pyautogui as ui

def movement(verse, img, text, h, w):
    while True:
    
        screen_width, screen_height =ui.size()
        wmax=screen_height-img.shape[1]
        hmax=screen_width-img.shape[0]

        if h == hmax or h == 0:
            verse = "b" + verse[1:] if verse[0] == "f" else "f" + verse[1:]
        elif w == 0 or w == wmax:
            verse = verse[0] + "up" if verse[1:] == "down" else verse[0] + "down"

        h=motion(verse, h, w)[0]
        w=motion(verse, h, w)[1]
        cv.imshow(text, img)
        cv.moveWindow(text, h, w)
        print(h, hmax, w, wmax, )

        if cv.waitKey(2) == ord('b'): 
            cv.destroyAllWindows()
            break
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

face_cascade = cv.CascadeClassifier(cv.data.haarcascades+"haarcascade_frontalface_alt2.xml")
face2_cascade = cv.CascadeClassifier(cv.data.haarcascades+"haarcascade_profileface.xml")
smileFace_cascade = cv.CascadeClassifier(cv.data.haarcascades+"haarcascade_smile.xml")
cap = cv.VideoCapture(0)
font = cv.FONT_HERSHEY_PLAIN 
t_lower = 50  # Lower Threshold 
t_upper = 150  # Upper threshold 
if not cap.isOpened():
    print("Cannot open camera")
    exit()
while True:
    # Capture frame-by-frame
    ret, frame = cap.read()
 
    # if frame is read correctly ret is True
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break
    # Our operations on the frame come here
    cv.putText(frame,  
                'Hold "q" to exit',  
                (50, 50),  
                font, 1,  
                (0, 0, 0),  
                2,  
                cv.LINE_4)
    cv.putText(frame,  
                'Hold "c" to Canny',  
                (50, 170),  
                font, 1,  
                (0, 0, 0),  
                2,  
                cv.LINE_4)
    cv.putText(frame,  
                'Hold "s" to Screenshot',  
                (50, 200),  
                font, 1,  
                (0, 0, 0),  
                2,  
                cv.LINE_8)
    
    gray = cv.cvtColor(frame, cv.COLOR_BGR2BGRA)
    # Display the resulting frame
    faces = face_cascade.detectMultiScale(frame, 1.3, 5)
    #print("Face detected in the image:", len(faces))
    for (x, y, w, h) in faces:
        roi = frame[y:y+h, x:x+w]

        cv.putText(frame,  
                'Privacy Respected',  
                (50, 150),  
                font, 1,  
                (0, 0, 0),  
                2,  
                cv.LINE_4)
 
   # apply gaussian blur to face rectangle
        roi = cv.GaussianBlur(roi, (47, 47), 30)
 
   # add blurred face on original image to get final image
        frame[y:y+roi.shape[0], x:x+roi.shape[1]] = roi

    if cv.waitKey(1) == ord('c'):
        frame = cv.Canny(frame, t_lower, t_upper) 
    if cv.waitKey(1) == ord('s'):
        while cv.waitKey(1) != ord('p'):
            cv.putText(frame,  
                'Press "p" to proceed',  
                (50, 250),  
                font, 1,
                (0, 0, 0),  
                2,  
                cv.LINE_4)
            cv.imshow("Damn, u ugly", frame)
        cv.destroyWindow("Damn, u ugly")
    if cv.waitKey(1) == ord('m'):
        while cv.waitKey(1) != ord('b'):
            movement("fdown", frame,"frame", 2, 2)
        cv.destroyWindow("frame")
    cv.imshow('frame', frame)
    if cv.waitKey(1) == ord('q'):
        break
# When everything done, release the capture
cap.release()
cv.destroyAllWindows()