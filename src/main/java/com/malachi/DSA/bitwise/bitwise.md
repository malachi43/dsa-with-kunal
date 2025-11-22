#### BITWISE
###### NOTE: In bitwise operation we work with binary (0 or 1).

- If you AND any number (in binary form) with 1 you get back the number 
---
EXAMPLE 
-     ( 1 0 0 1 1 ) AND ( 1 1 1 1 1 ) = ( 1 0 0 1 1 ) - THE ORIGINAL NUMBER

---
If you left shift a number you get double of the number

---
EXAMPLE
 -     ( 1 1 1 ) << 1 = ( 1 1 1 0 )
 -     1 1 1 = 7
 -     1 1 1 0 = 14 (which is the double of 7)
 -     General formula a << b = a * 2 ^ b

---
If you right shift a number you get the integer division of the number divided by 2

---
-       1 1 1 = 7
-     ( 1 1 1 ) >> 1 = ( 1 1 )  
-      1 1 = 2 (which is the integer division when you divide 7 / 2 )
-     General formula a >> b = a / (2 ^ b)

---

If you XOR any number with 0 you get back the number

-     A ^ 0 = A
-     0 ^ 0 = 0 (you get back the same number - the decimal equivalent) 

If you XOR any number with 1 you get the complement(opposite) of the number

-     A ^ 1 = Ā (A complement)
-     0 ^ 1 = 1 (the opposite of 0 )

If you XOR any number with itself you will get zero (because there exist no exclusive)

-     A ^ A = 0