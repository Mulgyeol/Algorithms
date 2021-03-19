import sys

n_len = int(sys.stdin.readline())
n = list(map(int, sys.stdin.readline().split()))
n_len = len(n)
maxPro = 0
minPrice = n[0]
maxPrice = 0

maxProMinPrice = n[0]
maxProMaxPRice = 0

for i in range(1,n_len):
    profit = n[i] - minPrice
    if profit > maxPro:
        maxPro = profit
        maxPrice = n[i]

        maxProMinPrice = minPrice
        maxProMaxPrice = maxPrice
        
    if profit == maxPro:
        maxProMinPrice = minPrice
        maxProMaxPrice = n[i]
        
    if profit < 0:
        minPrice = n[i]

if(maxPro > 0):
    print(maxPro)
    print(maxProMinPrice, maxProMaxPrice)
else:
    print(-1)

