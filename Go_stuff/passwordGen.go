package main
import(
  "fmt"
  "math/rand"
  "time"
)

func pswdGen(cmplxt int){
  
  rand.Seed(time.Now().UnixNano())
  charset:="1234567890ì!£$%&/()=??^qwertyuiopè+ùasdfghjklòàç°zxcvbnm;:_,.-*§QWERTYUIOPASDFGHJKLZXCVBNM<>"
  pswd := make([]string,0)
  if(cmplxt!=0){
   pswd= append(pswd, string(charset[rand.Intn(len(charset))]))
    pswdGen(cmplxt-1)
  } 
  fmt.Print(pswd)
  
}

func main(){

var c int
fmt.Println("Length of pass?")
fmt.Scan(&c)

pswdGen(c)

}
