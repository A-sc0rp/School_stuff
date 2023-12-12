def remove(string):
    return string.replace(':', '')

while True:
    str:sc = input("Quale programma desideri di vedere? (inserire un numero che corrisponde al numero del problema sul foglio), oppure per uscire premere 0")
    if sc==0:
        print("Esco, buona giornata")
        break
    if sc == 1:
        auguri=['Buon Natale '+name+' da prof. Sergi!, e ricordati di mettere lo string builder!!', 'Auguri di Buon Natale '+name+' da mark Zuckerberg, e ricordati che io posso trovare la tua location dal tuo profilo Facebook guardando le tue foto;)', 'Hello, '+name+', im Gabe Newell, thank you for playing my programm, i wanted to wish you a Merry Christmas and a Happy new year from all VALVe staff.', 'Buon natale, '+name+' dalla professoressa Pini, e ricordati: NO X NO LIMITE']
        name=input("Come ti chiami?")
        print(auguri[random(0, len(auguri))])
    elif sc == 2:
        lista=[1, 2, 3, 4, 56, 7, 8, 54, 23, 78]
        print(lista)
        sum==0
        for i in range(len(lista)):
            sum=sum+lista[i]
        print("La somma di tutti gli elementi in lista è "+sum)
    elif sc==3:
        lista=[34, 45, 23]
        print(lista)
        max==0
        for i in range(len(lista)):
            if lista[i] >=max:
                max==lista[i]
            print("il massimo di questi 3 numeri è il "+max)
    elif sc==4:
        str:st="I topi non avevano nipoti"
        st=remove(st)
        for i in range(len(st)/2):
            if st.at(i)!=st.at(len(st)-i):
                print("La stringa non è palindroma")
                break
        print("La stringa è palindroma")
    elif sc==5:
        num=input("Scrivi un numero intero")
        if num%2==0:
            print("Il numero è pari")
        else: print("Il numero è dispari")
    elif sc==6:
        num=input("Inserisci un numero")
        if num>1:
            for i in range(2,num):
                if (num%i)==0:
                    print(num, " non è un numero primo")
                    break
                else: print(num, "é un numero primo")
        else: print(num, "non è un numero primo")
    elif sc==7:
        str:n="345"
        sum==0
        for i in range(len(n)):
            sum=sum+int(n.at[i])
        print("La somma di tutte le cifre di in numero è "+sum)
    elif sc==8:
        strin=input("Scrivi una frase qui")
        for i in range(len(strin)):

