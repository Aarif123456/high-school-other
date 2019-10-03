from pygame import *
from random import*
from math import*
    
screen = display.set_mode((800,600)) 
running =True
while running:                   
    for e in event.get():       
        if e.type == QUIT:
            running = False

    
    col=randint(155,255),0,0
    mx,my=mouse.get_pos()
    mb= mouse.get_pressed()
    if mb[0]==1:
        draw.circle(screen,col,(mx,my), 40,2)
        draw.line(screen,col,(mx,my-10),(mx,my-40))
        draw.line(screen,col,(mx,my+10),(mx,my+40))
        draw.line(screen,col,(mx+10,my),(mx+40,my))
        draw.line(screen,col,(mx-10,my),(mx-40,my))
    #if mb[2]==1: screen.fill(0,0,0)
        
    display.flip()  


quit()
