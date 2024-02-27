import cv2

img=cv2.imread('img1.jpg')
img_gray=cv2.imread('img2.webp', cv2.IMREAD_GRAYSCALE)
cv2.imshow('img1.jpg', img)
cv2.imshow('img2.webp', img_gray)
while True:
    if cv2.waitKey(0) == 113: break
cv2.destroyAllWindows()

