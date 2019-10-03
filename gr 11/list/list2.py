#Abdullah Arif
#tournament set uper
from random import*
players=[]
pairnum=0
numplayer=int(input("how many players\n"))
for i in range (numplayer):
    player=input("Enter player name\n")
    players.append(player)
    shuffle(players)
if len(players)%2 !=0:
    players.append("Bye")
    numplayer+=1
for i in range (0,numplayer,2):
    pairnum+=1
    print ("pair",pairnum,"is",players[i],"and",players[i+1])
    
    



