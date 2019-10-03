name= "Vincent Massey"
sp=name.find(" ")
fst =name[:]
lst =name[sp:]
newname =""
mx =min(len(fst), len (lst))
for i in range(mx):
    newname =newname +fst[i]+lst[i]
    print (newname)
