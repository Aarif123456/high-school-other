#Abdullah Arif
#jeff roads
def poi(x1,y1,x2,y2,c1,c2):
    D=x1*y2-x2*y1
    Dy=x1*c2-x2*c1
    Dx=c1*y2-c2*y1
    x=Dx/D
    y=Dy/D
    return x,y
    
cord=input("").split(' ')
hx=int(cord[0])
hy=int(cord[1])
sx=int(cord[2])
sy=int(cord[3])
road=0
a1=(sy-hy)/(sx-hx)
b1=1
c1=sy-(a1*sx)
numr=int(input('')) #number of roads
for n in range(numr):
    line=input('').split(' ')
    if line[0]=='0':
        if int(line[0])>min([hx,sx]) and int(line[0])< max([hx,sx]):
            road+=1
    elif line[1]=='0':
        if int(line[1])>min([hy,sy]) and int(line[1])< max([hy,sy]):
            road+=1        
    else:
        a2=int(line[0])
        b2=int(line[1])
        c2=int(line[2])
        poix,poiy=poi(a1,b1,a2,b2,c1,-c2)
        if min([hx,sx])<=poix and max([hx,sx])>=poix and min([hy,sy])<=poiy and max([hy,sy])>=poiy:
            road+=1
print(road)
