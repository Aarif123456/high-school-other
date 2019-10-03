#Abdullah Arif
#frank roads

maps={'0': {'1':2, '2':15, '3':22},'1' :{'2':10,'3':20}}
start='0'
end=2
lim=10
distance=[]
for x in range(10):
    distance.append([])
    for y in range(10):
        distance[x].append([])
trav=0

        
    
    
    
def search(maps,reached,find,lim):
    if find !=reached and lim >=0:
        for reach in maps[reached]:
            newlim=lim-maps[reached][reach]
            search(maps,reach,find,newlim)
        return lim
    else:return -1
            
    
print(search(maps,start,end,lim))
