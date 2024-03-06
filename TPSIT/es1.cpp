//eseguire l'espressione 5*(3+2)-[(2*3)*(5-1)] e stampare risultato
//
#include<iostream>
#include<unistd.h>
#include<sys/wait.h>

using std::cin;
using std::cout;
using std::endl;

int main(){
pid_t f1, f2, f21, f22;
int a, b1, b2, wstat;

f1=fork();
if(f1==-1){
  cout<<"ERRORE"<<endl;
  exit(EXIT_FAILURE);
}
else if (f1==0){
    a=5*(3+2);
    exit(a);
}
else{
    f2=fork();
    if(f2==-1){
      cout<<"ERRORE"<<endl;
      exit(EXIT_FAILURE);
    }
    else if(f2==0){
      f21=fork();
      if(f21==-1){
        cout<<"ERRORE"<<endl;
        exit(EXIT_FAILURE);
      }
      else if(f21==0){
        b1=2*3;
        exit(b1);
      }
      else{
        f22=fork();
        if(f22==-1){
          cout<<"ERRORE"<<endl;
          exit(EXIT_FAILURE);
        }
        else if(f22==0){
          b2=5-1;
          exit(b2);
        }
      }
      waitpid(f21, &wstat, 0);
      int r1=WEXITSTATUS(wstat);
      waitpid(f22, &wstat, 0);
      int r2=WEXITSTATUS(wstat);

      int r=r1*r2;
      exit(r);
    }
}

waitpid(f1, &wstat, 0);
int r1=WEXITSTATUS(wstat);
waitpid(f2, &wstat, 0);
int r2=WEXITSTATUS(wstat);

int r=r1-r2;
cout<<"La risposta è: "<<r<<endl;
return 0;
}
