#include<bits/stdc++.h>
#include<unistd.h>
#include<ctime>
#include<random>
#include<sys/wait.h>

using namespace std;

int main(){

pid_t pid;
pid=fork();
srand(time(NULL));
int num=rand()%100+1;
int inbuf[num];
int p[2];
if(pid==-1){
  cout<<"Fork non riuscita, riprovare"<<endl;
  exit(EXIT_FAILURE);
}
else if(pid==0){
  for(int i=0;i<10;i++){
    read(p[0], &inbuf, sizeof(num));
    cout<<"% s\n"<<"Numero ricevuto: "<<&inbuf<<endl;
  }
  exit(EXIT_SUCCESS);
}
else{
  for(int i=0;i<10;i++){
    write(p[1], &inbuf, sizeof(num));
    sleep(1);
  }
  wait(NULL);
}
return 0;

}
