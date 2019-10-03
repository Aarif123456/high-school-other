#Abdullah Arif 
from random import*
names=[]
name=""
while name!="done":
    name=input("Enter name:done to exit\n")
    names.append(name)
shuffle(names)
for i in range (len(names)):
    if i == len(names)-1:
       print(names[i],"has to buy a gift for",names[0])
    else:
        print(names[i],"has to buy a gift for",names[i+1])
