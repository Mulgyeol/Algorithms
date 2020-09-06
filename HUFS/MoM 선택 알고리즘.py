def find_median_five(L):
	if L[0] > L[1]:
		win1 = L[0]
		lose1 = L[1]
	else:
		win1 = L[1]
		lose1 = L[0]
		
	if L[2] > L[3]:
		win2 = L[2]
		lose2 = L[3]
	else:
		win2 = L[3]
		lose2 = L[2]
		
	if win1 > win2:
		if L[4] > lose1:
			win1 = L[4]
		else:
			win1 = lose1
			lose1 = L[4]
	else:
		if L[4] > lose2:
			win2 = L[4]
		else:
			win2 = lose2
			lose2 = L[4]
	
	if (win1 > win2):
		if win2 > lose1:
			return win2
		else:
			return lose1
	else:
		if win1 > lose2:
			return win1
		else:
			return lose2
		
	

def MoM(L, k): # L의 값 중에서 k번째로 작은 수 리턴
	if len(L) == 1: # no more recursion
		return L[0]
	i = 0
	A, B, M, medians = [], [], [], []
	while i+4 < len(L):
		medians.append(find_median_five(L[i: i+5]))
		i = i+5

	if i < len(L) and i+4 >= len(L):
		#L[i:len(L)] 중간 값을 median에 집어 넣기
		if len(L) -i == 5:
			medians.append(find_median_five(L[i: i+5]))
		elif len(L) -i == 1 or len(L) -i == 2:
			medians.append(L[i])
		elif len(L) - i == 3:
			if L[i] > L[i+1]:
				if L[i] > L[i+2]:
					if L[i+1] > L[i+2]:
						medians.append(L[i+1])
					else:
						medians.append(L[i+2])
				else:
					medians.append(L[i])
			elif L[i] < L[i+1]:
				if L[i+1] > L[i+2]:
					if L[i+2] >L[i]:
						medians.append(L[i+2])
					else:
						medians.append(L[i])
				else:
					medians.append(L[i+1])
			else:
				medians.append(L[i])
				
		else:
			if L[i]>L[i+1]:
				win1 = L[i]
				lose1 = L[i+1]
			else:
				win1 = L[i+1]
				lose1 = L[i]
				
			if L[i+2]>L[i+3]:
				win2 = L[i+2]
				lose2 = L[i+3]
			else:
				win2 = L[i+3]
				lose2 = L[i+2]
				
			if win1 > win2:
				if win2 > lose1:
					if lose1 > lose2:
						medians.append(lose1)
					else:
						medians.append(lose2)
				else:
					medians.append(win2)
			else:
				if win1 > lose2:
					if lose2 > lose1:
						medians.append(lose2)
					else:
						medians.append(lose1)
				else:
					medians.append(win1)
			
	mom = MoM(medians,len(medians)//2)
	for v in L:
		if v < mom: A.append(v)
		elif v > mom: B.append(v)
		else: M.append(v)
			
	if len(A) >= k: 
		return MoM(A,k)
	elif len(A)+len(M) < k: 
		return MoM(B,k-len(A)-len(M))
	else:
		return mom

# n과 k를 입력의 첫 줄에서 읽어들인다
# n개의 정수를 읽어들인다. (split 이용 + int로 변환)

n, k = map(int,input().split())
L = list(map(int,input().split()))

print(MoM(L, k))
