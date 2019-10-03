#Abdullah Arif
def fill(x,y,xlim,ylim,tar,rep):
    global tmap
    if tmap[x][y]==tar:
        tmap[x][y]=rep
        if x+1<xlim:
            fill(x+1,y,xlim,ylim,tar,rep)
        if y+1<ylim:
            fill(x,y+1,xlim,ylim,tar,rep)
        if x>0:
            fill(x-1,y,xlim,ylim,tar,rep)
        if y>0:
            fill(x,y-1,xlim,ylim,tar,rep)
room=0
size=input("").split(' ')
row=int(size[0])
col=int(size[1])
tmap=[]
for r in range(row):
    tmap.append(list(input("")))
for r in range(row):
    for c in range(col):
       if tmap[r][c]=='.':
           room+=1
           fill(r,c,row,col,'.','X')
print(room)
           
