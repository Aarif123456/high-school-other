#Abdullah Arif
nums=[]
counts=[]
biggest=0
prevcount=0
while True:
    num=int(input("Enter number \n"))
    if num ==-1:
        break
    nums.append(num)
for i in range (min(nums),max(nums)):
    count=nums.count(i)
    if count>prevcount:
        prevcount=count
        biggest=i
print("The mode is",biggest)
