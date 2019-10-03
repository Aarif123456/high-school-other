#Abdullah Arif
items=[]
costs=[]
numit=int(input ("how many items you got fool"))
for i in range (numit):
    item=input("Enter items\n")
    cost=int(input("Enter costs\n"))
    items.append(item)
    costs.append(cost)
total=sum(costs)
for i in range (len(items)):
    percent =costs[i]*100//total
    print(items[i],"take",percent,"% of your money")
    
