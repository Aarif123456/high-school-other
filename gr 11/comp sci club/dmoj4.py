#Abdullah Arif
#frank roads
def search(maps,reached,find,lim):
    if find !=reached and lim >=0:
        for reach in maps[reached]:
            newlim=lim-maps[reached][reach]            
            print(newlim,lim,reach,maps[reached][reach])
            search(maps,reach,find,newlim)
            lim=newlim
        return lim
    elif find ==reached and lim >=0:
        print(lim)
        return lim
    else: return -1

            
            
info=input('').split(' ')
for i in range(len(info)):info[i]=int(info[i])
t=info[0]#km travel
n=info[1]+1#building
m=info[2]#roads
g=info[3]#food basic
dest=[]#destination
maps={}
visit=0
for i in range(n):maps[str(i)]={}
for i in range(g):
    dest.append(input(''))
for i in range(m):
    dist=input('').split(' ')
    maps[dist[0]][dist[1]]=int(dist[2])
for i in range(len(dest)):
    print( search(maps,'0',dest[i],t))#>=0#:visit+=1
print(visit)
