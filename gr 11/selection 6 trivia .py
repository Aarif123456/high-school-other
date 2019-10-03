#Abdullah Arif ,Game  of throne trivia
# It is trivia with 5 quistion
cor= "Congratulation,You answered correctly\n"
incor="Sorry you answered incorrectly\n"
score =0

print("""Enter answer to qusition
Cases do not matter
press Enter to start""")

input() #all varible starting with ans contain answer to trivia quistion

ans1= input("Game of Thrones is based of what book series?\n")
if ans1.lower() == "song of ice and fire":
    print(cor)
    score += 1
else:
    print(incor)
       
ans2= input("What is  the name of John Snow's direwolf?\n")

if ans2.lower()== "ghost":
    print(cor)
    score += 1
else:
    print(incor)
    
ans3= input("Not counting John ,how many children does Catlyn Stark have?\n")
if ans3=="5" or  ans3.lower() == "five":
    print(cor)
    score += 1
else:
    print(incor)
    
ans4= input("Which diety does Melisendre worship?\n")
if ans4.lower() =="the lord of light" or ans4.lower() == "lord of light":
    print(cor)
    score +=1
else:
    print(incor)
    
    
ans5= input("Who was nicknamed\"King Slayer\" after killing the mad king \n")

if ans5.lower() == "jamie lanister" or ans5.lower()== "jamie":
    print(cor)
    score += 1
else:
    print(incor)
score = score/5*100

print ("You got", score,"% on the trivia " )    


input()



