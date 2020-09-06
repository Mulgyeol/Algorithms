def frac_knapsack(i,size):
	if i>=n or size <= 0:
		return 0
	B = 0
	count = S[i]
	while(size > 0 and i < n):
		if count == 0:
			i += 1
			if i >= n:
				break
			count = S[i]
		B += cost_ratio[i]
		count -= 1
		size -= 1
	return B

def Knapsack(i,size):

	global MP
	
	if i>=n or size <= 0:	
		return 0
	
	pv = sum(P[j] for j in range(0,i) if X[j] == 1)
	sv = sum(S[j] for j in range(0,i) if X[j] == 1)
	
	if S[i] <= size:
		B = frac_knapsack(i+1, size-S[i])
		if pv + P[i] + B > MP:
			X[i] = 1
			MP = max(MP,pv+P[i])
			Knapsack(i+1,size-S[i])
	
	B2 = frac_knapsack(i+1,size)
	if pv + B2 > MP :
		X[i] = 0
		Knapsack(i+1,size)
		

K = int(input())
n = int(input())
S1 = list(map(int,input().split()))
P1 = list(map(int,input().split()))
S = []
P = []
X = [0] * n
global MP
MP = 0
cost_ratio = [P1[i]/S1[i] for i in range(0,len(P1))]
cost_ratio.sort(reverse=True)

for i in cost_ratio:
	for j in range(len(P1)):
		if (P1[j]/S1[j]) == i:
			P.append(P1[j])
			S.append(S1[j])
			del P1[j]
			del S1[j]
			break
			
			
Knapsack(0,K)
print(MP)

