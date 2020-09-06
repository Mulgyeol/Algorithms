def quick_select(L,k):
	p = L[0] #pivot
	A = []
	B = []
	M = []

	for i in L:
		if p > i :
			A.append(i)
		elif p < i :
			B.append(i)
		else:
			M.append(i)

	if len(A) >= k:
		return quick_select(A,k)
	elif len(A)+len(M) < k:
		return quick_select(B,k-len(A)-len(M))
	else:
		return p


n, k = map(int,input().split())
L = list(map(int,input().split()))

print(quick_select(L,k))
