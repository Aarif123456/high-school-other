items=["Miso Soup","House Salad","Tuna Tataki Salad","Agedashi Tofu","Lemon Grass Beef Skewers",
"Chicken Lettuce Wrap","Samurai Steak 14oz","Hotate - Yaki","Teriyaki Striploin 8oz", 
"The Emperor’s Choice","Wasabi Chicken","Fresh Grilled Shitake Mushrooms", 
"Fresh Grilled Asparagus","Teppanyaki Heaven","Steamed Rice","Grilled Tofu"]
costs=[3.5,4.0,14.95,6.0,7.5,9.95,29.0,12.0,32.0,49.0,18.0,6.95 ,4.95 ,89.00,2.50,4.95]
money=int(input("How much money ya got fool"))
while money>2.5:
    num=0
    for i in range(len(items)):
        if money >= costs[i]:
            num+=1
            print(str(num),items[i],"cost",costs[i])
    order=int(input("order mate 0 to exit"))
    if order == 0:
        break
    order-=1
    money-=costs[order]
    print("you just ordered",items[order],"and it cost you",costs[order])

print("your total is $",money)
