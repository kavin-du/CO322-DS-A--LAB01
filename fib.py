#!/usr/bin/python
import numpy as np
import time
import matplotlib.pyplot as plt

def fib_r(x) :
    if (x <= 2):
        return 1
    return fib_r(x-1) + fib_r(x-2)


def fib_i(x) :
    a = 1
    b = 1
    fib = 1
    i = 2
    while i < x:
        fib = a +b
        a = b
        b = fib
        i+=1
        
    return fib

# x = 40
# print ("Fib of " + str(x) + " = " + str(fib_r(x)))
# print ("Fib of " + str(x) + " = " + str(fib_i(x)))

recurTimeArray = []
iterTimeArray = []


for i in range(1,41):
    recurStartTime = time.time() # start time
    val1 = fib_r(i)
    recurEndTime = time.time() # end time

    recurTimeArray.append((recurEndTime-recurStartTime)*(10**9))

    iterStartTime = time.time() # start time
    val2 = fib_i(i)
    iterEndTime = time.time() # end time

    iterTimeArray.append((iterEndTime-iterStartTime)*(10**9))

#printing values
for i in range(40):
    print(""+str(i+1)+" recur: "+str(recurTimeArray[i])+"ns, iter: "+str(iterTimeArray[i])+"ns")


# plotting graph
x = np.arange(1, 41, 1) # x axis

plt.plot(x, recurTimeArray, label="recursive approach")
plt.plot(x, iterTimeArray, label="iterative approach")

plt.xlabel('number')
plt.ylabel('time to execute/ns')

plt.title('Fibbonacci number execution')
plt.legend()
plt.show()

