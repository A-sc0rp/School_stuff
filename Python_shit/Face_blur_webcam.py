import numpy as np
import cv2 as cv

face_cascade = cv.CascadeClassifier('C:\\Users\\Utente\\Downloads\\haarcascade_frontalface_alt.xml')
face2_cascade = cv.CascadeClassifier('C:\\Users\\Utente\\Downloads\\haarcascade_profileface.xml')
smileFace_cascade = cv.CascadeClassifier('C:\\Users\\Utente\\Downloads\\haarcascade_smile.xml')
cap = cv.VideoCapture(0)
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
    gray = cv.cvtColor(frame, cv.COLOR_BGR2BGRA)
    # Display the resulting frame
    faces = face_cascade.detectMultiScale(frame, 1.3, 5), face2_cascade.detectMultiScale(frame, 1.3, 5)
    #print("Face detected in the image:", len(faces))
    smileFace = smileFace_cascade.detectMultiScale(frame, 1.3, 5)
    print("Smile detected in the image: ", len(smileFace))
    for (x, y, w, h) in faces:
        roi = frame[y:y+h, x:x+w]
 
   # apply gaussian blur to face rectangle
        roi = cv.GaussianBlur(roi, (47, 47), 160)
 
   # add blurred face on original image to get final image
        frame[y:y+roi.shape[0], x:x+roi.shape[1]] = roi

    cv.imshow('frame', frame)
    if cv.waitKey(1) == ord('q'):
        break
 
# When everything done, release the capture
cap.release()
cv.destroyAllWindows()