#Abdullah
line=input('Writeline ') 
while line.count(" ")>0:
    slicer=line.find(" ")
    print(line[:slicer])
    line =line[slicer+1:]
print (line)
