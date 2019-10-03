#Abdullah Arif
#List Assignment 3
from random import*
names=[]
numpeople=0
while True:
    name=input("Enter your name(Enter Santa to exit)")
    if name.title()== "Santa":
        break
    names.append(name)
    numpeople+=1
shuffle(names)
for i in range(numpeople):
    name=names[i]
    if numpeople==i+1:
        buyFor=names[0]
    else:
        buyFor=names[i+1]
    outFile = open(name+ ".txt","w")
    outFile.write("You are the Secret Santa of "+buyFor)
    outFile.close()
