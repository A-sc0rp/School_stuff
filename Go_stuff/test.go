package main

import "fmt"

func Hello(name string)string{
	message:=fmt.Sprintf("Hi, %v. Welcome!", name)
	return message
}

func main(){
  var name string 
  fmt.Scan(&name)
  fmt.Printf(Hello(name))
}
