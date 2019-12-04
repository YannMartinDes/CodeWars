for col in range(40):
   for ligne in range(40):
      if col%2 == 0 :
         if ligne%2 == 0 :
            print("O",end="")
         else : 
            print("X",end="")
      else : 
         if ligne % 2 ==0 :
            print("X",end="")
         else : 
            print("O",end="")
   print()
  
############# Smarter solution ######
for loop in range(20):
   for loop in range(20):
      print("OX", end = "")
   print()
   for loop in range(20):
      print("XO", end = "")
   print()
