package main

import "fmt"

func is_prime(n int) bool{
  for i:=1;i<n+1;i++{
    if(n%i==0) {return false}
  
  }
  return true

}

func main(){
  var num int
  fmt.Scan(&num)
  fmt.Print(is_prime(num))
}
