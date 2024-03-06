//risolvere l'espressione (3+2)*(5-3)*(8-3) e stampare risultato
#include<unistd.h>
#include<bits/stdc++.h>
#include<sys/wait.h>

using std::cin;
using std::cout;
using std::endl;

int main(){

pid_t f1, f2, f3;
int a, b, c, wstat;

f1=fork();
if(f1==-1){
  cout<<"ERROR"<<endl;
  exit(EXIT_FAILURE);
}
else if(f1==0){
  a=3+2;
  exit(a);
}
else {
  f2=fork();
  if(f2==-1){
    cout<<"ERRORE"<<endl;
    exit(EXIT_FAILURE);
  }
  else if(f2==0){
    b=5-3;
    exit(b);
  }
  else{
    f3=fork();
    if(f3==-1){
      cout<<"ERRORE"<<endl;
      exit(EXIT_FAILURE);
    }
    else if(f3==0){
      c=8-3;
      exit(c);
    }
  }
}

waitpid(f1, &wstat, 0);
int r1=WEXITSTATUS(wstat);
waitpid(f2, &wstat, 0);
int r2=WEXITSTATUS(wstat);
waitpid(f3, &wstat, 0);
int r3=WEXITSTATUS(wstat);

int r=r1*r2*r3;
cout<<"La risposta è: "<<r<<endl;

return 0;
}
